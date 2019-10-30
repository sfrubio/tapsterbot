package whiteboard.android;

import com.meuid.MeuIdBaseTest;
import com.meuid.pageobjects.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import whiteboard.WhiteboardBaseTest;
import whiteboard.pageobjects.IndexScreen;
import whiteboard.pageobjects.WhiteboardScreen;

import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhiteboardTest extends WhiteboardBaseTest {

    private IndexScreen indexScreen;
    private WhiteboardScreen whiteboardScreen;

    @Before
    public void setUp() throws MalformedURLException {
        driver = getAndroidDriver(device);
        indexScreen = new IndexScreen(driver);
        whiteboardScreen = new WhiteboardScreen(driver);
    }

    @Test
    public void drawSmile() {
        indexScreen.startDrawing();
        whiteboardScreen.drawEyesAndMouth();
    }

    @Test
    public void drawQax() {
        indexScreen.startDrawing();
        whiteboardScreen.drawQax();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
