package com.renby.webmagic;

import org.junit.Test;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.SimplePageProcessor;

import com.renby.webmagic.downloader.HttpClientFileDownloader;

public class AppTest {
	@Test
	public void testApp() {
		Spider.create(new SimplePageProcessor("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png","^$")).setDownloader(new HttpClientFileDownloader()).run();
	}
}
