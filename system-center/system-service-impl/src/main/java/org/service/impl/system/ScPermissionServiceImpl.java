package org.service.impl.system;

import org.dto.system.ScPermissionDto;
import org.entity.system.ScPermission;
import org.mapper.system.ScPermissionMapper;
import org.service.system.IScPermissionService;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

/**
 * 
 * 类: ScPermissionServiceImpl <br>
 * 描述: 权限表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:24:12
 */
@Service
public class ScPermissionServiceImpl extends BaseServiceImpl<ScPermission, ScPermissionMapper, ScPermissionDto>
		implements IScPermissionService {
}