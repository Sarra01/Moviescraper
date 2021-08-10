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

import application.model.Category;
import application.repository.CategoryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class CategoryTest {

	@Autowired
	private CategoryRepository repForTest;

	@Test
	@Rollback(false)
	void testAddCategory() {
		Category category = new Category();
		category.getIdCategory();
		Category categoryToAdd = repForTest.save(category);
		long categoryId = category.getIdCategory();
		assertEquals(categoryToAdd.getIdCategory(), categoryId);
	}

	@Test
	@Rollback(false)
	void testGetCategory() {

		Optional<Category> catrep = repForTest.findById(1L);
		Category category = catrep.get();
		long categoryId = category.getIdCategory();
		System.out.println(categoryId);
		assertEquals(1L, categoryId);
	}

	@Test
	@Rollback(false)
	void testGetCategories() {
		List<Category> list = repForTest.findAll();
		assertThat(list.size()).isGreaterThan(1);
	}

	@Test
	@Rollback(false)
	void testDeleteCategory() {
		Optional<Category> catToTest = repForTest.findById(502L);
		Category category = catToTest.get();
		long catId = category.getIdCategory();
		repForTest.deleteById(catId);
	}
}