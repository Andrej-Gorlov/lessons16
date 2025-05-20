package pages;

import helpers.ResultOutput;
import helpers.drivers.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ButtonPage extends WebDriverManager {
    public ButtonPage(){
        checkDriverInitialization();
        ResultOutput.log("Загруска страницы /button");
        loadPage("https://kiwiduck.github.io/button");
    }

    public void clickAndVerifyButtons(){
        waitForElementVisible(By.xpath("//button[text()='Click me!']"), 10);
        ResultOutput.log("Нажатие кнопки \"Click me!\" и проверка отображения текста \"Excellent!\"");
        driver.findElement(By.id("first")).click();
        Assertions.assertTrue(isTextFoundById("Excellent!","result"), "Текст 'Excellent!' не найден!");

        waitForElementVisible(By.xpath("//input[@value='Click me too!']"), 10);
        ResultOutput.log("Нажатие кнопки \"Click me too!\" и проверка отображения текста \"Great! Return to menu\"");
        driver.findElement(By.xpath("//input[@value='Click me too!']")).click();
        Assertions.assertTrue(driver.findElement(By.linkText("Great! Return to menu")).isDisplayed());

        ResultOutput.log("Нажатие ссылки \"Great! Return to menu\" и проверка на возрат в menu");
        driver.findElement(By.linkText("Great! Return to menu")).click();
        Assertions.assertTrue(driver.findElement(By.id("kiwiduckgithubio")).isDisplayed(), "Элемент <h1> не видим!");
    }
    /**
     * Проверка на содержание текста в элементах с заданным id.
     *
     * @param textToFind текст, который необходимо найти в элементах
     * @param id элемента, в которых будет осуществлен поиск
     * @return true, если текст найден в одном из элементов; иначе false
     */
    private boolean isTextFoundById(String textToFind, String id) {
        for (var element : driver.findElements(By.id(id))) {
            if (element.getText().equals(textToFind)) {
                return true;
            }
        }
        return false;
    }
}
