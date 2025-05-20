package pages;

import helpers.ResultOutput;
import helpers.drivers.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage extends WebDriverManager{
    public CheckboxesPage(){
        checkDriverInitialization();
        ResultOutput.log("Загруска страницы /checkboxes");
        loadPage("https://kiwiduck.github.io/checkboxes");
    }

    public void submitSelectionsAndVerify(){
        waitForElementVisible(By.cssSelector("input[type='checkbox']"), 10);
        selectVerifyCheckboxes();

        waitForElementVisible(By.cssSelector("input[type='radio']"), 10);
        selectAndVerifyRadioButtons();

        Assertions.assertTrue(driver.findElement(By.linkText("Great! Return to menu")).isDisplayed());
        driver.findElement(By.linkText("Great! Return to menu")).click();
        Assertions.assertTrue(driver.findElement(By.id("kiwiduckgithubio")).isDisplayed(), "Элемент <h1> не видим!");
    }

    /**
     * Выбирает все чекбоксы на странице и проверяет, что их значения присутствуют в результатах.
     *
     * Находит все чекбоксы, выбирает их (если они не выбраны),
     * нажимает кнопку для отправки выбора и проверяет, что значения
     * выбранных чекбоксов содержатся в исходном коде страницы.
     *
     * @throws AssertionError если чекбоксы не найдены или не были выбраны после клика
     */
    private void selectVerifyCheckboxes() {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        Assertions.assertFalse(checkboxes.isEmpty(), "Чекбоксы не найдены!");

        checkboxes.forEach(checkbox -> {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
            ResultOutput.log("Проверка, что чекбокс выбран");
            Assertions.assertTrue(checkbox.isSelected(), "Чекбокс не был выбран после клика: " + checkbox.getAttribute("value"));
        });

        driver.findElement(By.id("go")).click();
        waitForElementVisible(By.id("result"), 10);

        checkboxes.stream()
                .filter(WebElement::isSelected)
                .forEach(checkbox -> {
                    ResultOutput.log("Проверка значения выбранного чекбокса");
                    Assertions.assertTrue(driver.getPageSource().contains(checkbox.getAttribute("value")),
                            "Значение чекбокса '" + checkbox.getAttribute("value") + "' не найдено в результатах.");
                });
    }

    /**
     * Выбирает радиокнопки и проверяет, что их значения присутствуют в результатах.
     *
     * Находит все радиокнопки на странице, выбирает каждую из них,
     * нажимает на кнопку для отправки выбора и проверяет, что значение
     * выбранной радиокнопки содержится в исходном коде страницы.
     */
    private void selectAndVerifyRadioButtons(){
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        if (!radioButtons.isEmpty()) {
            radioButtons.stream().forEach(radioButton -> {
                radioButton.click(); // Нажимаем на радиокнопку
                driver.findElement(By.id("radio_go")).click();
                ResultOutput.log("Проверка на содержание значения выбранного радиокнопки");
                Assertions.assertTrue(driver.getPageSource().contains(radioButton.getAttribute("value")),
                        "Значение радиокнопки '" + radioButton.getAttribute("value") + "' не найдено в результатах.");
            });
        }
    }
}

