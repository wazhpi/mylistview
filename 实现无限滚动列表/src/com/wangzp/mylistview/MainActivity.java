package com.wangzp.mylistview;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import com.wangzp.adapter.ImgAdapter;
import com.wangzp.bean.ListBean;
import com.wangzp.bean.ListItemBase;
import com.wangzp.listener.InfiniteScrollListener;
import com.wangzp.smallapple.SmallAppleActivity;
import com.wangzp.smallapple.annotation.view.ViewInject;
import com.wangzp.xml.ListHandler;
import com.wangzp.xml.XmlHandler;

public class MainActivity extends SmallAppleActivity {

	@ViewInject(id = R.id.listView1)
	ListView mListView;

	private XmlHandler xmlhandler = new XmlHandler();
	private ImgAdapter adapter;
	private AsyncHttpClient client;
	
	private List<ListItemBase> beanList;
	private ListBean listBean;
	
	private int pageIndex = 1;
	private int pageCount = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		beanList = new ArrayList<ListItemBase>();
		adapter = new ImgAdapter(this, beanList);
		mListView.setAdapter(adapter);

		mListView.setOnScrollListener(new InfiniteScrollListener(1) {

			@Override
			public void loadMore(int page, int totalItemsCount) {
				// TODO Auto-generated method stub
				System.out.println("page:" + page + ",totalItemsCount:"
						+ totalItemsCount);
				pageIndex = page;
				getData();
			}
		});
		getData();
	}

	private void getData() {
		if (pageIndex > pageCount) {
			return;
		}
		System.out.println("pageIndex:" + pageIndex);
		client = new AsyncHttpClient();
		String url = "http://j.shenguang.com/licaikuaibao/dataAPI.aspx?channelId=13&pageIndex="
				+ pageIndex;
		client.get(url, new TextHttpResponseHandler() {

			@Override
			public void onSuccess(int statusCode, Header[] headers,
					String responseString) {
				// TODO Auto-generated method stub
				ListHandler listHandler = new ListHandler();
				listHandler = (ListHandler) xmlhandler.XMLParse(responseString,
						listHandler);
				listBean = listHandler.listBean;

				pageIndex = listBean.getPageindex();
				pageCount = listBean.getPagecount();

				beanList.addAll(listBean.getList());
				adapter.notifyDataSetChanged();
				show("ตฺ" + pageIndex + "าณ");
			}

			@Override
			public void onFailure(int statusCode, Header[] headers,
					String responseString, Throwable throwable) {
				// TODO Auto-generated method stub
				System.out.println("statusCode:" + statusCode
						+ ",responseString:" + responseString);
			}
		});
	}

	private void show(String text) {
		Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
	}
}
