package manager;

import dto.UserDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
