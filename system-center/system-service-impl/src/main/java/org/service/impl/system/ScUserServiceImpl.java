package org.service.impl.system;

import java.util.List;

import org.dto.system.ScUserDto;
import org.entity.system.ScSetting;
import org.entity.system.ScUser;
import org.entity.system.ScUserExtends;
import org.mapper.system.ScSettingMapper;
import org.mapper.system.ScUserExtendsMapper;
import org.mapper.system.ScUserMapper;
import org.service.system.IScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

import zero.commons.basics.DateUtil;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.BaseResult;

/**
 * 
 * 类: ScUserInfoServiceImpl <br>
 * 描述: 管理员表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:34:06
 */
@Service
public class ScUserServiceImpl extends BaseServiceImpl<ScUser, ScUserMapper, ScUserDto> implements IScUserService {

	@Autowired
	private ScSettingMapper settingMapper;
	@Autowired
	private ScUserExtendsMapper extendsMapper;

	@Value("${system.user.type}")
	private String typeCode;

	@Value("${system.user.status}")
	private String statusCode;

	@Override
	public BaseResult insert(ScUser entity) {
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
		return super.insert(entity);
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
		return settingMapper.selectSetting(typeCode);
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
		return settingMapper.selectSetting(statusCode);
	}
}