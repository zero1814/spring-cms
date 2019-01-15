package org.entity.system;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScUserExtends <br>
 * 描述: 管理员扩展表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午4:26:49
 */
public class ScUserExtends extends BaseEntity {

	private static final long serialVersionUID = 7745302824520506439L;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 头像
	 */
	private String headerPic;

	public String getHeaderPic() {
		return headerPic;
	}

	public void setHeaderPic(String headerPic) {
		this.headerPic = headerPic;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

}