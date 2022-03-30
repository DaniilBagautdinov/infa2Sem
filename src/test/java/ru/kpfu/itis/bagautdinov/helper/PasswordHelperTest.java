package ru.kpfu.itis.bagautdinov.helper;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PasswordHelperTest {

    @Test
    public void testEncrypt() {
        String result = PasswordHelper.encrypt("1");
        Assert.assertNotEquals("1", result);
    }
}
