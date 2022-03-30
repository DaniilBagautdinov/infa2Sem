package ru.kpfu.itis.bagautdinov.Repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kpfu.itis.bagautdinov.model.User;
import ru.kpfu.itis.bagautdinov.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetUserByEmail() {
        User user = new User();
        user.setEmail("test@mail.ru");
        user.setName("Ivan");
        user.setPassword("testTEST");

        testEntityManager.persistAndFlush(user);

        Optional<User> result = userRepository.getUserByEmail("test@mail.ru");
        Assert.assertTrue(result.isPresent());
    }

    @Test
    public void testFindAllStepanUser() {
        User user1 = new User();
        user1.setEmail("test1@mail.ru");
        user1.setName("Ivan");
        user1.setPassword("testTEST1");
        User user2 = new User();
        user2.setEmail("test2@mail.ru");
        user2.setName("Stepan");
        user2.setPassword("testTEST2");
        User user3 = new User();
        user3.setEmail("test3@mail.ru");
        user3.setName("Ivan");
        user3.setPassword("testTEST3");

        testEntityManager.persistAndFlush(user1);
        testEntityManager.persistAndFlush(user2);
        testEntityManager.persistAndFlush(user3);

        List<User> allStepanUser = userRepository.findAllStepanUser();
        Assert.assertEquals(1, allStepanUser.size());
    }

    @Test
    public void testFindAllByName() {
        User user1 = new User();
        user1.setEmail("test1@mail.ru");
        user1.setName("Ivan");
        user1.setPassword("testTEST1");
        User user2 = new User();
        user2.setEmail("test2@mail.ru");
        user2.setName("Ivan");
        user2.setPassword("testTEST2");
        User user3 = new User();
        user3.setEmail("test3@mail.ru");
        user3.setName("Stepan");
        user3.setPassword("testTEST3");

        testEntityManager.persistAndFlush(user1);
        testEntityManager.persistAndFlush(user2);
        testEntityManager.persistAndFlush(user3);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        List<User> result = userRepository.findAllByName("Ivan");
        Assert.assertEquals(result,users);
    }

    @Test
    public void testFindUserByNameAndId() {
        User user1 = new User();
        user1.setEmail("test1@mail.ru");
        user1.setName("Ivan");
        user1.setPassword("testTEST1");
        User user2 = new User();
        user2.setEmail("test2@mail.ru");
        user2.setName("Ivan");
        user2.setPassword("testTEST2");
        User user3 = new User();
        user3.setEmail("test3@mail.ru");
        user3.setName("Stepan");
        user3.setPassword("testTEST3");

        testEntityManager.persistAndFlush(user1);
        testEntityManager.persistAndFlush(user2);
        testEntityManager.persistAndFlush(user3);

        User result = userRepository.findUserByNameAndId("Ivan", "2");
        Assert.assertEquals(result,user2);
    }

    @Test
    public void testFindAllByIds() {
        User user1 = new User();
        user1.setEmail("test1@mail.ru");
        user1.setName("Ivan");
        user1.setPassword("testTEST1");
        User user2 = new User();
        user2.setEmail("test2@mail.ru");
        user2.setName("Ivan");
        user2.setPassword("testTEST2");
        User user3 = new User();
        user3.setEmail("test3@mail.ru");
        user3.setName("Stepan");
        user3.setPassword("testTEST3");

        testEntityManager.persistAndFlush(user1);
        testEntityManager.persistAndFlush(user2);
        testEntityManager.persistAndFlush(user3);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        List<User> result = userRepository.findAllByIds(Arrays.asList(1, 2, 3));
        Assert.assertEquals(result,users);
    }


}
