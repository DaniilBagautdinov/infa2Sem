package ru.kpfu.itis.bagautdinov.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kpfu.itis.bagautdinov.config.MailConfig;
import ru.kpfu.itis.bagautdinov.repository.UserRepository;
import ru.kpfu.itis.bagautdinov.service.impl.UserServiceImpl;



public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestContextConfiguration {

        @MockBean
        private UserRepository userRepository;

        @MockBean
        private BCryptPasswordEncoder encoder;

        @MockBean
        private JavaMailSender javaMailSender;

        @MockBean
        private MailConfig mailConfig;


        @Bean
        public UserService userService() {
            return new UserServiceImpl(userRepository, encoder, javaMailSender, mailConfig);
        }
    }

    @Autowired
    private UserService userService;

    @Test
    public void testGetAll() {
        Assert.assertTrue(userService.getAll().isEmpty());
    }

    @Test
    public void testGetAllStepan() {
        Assert.assertTrue(userService.getAllStepan().isEmpty());
    }

    @Test
    public void testGetByEmail() {
        Assert.assertNull(userService.getByEmail("g@gmail.com"));
    }

    @Test
    public void testGetById() {
        Assert.assertNull(userService.getById(1));
    }

    @Test
    public void testGetAllByName() {
        Assert.assertTrue(userService.getAllByName("Stepan").isEmpty());
    }
}
