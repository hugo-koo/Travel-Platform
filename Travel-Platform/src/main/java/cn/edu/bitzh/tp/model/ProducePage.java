package cn.edu.bitzh.tp.model;

/*
 * @author  周锦涛
 * @date  2020年
 * 
 * 产品分页实体类
 * */


import java.util.List;

public class ProducePage <T>{
	private int currPage;//当前页数
	private int pageSize;//每页显示的记录数
	private int totalCount;//总记录数
	private int totalPage;//总页数
	private List <T> pageList;//每页显示的数据
	private List <String> advertisingMap;
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	public List<String> getAdvertisingMap() {
		return advertisingMap;
	}
	public void setAdvertisingMap(List<String> advertisingMap) {
		this.advertisingMap = advertisingMap;
	}
	@Override
	public String toString() {
		return "ProducePage [currPage=" + currPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", pageList=" + pageList + ", advertisingMap=" + advertisingMap + "]";
	}
	public ProducePage(int currPage, int pageSize, int totalCount, int totalPage, List<T> pageList,
			List<String> advertisingMap) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.pageList = pageList;
		this.advertisingMap = advertisingMap;
	}
	public ProducePage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	
}
