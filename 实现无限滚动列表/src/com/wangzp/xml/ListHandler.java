package com.wangzp.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.wangzp.bean.ListBean;
import com.wangzp.bean.ListItemBean;

/**
 * 列表接口
 * 
 * @author wangzp
 * 
 */
public class ListHandler extends DefaultHandler {
	private String c;

	public ListBean listBean = new ListBean();

	private ListItemBean item = new ListItemBean();

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		String part = new String(ch, start, length);
		if (!part.equals("\n"))
			if (c != null)
				c += part;
			else
				c = part;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if (c != null)
			c = c.trim();
		if (localName.equalsIgnoreCase("error")) {
			listBean.setError(c);
		} else if (localName.equalsIgnoreCase("msg")) {
			listBean.setMsg(c);
		} else if (localName.equalsIgnoreCase("pageindex")) {
			listBean.setPageindex(Integer.parseInt(c));
		} else if (localName.equalsIgnoreCase("pagerow")) {
			listBean.setPagerow(Integer.parseInt(c));
		} else if (localName.equalsIgnoreCase("count")) {
			listBean.setCount(Integer.parseInt(c));
		} else if (localName.equalsIgnoreCase("pagecount")) {
			listBean.setPagecount(Integer.parseInt(c));
		} else if (localName.equalsIgnoreCase("item")) {
			if (item != null) {
				listBean.addListItemBase(item);
			}
			item = new ListItemBean();
		} else if (localName.equalsIgnoreCase("contentid")) {
			item.setContentID(c);
		} else if (localName.equalsIgnoreCase("channelid")) {
			item.setChannelID(c);
		} else if (localName.equalsIgnoreCase("title")) {
			item.setTitle(c);
		} else if (localName.equalsIgnoreCase("imageurl")) {
			item.setImageUrl(c);
		} else if (localName.equalsIgnoreCase("summary")) {
			item.setSummary(c);
		} else if (localName.equalsIgnoreCase("adddate")) {
			item.setAddDate(c);
		}
		c = null;
	}
}
