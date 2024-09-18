package tests;

import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfileTests extends TestBase{

    @BeforeClass
    public void login(){
        UserDto user = UserDto.builder()
                .email("aksiomamedved@gmail.com")
                .password("AlexMed123!")
                .build();
        app.getHelperUser().login(user);
    }

    @Test
    public void changeProfilePhotoPositive(){
        app.getHelperUser().changeProfilePhoto("qa_blue.jpg");
        Assert.assertTrue(app.getHelperUser().isTextInElementPresent_avatarAdded());
    }
}
