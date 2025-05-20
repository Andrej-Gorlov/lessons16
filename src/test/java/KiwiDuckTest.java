import helpers.ResultOutput;
import helpers.drivers.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import pages.ButtonPage;
import pages.CheckboxesPage;

public class KiwiDuckTest {
    private WebDriverManager webDriverManager;
    private String nameMethod;

    @BeforeEach
    public void setUp() {
        webDriverManager = new WebDriverManager();
    }

    @Test
    public void testButton() {
        nameMethod = "testButton";
        ResultOutput.printTestStart(nameMethod);

        ButtonPage page = new ButtonPage();
        page.clickAndVerifyButtons();
    }

    @Test
    public void testCheckboxes() {
        nameMethod = "testCheckboxes";
        ResultOutput.printTestStart(nameMethod);

        CheckboxesPage page = new CheckboxesPage();
        page.submitSelectionsAndVerify();
    }

    @AfterEach
    public void tearDown() {
        ResultOutput.printTestEnd(nameMethod);
        webDriverManager.closeDriver();
    }
}
