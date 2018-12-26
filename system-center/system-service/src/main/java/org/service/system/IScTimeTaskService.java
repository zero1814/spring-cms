package org.service.system;

import java.util.List;

import org.dto.system.ScTimeTaskDto;
import org.entity.system.ScSetting;
import org.entity.system.ScTimeTask;
import org.zero.spring.mybatis.IBaseService;

/**
 * 
 * 类: ScTimeTask <br>
 * 描述: 定时任务表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:31:56
 */
public interface IScTimeTaskService extends IBaseService<ScTimeTask, ScTimeTaskDto> {
	/**
	 * 
	 * 方法: types <br>
	 * 描述: 类型 <br>
	 * 作者: zhy<br>
	 * 时间: 2018年12月25日 上午9:55:39
	 * 
	 * @return
	 */
	List<ScSetting> types();

	/**
	 * 
	 * 方法: status <br>
	 * 描述: 状态 <br>
	 * 作者: zhy<br>
	 * 时间: 2018年12月25日 上午9:55:46
	 * 
	 * @return
	 */
	List<ScSetting> status();
}