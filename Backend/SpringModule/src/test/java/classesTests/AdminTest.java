package classesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import application.model.Admin;
import application.repository.AdminRepository;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AdminTest {

	@Autowired
	private AdminRepository repForTest;

	@Test
	@Rollback(false)
	void testAddActor() {
		Admin admin = new Admin();
		admin.setEmail("administrator@yahoo.com");
		Admin adminToAdd = repForTest.save(admin);
		long adminId = admin.getIdAdmin();
		assertEquals(adminToAdd.getIdAdmin(), adminId);
	}

	@Test
	@Rollback(false)
	void testGetAdmin() {

		Optional<Admin> adm = repForTest.findById(1L);
		Admin admin = adm.get();
		long adminId = admin.getIdAdmin();
		System.out.println(adminId);
		assertEquals(1L, adminId);
	}

	@Test
	@Rollback(false)
	void testGetAdmins() {
		List<Admin> list = repForTest.findAll();
		assertThat(list.size()).isGreaterThan(1);
	}

	@Test
	@Rollback(false)
	void testDeleteAdmin() {
		Optional<Admin> adminToTest = repForTest.findById(502L);
		Admin admin = adminToTest.get();
		long admId = admin.getIdAdmin();
		repForTest.deleteById(admId);
	}
}