package com.ybt.pojo;

import java.util.List;

public class Page {
	private List<?> records;
	private int pagesize = 8;
	private int pagenum;
	private int startIndex;
	private int totalpage;
	private int totalrecords;

	private int startPage;
	private int endPage;

	private String servletUrl;

	public Page(int pagenum, int totalrecords) {
		this.pagenum = pagenum;
		this.totalrecords = totalrecords;
		startIndex = (pagenum - 1) * pagesize;
		totalpage = totalrecords % pagesize == 0 ? totalrecords / pagesize : (totalrecords / pagesize + 1);
		if (totalpage <= 9) {
			startPage = 1;
			endPage = totalpage;
		} else {
			startPage = pagenum - 4;
			endPage = pagenum + 4;
			if (startPage < 1) {
				startPage = 1;
				endPage = 9;
				if (endPage > totalpage) {
					endPage = totalpage;
					startPage = totalpage - 8;
				}
			}
		}
	}

	public List<?> getRecords() {
		return records;
	}

	public void setRecords(List<?> records) {
		this.records = records;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getTotalrecords() {
		return totalrecords;
	}

	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getServletUrl() {
		return servletUrl;
	}

	public void setServletUrl(String servletUrl) {
		this.servletUrl = servletUrl;
	}

}
