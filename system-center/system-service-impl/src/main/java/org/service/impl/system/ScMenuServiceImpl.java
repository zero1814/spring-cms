package org.service.impl.system;

import org.dto.system.ScMenuDto;
import org.entity.system.ScMenu;
import org.mapper.system.ScMenuMapper;
import org.service.system.IScMenuService;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

/**
 * 
 * 类: ScMenuServiceImpl <br>
 * 描述: 系统菜单业务接口实现类<br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 上午11:59:08
 */
@Service
public class ScMenuServiceImpl extends BaseServiceImpl<ScMenu, ScMenuMapper, ScMenuDto> implements IScMenuService {
}