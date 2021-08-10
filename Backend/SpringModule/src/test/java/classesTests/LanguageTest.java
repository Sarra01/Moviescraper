package classesTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import application.model.Language;
import application.repository.LanguageRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class LanguageTest {

	@Autowired
	private LanguageRepository repForTest;

	@Test
	@Rollback(false)
	void testAddLanguage() {
		Language language = new Language();
		language.getIdLanguage();
		Language languageToAdd = repForTest.save(language);
		long languageId = language.getIdLanguage();
		assertEquals(languageToAdd.getIdLanguage(), languageId);
	}

	@Test
	@Rollback(false)
	void testGetLanguage() {

		Optional<Language> langRep = repForTest.findById(1L);
		Language language = langRep.get();
		long languageId = language.getIdLanguage();
		System.out.println(languageId);
		assertEquals(1L, languageId);
	}

	@Test
	@Rollback(false)
	void testGetLanguages() {
		List<Language> list = repForTest.findAll();
		assertThat(list.size()).isGreaterThan(1);
	}

	@Test
	@Rollback(false)
	void testDeleteLanguage() {
		Optional<Language> langToTest = repForTest.findById(502L);
		Language language = langToTest.get();
		long langId = language.getIdLanguage();
		repForTest.deleteById(langId);
	}
}
