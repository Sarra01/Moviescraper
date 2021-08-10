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

import crawlers.PrimewireCrawler;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PrimewireCrawlerTest {

	
	
	@Autowired 
	PrimewireCrawler primewireCrawler;
	
	@Test
	@Rollback(false)
	void crawlTest() {
		String exampleUrl="";
		primewireCrawler.crawl(10, exampleUrl, new ArrayList<String>());
		assertThat(primewireCrawler.getUrlList()).isNotNull();
		assertThat(primewireCrawler.getNameList()).isNotNull();
		
	}
	@Test
	@Rollback(false)
	void crawlSetTest()
	{
		String exampleUrl="";
		primewireCrawler.crawl(10, exampleUrl, new ArrayList<String>());
		primewireCrawler.setUrlList(null);
		primewireCrawler.setNameList(null);
		
		assertEquals(primewireCrawler.getUrlList(),null);
		assertEquals(primewireCrawler.getNameList(),null);
		
	}

}
