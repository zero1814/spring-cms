package org.dto.system;

import org.zero.spring.mybatis.BaseDto;

/**
 * 
 * 类: ScUserInfoDto <br>
 * 描述: 管理员参数类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:09:39
 */
public class ScUserDto extends BaseDto {

	private static final long serialVersionUID = -4452527829652908866L;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 用户名
	 */
	private String userName;

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

	/**
	 * 状态
	 */
	private String status;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

}
