package org.entity.system;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScPermission <br>
 * 描述: 权限表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:24:12
 */
public class ScPermission extends BaseEntity {

	private static final long serialVersionUID = 1904227646431798640L;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 英文名称
	 */
	private String enName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

}