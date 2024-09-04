package manager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    HelperUser helperUser;
    HelperBoard helperBoard;
    public void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://trello.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //============================
        helperUser = new HelperUser(driver);
        helperBoard = new HelperBoard(driver);
    }

    public void stop(){
//        if(driver!= null)
//            driver.quit();
    }

    public HelperUser getHelperUser(){
        return helperUser;
    }
    public HelperBoard getHelperBoard(){
        return helperBoard;
    }
}
