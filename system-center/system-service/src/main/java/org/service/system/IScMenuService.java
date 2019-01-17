package org.service.system;

import java.util.List;

import org.dto.system.ScMenuDto;
import org.entity.system.ScMenu;
import org.entity.system.ScSetting;
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
	DataResult<ScMenu> navs(String userCode);

	/**
	 * 
	 * 方法: status <br>
	 * 描述: 获取菜单状态列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2018年12月25日 下午3:04:34
	 * 
	 * @return
	 */
	List<ScSetting> status();

	/**
	 * 
	 * 方法: parent <br>
	 * 描述: 获取可选的所有菜单父级 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月14日 下午4:22:54
	 * 
	 * @return
	 */
	List<ScMenu> parent();
}