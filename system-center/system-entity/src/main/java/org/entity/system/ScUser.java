package org.entity.system;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScUser <br>
 * 描述: 管理员表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午4:25:32
 */
public class ScUser extends BaseEntity {

	private static final long serialVersionUID = 3058599019810489128L;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 电子邮箱
	 */
	private String email;

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
	 * 用户扩展信息
	 */
	private ScUserExtends extend;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ScUserExtends getExtend() {
		return extend;
	}

	public void setExtend(ScUserExtends extend) {
		this.extend = extend;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}