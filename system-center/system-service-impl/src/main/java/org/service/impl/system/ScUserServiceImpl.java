package org.service.impl.system;

import java.util.List;

import org.dto.system.ScSettingDto;
import org.dto.system.ScUserDto;
import org.entity.system.ScSetting;
import org.entity.system.ScUser;
import org.entity.system.ScUserExtends;
import org.mapper.system.ScSettingMapper;
import org.mapper.system.ScUserExtendsMapper;
import org.mapper.system.ScUserMapper;
import org.service.system.IScUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

import zero.commons.basics.DateUtil;
import zero.commons.basics.MD5Util;
import zero.commons.basics.Pinyin4jUtil;
import zero.commons.basics.StringUtils;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

/**
 * 
 * 类: ScUserInfoServiceImpl <br>
 * 描述: 管理员表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:34:06
 */
@Service
public class ScUserServiceImpl extends BaseServiceImpl<ScUser, ScUserMapper, ScUserDto> implements IScUserService {

	private static Logger logger = LoggerFactory.getLogger(ScUserServiceImpl.class);

	@Autowired
	private ScUserMapper mapper;

	@Autowired
	private ScSettingMapper settingMapper;
	@Autowired
	private ScUserExtendsMapper extendsMapper;

	@Value("${system.password}")
	private String defaultPassword;

	@Value("${system.user.type}")
	private String typeCode;

	@Value("${system.user.status}")
	private String statusCode;

	/**
	 * 
	 * 方法: insert <br>
	 * 
	 * @param entity
	 * @return
	 * @see org.zero.spring.mybatis.BaseServiceImpl#insert(org.zero.spring.mybatis.BaseEntity)
	 */
	@Override
	public BaseResult insert(ScUser entity) {
		BaseResult result = new BaseResult();

		if (StringUtils.isBlank(entity.getExtend().getRealName())) {
			result.setCode(ResultType.ERROR);
			result.setMessage("姓名不能为空");
			return result;
		} else if (StringUtils.isBlank(entity.getPhone())) {
			result.setCode(ResultType.ERROR);
			result.setMessage("手机号不能为空");
			return result;
		} else if (StringUtils.isBlank(entity.getEmail())) {
			result.setCode(ResultType.ERROR);
			result.setMessage("电子邮箱不能为空");
			return result;
		}

		String userName = Pinyin4jUtil.converterToSpell(entity.getExtend().getRealName());
		// 查询用户是否已存在
		ScUserDto dto = new ScUserDto();
		dto.setPhone(entity.getPhone());
		dto.setEmail(entity.getEmail());
		dto.setUserName(userName);
		ScUser user = mapper.verify(dto);
		if (user != null) {
			result.setCode(ResultType.ERROR);
			result.setMessage("用户已存在，请重新添加");
			return result;
		}

		/**
		 * 添加用户
		 */
		String createTime = DateUtil.curSystemTime();
		entity.setCreateTime(createTime);
		if (entity.getExtend() != null) {
			ScUserExtends extend = entity.getExtend();
			extend.setUid(CodeHelper.getUUID());
			extend.setCode(entity.getCode());
			extend.setCreateUser(entity.getCreateUser());
			extend.setCreateTime(createTime);
			extendsMapper.insert(entity.getExtend());
		}
		entity.setUserName(userName);
		entity.setPassword(MD5Util.md5Hex(defaultPassword));
		return super.insert(entity);
	}

	@Override
	public BaseResult update(ScUser entity) {
		logger.info("开始执行update(T entity)方法");
		BaseResult result = new BaseResult();
		if (entity == null) {
			result.setCode(ResultType.ERROR);
			result.setMessage("参数对象不能为空");
			return result;
		}
		try {
			ScUser t = mapper.select(entity.getCode());
			if (t == null) {
				result.setCode(ResultType.NULL);
				result.setMessage("对象不存在");
				return result;
			}
			if (StringUtils.isBlank(entity.getUpdateTime())) {
				entity.setUpdateTime(DateUtil.curSystemTime());
			}
			if (entity.getExtend() != null) {
				ScUserExtends user = extendsMapper.select(entity.getCode());
				if (user != null) {
					entity.getExtend().setCode(entity.getCode());
					entity.getExtend().setUpdateUser(entity.getUpdateUser());
					entity.getExtend().setUpdateTime(entity.getUpdateTime());
					extendsMapper.update(entity.getExtend());
				}
			}
			mapper.update(entity);
			result.setCode(ResultType.SUCCESS);
			result.setMessage("执行编辑方法成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultType.ERROR);
			result.setMessage("执行update(T entity)报错");
			logger.error("执行update(T entity)报错，错误原因：" + e.getMessage());
		} finally {
			logger.info("执行update(T entity)方法结束");
		}
		return result;
	}

	/**
	 * 
	 * 方法: types <br>
	 * 
	 * @return
	 * @see org.service.system.IScUserService#types()
	 */
	@Override
	public List<ScSetting> types() {
		ScSettingDto dto = new ScSettingDto();
		dto.setParentCode(typeCode);
		return settingMapper.selectAll(dto);
	}

	/**
	 * 
	 * 方法: status <br>
	 * 
	 * @return
	 * @see org.service.system.IScUserService#status()
	 */
	@Override
	public List<ScSetting> status() {
		ScSettingDto dto = new ScSettingDto();
		dto.setParentCode(statusCode);
		return settingMapper.selectAll(dto);
	}

	@Override
	public EntityResult<ScUser> login(ScUserDto dto) {
		EntityResult<ScUser> result = new EntityResult<ScUser>();
		if (StringUtils.isBlank(dto.getUserName())) {
			result.setCode(ResultType.NULL);
			result.setMessage("用户名不能为空");
			return result;
		}
		if (StringUtils.isBlank(dto.getPassword())) {
			result.setCode(ResultType.NULL);
			result.setMessage("密码不能为空");
			return result;
		}
		dto.setPassword(MD5Util.md5Hex(dto.getPassword()));
		ScUser user = mapper.login(dto);
		if (user == null) {
			result.setCode(ResultType.NULL);
			result.setMessage("用户不存在");
			return result;
		}
		result.setCode(ResultType.SUCCESS);
		result.setEntity(user);
		result.setMessage("登录成功");
		return result;
	}

	@Override
	public BaseResult delete(String code) {
		ScUserExtends extend = extendsMapper.select(code);
		if (extend != null) {
			extendsMapper.delete(code);
		}
		return super.delete(code);
	}

}