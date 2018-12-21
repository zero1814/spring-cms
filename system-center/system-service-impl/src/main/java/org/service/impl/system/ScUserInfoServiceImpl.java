package org.service.impl.system;

import org.dto.system.ScUserInfoDto;
import org.entity.system.ScUser;
import org.mapper.system.ScUserInfoMapper;
import org.service.system.IScUserInfoService;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

/**
 * 
 * 类: ScUserInfoServiceImpl <br>
 * 描述: 管理员表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:34:06
 */
@Service
public class ScUserInfoServiceImpl extends BaseServiceImpl<ScUser, ScUserInfoMapper, ScUserInfoDto>
		implements IScUserInfoService {
}