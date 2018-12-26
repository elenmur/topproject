package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {

    private WebDriver driver;
    private By blouseItem = By.xpath("//a[@title='Blouse']");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getBlouseItem() {
        return blouseItem;
    }

}
