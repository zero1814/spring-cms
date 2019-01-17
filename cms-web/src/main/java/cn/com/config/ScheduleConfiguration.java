package cn.com.config;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;

import org.dto.system.ScTimeTaskDto;
import org.entity.system.ScTimeTask;
import org.mapper.system.ScTimeTaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import cn.com.scheduled.RootScheduled;

/**
 * 
 * 类: ScheduleConfiguration <br>
 * 描述: 定时任务配置类 <br>
 * 作者: zhy<br>
 * 时间: 2019年1月16日 下午4:27:40
 */
@Configuration
@EnableScheduling
public class ScheduleConfiguration implements SchedulingConfigurer {

	private static Logger logger = LoggerFactory.getLogger(ScheduleConfiguration.class);

	@Value("${scheduled.pool.size}")
	private int poolSize;// 线程池大小

	@Autowired
	private ScTimeTaskMapper mapper;

	@SuppressWarnings("rawtypes")
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(Executors.newScheduledThreadPool(poolSize));
		try {
			List<ScTimeTask> list = mapper.selectAll(new ScTimeTaskDto());
			System.out.println("mapper = " + mapper);
			if (list != null && list.size() > 0) {
				for (ScTimeTask task : list) {
					Class clazz = Class.forName(task.getExecClass());
					if (clazz != null) {
						RootScheduled scheduled = (RootScheduled) clazz.newInstance();
						if (scheduled != null) {
							taskRegistrar.addTriggerTask(scheduled, new Trigger() {
								@Override
								public Date nextExecutionTime(TriggerContext triggerContext) {
									String cron = task.getTime();
									CronTrigger trigger = new CronTrigger(cron);
									Date next = trigger.nextExecutionTime(triggerContext);
									return next;
								}
							});
						} else {
							logger.error("类'" + task.getExecClass() + "'没有继承RootScheduled");
						}
					} else {
						logger.error("类'" + task.getExecClass() + "'没有继承RootScheduled");
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
