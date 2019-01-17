package cn.com.scheduled;

import org.service.system.IScUserService;
import org.springframework.stereotype.Component;

import cn.com.util.SpringUtil;
import zero.commons.basics.DateUtil;

@Component
public class TestScheduled implements RootScheduled {

	@Override
	public void run() {
		IScUserService service = SpringUtil.getBean(IScUserService.class);
		service.select("SU1085362996009496576");
		System.out.println("开始执行测试定时任务-------->" + DateUtil.curSystemTime());
	}

}
