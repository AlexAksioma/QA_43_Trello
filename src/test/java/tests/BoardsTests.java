package tests;

import dto.BoardDto;
import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeoutException;

public class BoardsTests extends TestBase {

    @BeforeClass
    public void login() {
        UserDto user = UserDto.builder()
                .email("aksiomamedved@gmail.com")
                .password("AlexMed123!")
                .build();
        app.getHelperUser().login(user);
    }

    @Test
    public void addNewBoardPositiveTest() {
        int i = new Random().nextInt(1000);
        BoardDto board = BoardDto.builder()
                .boardTitle("QA43_title" + i)
                .build();
        app.getHelperBoard().createNewBoard(board);
        Assert.assertTrue(app.getHelperBoard()
                .isTextInElementPresent_boarNameDisplay(board.getBoardTitle()));
    }

    @Test(expectedExceptions = {org.openqa.selenium.TimeoutException.class})
    public void addNewBoardNegativeTest_WOBoardTitle() {
        BoardDto board = BoardDto.builder()
                .boardTitle("")
                .build();
        app.getHelperBoard().createNewBoard(board);
    }

    @AfterMethod
    public void afterMethod(){
        if(app.getHelperBoard().isElementPresentByWait_btnCloseFormCreateBoard())
            app.getHelperBoard().closedFormCreateBoard();
    }
}
