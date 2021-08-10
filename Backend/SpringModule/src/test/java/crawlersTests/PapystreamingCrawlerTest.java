package crawlersTests;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import crawlers.PapystreamingCrawler;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@EnableAutoConfiguration
@ContextConfiguration

public class PapystreamingCrawlerTest {

	@Test
	@Rollback(false)
	void listTester()
	{
		PapystreamingCrawler papystreamingCrawler=new PapystreamingCrawler();
		ArrayList <String> list=new ArrayList<>();
		papystreamingCrawler.crawl(5, "", list, 10);
		assertEquals(papystreamingCrawler.getNameList().size(),10);
		assertEquals(papystreamingCrawler.getUrlList().size(),10);

	}
	void elementTester()
	{
		PapystreamingCrawler papystreamingCrawler=new PapystreamingCrawler();
		ArrayList <String> list=new ArrayList<>();
		papystreamingCrawler.crawl(5, "", list, 10);
		for (String e:list) {
			assertNotNull(e);
		}
		
	}
	
	

}
