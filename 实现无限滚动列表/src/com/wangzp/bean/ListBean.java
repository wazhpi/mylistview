package com.wangzp.bean;

import java.util.ArrayList;
import java.util.List;

import android.text.TextUtils;

/**
 * �б�
 * @author ����ƽ
 *
 */
public class ListBean {
	
	//�����ʶ
	private String error;
	//������Ϣ
	private String msg;
	
	//��ǰҳ��
	private int pageindex;
	//ÿҳ��ʾ����
	private int pagerow;
	//��ҳ��
	private int pagecount;
	//������
	private int count;
	//ÿҳ�����б�
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
