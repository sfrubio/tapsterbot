package whiteboard.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Tapsterbot;
import utils.TapsterbotService;

public class WhiteboardScreen {

    private AppiumDriver<MobileElement> driver;

    private TapsterbotService tapsterbotService;

    public WhiteboardScreen(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements( new AppiumFieldDecorator(driver), this);
        this.driver = driver;
        this.tapsterbotService = new Tapsterbot();
    }

    @AndroidFindBy(id = "com.vistrav.whiteboard:id/canvas")
    private RemoteWebElement canvas;

    public WhiteboardScreen drawEyesAndMouth() {
        waitForCanvas();
        tapsterbotService.drawCircle(-20, 10, 6);
        tapsterbotService.drawCircle(0, 10, 6);
        tapsterbotService.drawArc(-5, 0);
        return this;
    }

    public WhiteboardScreen drawQax() {
        waitForCanvas();
        drawQ();
        drawA();
        drawX();
        return this;
    }

    private void drawQ() {
        tapsterbotService.drawCircle(-20, 10, 10);
        Integer[] startCoords = {-15, 8};
        Integer[] endCoords = {-5, -2};
        tapsterbotService.dragAndDrop(startCoords, endCoords);
    }

    private void drawA() {
        Integer[] startCoords = {-5, 2};
        Integer[] endCoords = {5, 27};
        tapsterbotService.dragAndDrop(startCoords, endCoords);
        startCoords[0] = 4;
        startCoords[1] = 17;
        endCoords[0] = 15;
        endCoords[1] = 0;
        tapsterbotService.dragAndDrop(startCoords, endCoords);
        startCoords[0] = 1;
        startCoords[1] = 10;
        endCoords[0] = 13;
        endCoords[1] = 10;
        tapsterbotService.dragAndDrop(startCoords, endCoords);
    }

    private void drawX() {
        Integer[] startCoords = {-15, -15};
        Integer[] endCoords = {5, -35};
        tapsterbotService.dragAndDrop(startCoords, endCoords);
        startCoords[0] = -15;
        startCoords[1] = -35;
        endCoords[0] = 5;
        endCoords[1] = -10;
        tapsterbotService.dragAndDrop(startCoords, endCoords);
    }

    private void waitForCanvas() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(canvas));
    }
}
