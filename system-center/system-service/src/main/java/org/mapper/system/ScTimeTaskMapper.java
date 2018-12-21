package org.mapper.system;

import org.dto.system.ScTimeTaskDto;
import org.entity.system.ScTimeTask;
import org.zero.spring.mybatis.IBaseMapper;

/**
 * 
 * 类: ScTimeTaskMapper <br>
 * 描述: 定时任务表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:25:18
 */
public interface ScTimeTaskMapper extends IBaseMapper<ScTimeTask, ScTimeTaskDto> {
}