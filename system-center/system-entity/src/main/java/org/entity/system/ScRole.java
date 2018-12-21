package org.entity.system;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScRole <br>
 * 描述: 角色表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:24:52
 */
public class ScRole extends BaseEntity {

	private static final long serialVersionUID = -4068214702099341222L;

	/**
	 * 名称
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}