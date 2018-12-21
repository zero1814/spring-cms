package org.dto.system;

import org.zero.spring.mybatis.BaseDto;

/**
 * 
 * 类: ScTimeTaskDto <br>
 * 描述: 定时任务参数类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:08:16
 */
public class ScTimeTaskDto extends BaseDto {

	private static final long serialVersionUID = -7701721932065067076L;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 状态
	 */
	private String status;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
