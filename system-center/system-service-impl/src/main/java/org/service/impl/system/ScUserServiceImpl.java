package org.service.impl.system;

import java.util.List;

import org.dto.system.ScSettingDto;
import org.dto.system.ScUserDto;
import org.entity.system.ScSetting;
import org.entity.system.ScUser;
import org.mapper.system.ScSettingMapper;
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

	@Value("${system.password}")
	private String defaultPassword;

	@Value("${system.user.type}")
	private String typeCode;

	@Value("${system.user.status}")
	private String statusCode;

	@Value("${system.user.header.default}")
	private String defaultHeaderPic;

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

		if (StringUtils.isBlank(entity.getRealName())) {
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
		// 如果没有设置用户头像，取默认头像
		if (StringUtils.isBlank(entity.getHeaderPic())) {
			entity.setHeaderPic(defaultHeaderPic);
		}
		String userName = Pinyin4jUtil.converterToSpell(entity.getRealName());
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

	/**
	 * 
	 * 方法: login <br>
	 * 
	 * @param dto
	 * @return
	 * @see org.service.system.IScUserService#login(org.dto.system.ScUserDto)
	 */
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

	/**
	 * 
	 * 方法: updatePassword <br>
	 * 
	 * @param entity
	 * @param password
	 * @return
	 * @see org.service.system.IScUserService#updatePassword(org.entity.system.ScUser,
	 *      java.lang.String)
	 */
	@Override
	public EntityResult<ScUser> updatePassword(ScUser entity, String password) {
		EntityResult<ScUser> result = new EntityResult<ScUser>();
		if (entity == null) {
			result.setCode(ResultType.NULL);
			result.setMessage("用户不存在");
			return result;
		}
		if (StringUtils.isBlank(password)) {
			result.setCode(ResultType.NULL);
			result.setMessage("密码不能为空");
			return result;
		}
		// 密码MD5转码
		password = MD5Util.md5Hex(password);
		if (StringUtils.equals(password, entity.getPassword())) {
			result.setCode(ResultType.ERROR);
			result.setMessage("密码不能与原密码相同");
			return result;
		}
		logger.info("用户'" + entity.getRealName() + "'，进行密码修改");
		try {
			ScUser updateEntity = new ScUser();
			updateEntity.setCode(entity.getCode());
			updateEntity.setPassword(password);
			updateEntity.setUpdateUser(entity.getCode());
			updateEntity.setUpdateTime(DateUtil.curSystemTime());
			mapper.update(updateEntity);
			logger.info("用户'" + entity.getRealName() + "'，密码修改完成，原密码：" + entity.getPassword() + ",新密码：" + password);
			ScUser user = mapper.select(entity.getCode());
			result.setCode(ResultType.SUCCESS);
			result.setEntity(user);
			result.setMessage("密码修改完成");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("用户'" + entity.getRealName() + "'，密码修改报错，错误原因：" + e.getMessage());
		}
		return result;
	}

}