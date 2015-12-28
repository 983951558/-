package com.vanroid.gduf.entity;
/**
 * 
 * @author CGZ
 *图书馆搜索历史
 */
public class LibrarySearchHistory {
	/**
	 * 主键
	 * 32位uuid
	 */
	private String hId;	
	/**
	 * 关键字
	 */
	private String keywords;
	/**
	 * 页码
	 */
	private int page;
	/**
	 * 对应关键字总记录
	 */
	private int total;
	public String getHId() {
		return hId;
	}
	public void setHId(String hId) {
		this.hId = hId;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
