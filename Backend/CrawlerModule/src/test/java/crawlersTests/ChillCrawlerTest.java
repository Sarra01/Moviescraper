package crawlersTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import crawlers.ChillCrawler;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ChillCrawlerTest {
	@Autowired 
	ChillCrawler chillCrawler;
	
	@Test
	@Rollback(false)
	void crawlTest() {
		String exampleUrl="https://123chill.to/movies/";
		chillCrawler.crawl(10, exampleUrl, new ArrayList<String>(),15);
		assertThat(chillCrawler.getUrlList()).isNotNull();
		assertThat(chillCrawler.getNameList()).isNotNull();
		
	}
	@Test
	@Rollback(false)
	void crawlSetTest()
	{
		String exampleUrl="https://123chill.to/movies/";
		chillCrawler.crawl(10, exampleUrl, new ArrayList<String>(),100);
		
		assertEquals(chillCrawler.getUrlList().size(),100);
		assertEquals(chillCrawler.getNameList().size(),100);
		
	}
	

}
