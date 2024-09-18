package manager;

import dto.UserDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver driver) {
        super(driver);
    }
    By btnLogin = By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");
    By inputEmail = By.id("username");
    By btnLoginSubmit = By.id("login-submit");
    By inputPassword = By.cssSelector("input[data-testid='password']");
    By btnLoginAfterPassword = By.cssSelector("button[type='submit']");
    By btnAccount = By.cssSelector("button[data-testid='header-member-menu-button']");
    By btnManageAccount = By.cssSelector("a[data-testid='manage-account-link']");
    By profilePhoto = By.cssSelector("div[data-test-selector='profile-hover-info']");
    By btnChangeProfilePhoto = By.cssSelector("button[data-testid='change-avatar']");
    By inputUploadPhoto = By.cssSelector("input[data-testid='image-navigator-input-file']");
    By btnUpload = By.cssSelector("div[data-testid='avatar-picker-dialog-footer'] button:last-child");
    By popUpMessage = By.xpath("//div[@class='css-1748k3u']/../div");

    public void login(UserDto user){
        clickBase(btnLogin);
        typeBase(inputEmail, user.getEmail());
        clickBase(btnLoginSubmit);
        typeBase(inputPassword, user.getPassword());
        //clickBase(btnLoginAfterPassword);
        clickWait(btnLoginAfterPassword, 3);
    }
    public boolean isElementPresent_btnAccount(){
        return isElementPresent(btnAccount);
    }

    public void changeProfilePhoto(String fileName){
        clickBase(btnAccount);
        clickBase(btnManageAccount);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs);
        driver.switchTo().window(tabs.get(1));

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(profilePhoto)).pause(1000).click().perform();
        clickBase(btnChangeProfilePhoto);

        File file = new File("src/test/resources/photos/"+fileName);
        driver.findElement(inputUploadPhoto)
                .sendKeys(file.getAbsolutePath());
        clickBase(btnUpload);
    }

    public boolean isTextInElementPresent_avatarAdded(){
        return isTexInElementPresent(popUpMessage, "We've uploaded your new avatar", 5);
    }
}
