package com.wangzp.bean;

import java.util.ArrayList;
import java.util.List;

import android.text.TextUtils;

/**
 * 列表
 * @author 王正平
 *
 */
public class ListBean {
	
	//错误标识
	private String error;
	//错误信息
	private String msg;
	
	//当前页码
	private int pageindex;
	//每页显示行数
	private int pagerow;
	//总页数
	private int pagecount;
	//总条数
	private int count;
	//每页数据列表
	private List<ListItemBase> list=new ArrayList<ListItemBase>();
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagerow() {
		return pagerow;
	}
	public void setPagerow(int pagerow) {
		this.pagerow = pagerow;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<ListItemBase> getList() {
		return list;
	}
	public void setList(List<ListItemBase> list) {
		this.list = list;
	}
	
	public void addListItemBase(ListItemBase item){
		list.add(item);
	}

}
