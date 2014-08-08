package com.wangzp.bean;

import java.util.List;

import android.text.TextUtils;

/**
 * 列表项
 * @author 王正平
 *
 */
public class ListItemBean extends ListItemBase {
	
	//内容ID
	private String contentID;
	//栏目ID
	private String channelID;
	//标题
	private String title;
	//图片
	private String imageUrl;
	//简要
	private String summary;
	//添加时间
	private String addDate;
	
	public String getContentID() {
		return contentID;
	}
	public void setContentID(String contentID) {
		this.contentID = contentID;
	}
	public String getChannelID() {
		return channelID;
	}
	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

}
