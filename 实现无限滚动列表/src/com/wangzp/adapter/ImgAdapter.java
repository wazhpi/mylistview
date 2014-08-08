package com.wangzp.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangzp.bean.ListItemBase;
import com.wangzp.bean.ListItemBean;
import com.wangzp.mylistview.R;

public class ImgAdapter extends BaseAdapter {

	private Context context;
	private List<ListItemBase> list;
	
	
	
	class ListAdapterItem {
		public ImageView pic;
		public TextView title;
		public TextView summary;
		public TextView addDate;
	}
	
	public ImgAdapter(Context context,List<ListItemBase> list) {
		// TODO Auto-generated constructor stub
		
		this.context=context;
		this.list=list;
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ListAdapterItem item;
		if (null == convertView) {
			item = new ListAdapterItem();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.m_list_item, null);

			item.pic = (ImageView) convertView.findViewById(R.id.m_item_pic);
			item.title = (TextView) convertView.findViewById(R.id.m_item_title);
			item.summary = (TextView) convertView
					.findViewById(R.id.m_item_summary);
			item.addDate = (TextView) convertView
					.findViewById(R.id.m_item_addDate);

			convertView.setTag(item);
		} else {
			item = (ListAdapterItem) convertView.getTag();
		}
		final ListItemBean bean = (ListItemBean) list.get(position);
		
		item.title.setText(bean.getTitle());
		item.summary.setText(bean.getSummary());
		item.addDate.setText(bean.getAddDate());
		
		return convertView;
	}

}
