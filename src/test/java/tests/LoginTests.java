package tests;

import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        UserDto user = UserDto.builder()
                .email("aksiomamedved@gmail.com")
                .password("AlexMed123!")
                .build();
        app.getHelperUser().login(user);
        Assert.assertTrue(app.getHelperUser().isElementPresent_btnAccount());
    }
}
