package com.renby.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.ResultItems;

public class ExtendPage extends Page{
	private byte[] contentBytes;

	private String contentType;
	
	private String contentCharset;
	
	private ExtendResultItems resultItems = new ExtendResultItems();
	
	public byte[] getContentBytes() {
		return contentBytes;
	}

	public void setContentBytes(byte[] contentBytes) {
		this.contentBytes = contentBytes;
		resultItems.setContentBytes(contentBytes);
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String responseType) {
		this.contentType = responseType;
		resultItems.setContentType(responseType);
	}

	public String getContentCharset() {
		return contentCharset;
	}

	public void setContentCharset(String contentCharset) {
		this.contentCharset = contentCharset;
	}
	
    public Page setSkip(boolean skip) {
        resultItems.setSkip(skip);
        return this;

    }

    public void putField(String key, Object field) {
        resultItems.put(key, field);
    }

    public void setRequest(Request request) {
        super.setRequest(request);
        resultItems.setRequest(request);
    }

    public ResultItems getResultItems() {
        return resultItems;
    }
}
