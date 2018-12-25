package org.mapper.system;

import java.util.List;

import org.dto.system.ScMenuDto;
import org.entity.system.ScMenu;
import org.zero.spring.mybatis.IBaseMapper;

/**
 * 
 * 类: ScMenuMapper <br>
 * 描述: 系统菜单数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:12:38
 */
public interface ScMenuMapper extends IBaseMapper<ScMenu, ScMenuDto> {

	/**
	 * 
	 * 方法: navs <br>
	 * 描述: 获取可显示的菜单列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2018年12月24日 上午11:16:49
	 * 
	 * @return
	 */
	List<ScMenu> navs(String status);
}