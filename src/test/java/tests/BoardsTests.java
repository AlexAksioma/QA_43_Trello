package tests;

import dto.BoardDto;
import dto.UserDto;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class BoardsTests extends TestBase{

    @BeforeClass
    public void login(){
        UserDto user = UserDto.builder()
                .email("aksiomamedved@gmail.com")
                .password("AlexMed123!")
                .build();
        app.getHelperUser().login(user);
    }

    @Test
    public void addNewBoardPositiveTest(){
        int i = new Random().nextInt(1000);
        BoardDto board = BoardDto.builder()
                .boardTitle("QA43_title"+i)
                .build();
        app.getHelperBoard().createNewBoard(board);
    }
}
