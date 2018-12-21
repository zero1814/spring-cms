package org.entity.system;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScMenu <br>
 * 描述: 系统菜单 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 上午11:59:08
 */
public class ScMenu extends BaseEntity {

	private static final long serialVersionUID = 7315422781183180936L;

	/**
	 * 父级编码
	 */
	private String parentCode;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 链接地址
	 */
	private String linkUrl;

	/**
	 * 排序
	 */
	private Integer sort;

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}