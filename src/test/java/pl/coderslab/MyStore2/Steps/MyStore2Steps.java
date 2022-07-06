package pl.coderslab.MyStore2.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.MyStore2.Page.MyStoreCheckOut;
import pl.coderslab.MyStore2.Page.MyStoreClothes;
import pl.coderslab.MyStore2.Page.MyStoreMainAndLogin;
import pl.coderslab.MyStore2.Page.MyStoreSweater;

import java.io.IOException;
import java.time.Duration;

public class MyStore2Steps {
    private WebDriver driver;

    @Given("I am at the mystore page, have account and press the sign in")
    public void openMyStorePage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl");
        MyStoreMainAndLogin main = new MyStoreMainAndLogin(driver);
        main.signInClick();
    }

    @When("^I sign in using mail (.+), password (.+)$")
    public void signInUsingMailAndPassword(String mail, String password) {
    MyStoreMainAndLogin mainAndLogin = new MyStoreMainAndLogin(driver);
        mainAndLogin.signInMailAndPassword(mail, password);
    }

    @And("Go to clothes page and choose Hummingbird Printed Sweater")
    public void goToClothesPageAndChooseHummingbirdPrintedSweater() {
        MyStoreClothes clothes = new MyStoreClothes(driver);
        clothes.chooseSweaterClick();

    }

    @And("Check discount calculation, set size to M, set quantity to {int}, add to cart")
    public void checkDiscountCalculationSetSizeToMSetQuantityToAddToCart(int arg0) throws InterruptedException {
        MyStoreSweater sweater = new MyStoreSweater(driver);
        boolean discountVerification = sweater.discountVerificator();
        boolean a = true;
        Assertions.assertEquals(a, discountVerification);
//        System.out.println(a + " " +discountVerification);
        sweater.setSizeToM();
        sweater.setQuantity(arg0);
        sweater.addToCart();
        sweater.proceedButton();
        sweater.secondProceed();
    }

    @And("Confirm address, choose payment Pay by Check, order with obligation to pay, take screenshot")
    public void confirmAddressChoosePaymentPayByCheckOrderWithObligationToPayTakeScreenshot() throws IOException {
        MyStoreCheckOut checkOut = new MyStoreCheckOut(driver);
        checkOut.confirmAddress();
        checkOut.setPickUpInStore();
        checkOut.setPayByCheck();
        checkOut.jebnijFote();
    }

    @Then("Check header of confirmation page")
    public void checkHeaderOfConfirmationPage() {
        MyStoreCheckOut checkOut = new MyStoreCheckOut(driver);
        String shouldBe = "YOUR ORDER IS CONFIRMED";
        String getTextFromHeader = checkOut.getHeader();
        Assertions.assertEquals(shouldBe, getTextFromHeader);
    }
}
