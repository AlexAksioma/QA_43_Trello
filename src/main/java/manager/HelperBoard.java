package manager;

import dto.BoardDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBoard extends HelperBase{
    public HelperBoard(WebDriver driver) {
        super(driver);
    }
    By btnCreateNewBoard = By.cssSelector("li[data-testid='create-board-tile']");
    By inputBoardTitle = By.cssSelector("input[data-testid='create-board-title-input']");
    By btnCreateBoardSubmit = By.cssSelector("button[data-testid='create-board-submit-button']");
    public void createNewBoard(BoardDto board){
        clickBase(btnCreateNewBoard);
        typeBase(inputBoardTitle, board.getBoardTitle());
        clickWait(btnCreateBoardSubmit, 3);
    }
}
