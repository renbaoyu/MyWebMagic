package com.renby.webmagic;

import us.codecraft.webmagic.ResultItems;

public class ExtendResultItems extends ResultItems {
	private static final String CONTENT_TYPE = "contentType";
	private static final String CONTENT_BYTES = "contentBytes";
	
	public String getContentType(){
		return super.get(CONTENT_TYPE);
	}
	
	public void setContentType(String contentType){
		super.put(CONTENT_TYPE, contentType);
	}
	
	public byte[] getContentBytes(){
		return super.get(CONTENT_BYTES);
	}
	
	public void setContentBytes(byte[] contentBytes){
		super.put(CONTENT_BYTES, contentBytes);
	}
}
