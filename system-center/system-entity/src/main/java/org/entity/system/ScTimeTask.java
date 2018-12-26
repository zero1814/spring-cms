package org.entity.system;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScTimeTask <br>
 * 描述: 定时任务表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:31:56
 */
public class ScTimeTask extends BaseEntity {

	private static final long serialVersionUID = -4380493980507935607L;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 执行时间
	 */
	private String time;

	/**
	 * 执行类
	 */
	private String execClass;

	/**
	 * 类型
	 */
	private String type;

	private String typeName;
	/**
	 * 状态
	 */
	private String status;

	private String statusName;

	/**
	 * 描述
	 */
	private String description;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getExecClass() {
		return execClass;
	}

	public void setExecClass(String execClass) {
		this.execClass = execClass;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}