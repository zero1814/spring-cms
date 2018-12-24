package org.service.system;

import org.dto.system.ScMenuDto;
import org.entity.system.ScMenu;
import org.zero.spring.mybatis.IBaseService;

import zero.commons.basics.result.DataResult;

/**
 * 
 * 类: ScMenu <br>
 * 描述: 系统菜单业务处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 上午11:59:08
 */
public interface IScMenuService extends IBaseService<ScMenu, ScMenuDto> {

	/**
	 * 
	 * 方法: navs <br>
	 * 描述: 获取可显示的菜单栏 <br>
	 * 作者: zhy<br>
	 * 时间: 2018年12月24日 上午11:15:26
	 * 
	 * @return
	 */
	DataResult<ScMenu> navs();
}