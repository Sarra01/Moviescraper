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
import crawlers.MoviestarsCrawler;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MoviestarsCrawlerTest {
	
	
	@Autowired 
	MoviestarsCrawler moviestarsCrawler;
	
	@Test
	@Rollback(false)
	void crawlTest() {
		String exampleUrl="";
		moviestarsCrawler.crawl(10, exampleUrl, new ArrayList<String>());
		assertThat(moviestarsCrawler.getUrlList()).isNotNull();
		assertThat(moviestarsCrawler.getNameList()).isNotNull();
		
	}
	@Test
	@Rollback(false)
	void crawlSetTest()
	{
		String exampleUrl="";
		moviestarsCrawler.crawl(10, exampleUrl, new ArrayList<String>());
		moviestarsCrawler.setUrlList(null);
		moviestarsCrawler.setNameList(null);
		
		assertEquals(moviestarsCrawler.getUrlList(),null);
		assertEquals(moviestarsCrawler.getNameList(),null);
		
	}


}
