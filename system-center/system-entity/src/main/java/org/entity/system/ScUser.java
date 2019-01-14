package org.entity.system;

import org.zero.spring.mybatis.BaseEntity;
import org.zero.spring.mybatis.annotation.Insert;

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
	@Insert(vertify = true, alert = "用户名不能为空")
	private String userName;

	/**
	 * 密码
	 */
	@Insert(vertify = true, alert = "密码不能为空")
	private String password;

	/**
	 * 手机号
	 */
	@Insert(vertify = true, alert = "手机号不能为空")
	private String phone;

	/**
	 * 电子邮箱
	 */
	@Insert(vertify = true, alert = "电子邮箱不能为空")
	private String email;

	/**
	 * 类型
	 */
	@Insert(vertify = true, alert = "用户类型不能为空")
	private String type;

	private String typeName;

	/**
	 * 状态
	 */
	@Insert(vertify = true, alert = "用户状态不能为空")
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