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

import crawlers.PapystreamingCrawler;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PapystreamingCrawlerTest {

	
	
	@Autowired 
	PapystreamingCrawler papystreamingCrawler;
	
	@Test
	@Rollback(false)
	void crawlTest() {
		String exampleUrl="";
		papystreamingCrawler.crawl(10, exampleUrl, new ArrayList<String>());
		assertThat(papystreamingCrawler.getUrlList()).isNotNull();
		assertThat(papystreamingCrawler.getNameList()).isNotNull();
		
	}
	@Test
	@Rollback(false)
	void crawlSetTest()
	{
		String exampleUrl="";
		papystreamingCrawler.crawl(10, exampleUrl, new ArrayList<String>());
		papystreamingCrawler.setUrlList(null);
		papystreamingCrawler.setNameList(null);
		
		assertEquals(papystreamingCrawler.getUrlList(),null);
		assertEquals(papystreamingCrawler.getNameList(),null);
		
	}

}
