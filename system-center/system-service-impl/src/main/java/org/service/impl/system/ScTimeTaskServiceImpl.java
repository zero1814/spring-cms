package org.service.impl.system;

import org.dto.system.ScTimeTaskDto;
import org.entity.system.ScTimeTask;
import org.mapper.system.ScTimeTaskMapper;
import org.service.system.IScTimeTaskService;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

/**
 * 
 * 类: ScTimeTaskServiceImpl <br>
 * 描述: 定时任务表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:31:56
 */
@Service
public class ScTimeTaskServiceImpl extends BaseServiceImpl<ScTimeTask, ScTimeTaskMapper, ScTimeTaskDto>
		implements IScTimeTaskService {
}