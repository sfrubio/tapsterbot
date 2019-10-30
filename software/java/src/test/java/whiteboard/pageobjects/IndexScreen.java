package whiteboard.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Tapsterbot;
import utils.TapsterbotService;

public class IndexScreen {

    private AppiumDriver<MobileElement> driver;

    private TapsterbotService tapsterbotService;

    public IndexScreen(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements( new AppiumFieldDecorator(driver), this);
        this.driver = driver;
        this.tapsterbotService = new Tapsterbot();
    }

    public IndexScreen startDrawing() {
        tapsterbotService.tapOnBottomScreen(20,-40);
        return this;
    }
}
