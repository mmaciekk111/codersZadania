package pl.coderslab.MyStore.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreMain {
        private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a/span")
    private WebElement signInButton;


    public MyStoreMain(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void signIn(){
        signInButton.click();
    }
}
