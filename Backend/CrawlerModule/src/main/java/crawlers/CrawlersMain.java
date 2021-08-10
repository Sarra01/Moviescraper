package crawlers;

import java.util.ArrayList;

public class CrawlersMain {
	
	public static void main (String[] args) 
	{
		ChillCrawler chillCrawler=new ChillCrawler();
		chillCrawler.crawl(1, "https://123chill.to/21-bridges-watch-online/", new ArrayList<String>() , 10);
		
	}

}
