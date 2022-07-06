package pl.coderslab.MyStore2.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreClothes {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"js-product-list\"]/div[1]/article[2]/div/a/img")
    private WebElement sweaterChoseClick;

    public MyStoreClothes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void chooseSweaterClick(){
        sweaterChoseClick.click();
    }
}
