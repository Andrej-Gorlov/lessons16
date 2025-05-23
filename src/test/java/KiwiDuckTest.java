import helpers.ResultOutput;
import helpers.drivers.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ButtonPage;
import pages.CheckboxesPage;

public class KiwiDuckTest {
    private String nameMethod;

    @BeforeEach
    public void setUp() {
        ResultOutput.log("выполнение тестов класса KiwiDuckTest");
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
        WebDriverManager.closeDriver();
    }
}
