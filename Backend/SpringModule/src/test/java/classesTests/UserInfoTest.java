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

import application.model.UserInfo;
import application.repository.UserInfoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserInfoTest {

	@Autowired
	private UserInfoRepository repForTest;

	@Test
	@Rollback(false)
	void testAddUserInfo() {
		UserInfo user = new UserInfo();
		user.getId();
		UserInfo userToAdd = repForTest.save(user);
		long userId = user.getId();
		assertEquals(userToAdd.getId(), userId);
	}

	@Test
	@Rollback(false)
	void testGetUserInfo() {

		Optional<UserInfo> userRep = repForTest.findById(1L);
		UserInfo user = userRep.get();
		long userId = user.getId();
		System.out.println(userId);
		assertEquals(1L, userId);
	}

	@Test
	@Rollback(false)
	void testGetUsers() {
		List<UserInfo> list = repForTest.findAll();
		assertThat(list.size()).isGreaterThan(1);
	}

	@Test
	@Rollback(false)
	void testDeleteUserInfo() {
		Optional<UserInfo> userToTest = repForTest.findById(502L);
		UserInfo user = userToTest.get();
		long userId = user.getId();
		repForTest.deleteById(userId);
	}
}