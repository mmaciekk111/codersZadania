package pl.coderslab.MyStore.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.MyStore.Page.MyStoreAddressForm;
import pl.coderslab.MyStore.Page.MyStoreAuthPage;
import pl.coderslab.MyStore.Page.MyStoreLogged;
import pl.coderslab.MyStore.Page.MyStoreMain;

import java.time.Duration;
import java.util.Locale;

public class MyStoreSteps {
    private WebDriver driver;

    @Given("I am at the mystore page and have created user account")
    public void openMyStorePage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl");
        MyStoreMain main = new MyStoreMain(driver);
        main.signIn();
    }

    @When("^I sign in using mail: (.+) and password: (.+)$")
    public void signIn(String email, String password) {
        MyStoreAuthPage authPage = new MyStoreAuthPage(driver);
        authPage.enterLoginData(email, password);
    }

    @And("Add new address by click at the Addresses tile and then link to createNewAddress")
    public void goToCreateAddressForm() {
        MyStoreLogged logged = new MyStoreLogged(driver);
        logged.addressesTileClick();
        logged.createNewAddressClick();
    }

    @And("^Fill new address form alias: (.+)$")
    public void fillAlias(String alias) {
        MyStoreAddressForm addressForm = new MyStoreAddressForm(driver);
        addressForm.fillAlias(alias);

    }

    @And("^Fill first name: (.+)$")
    public void fillFirstName(String firstName) {
        MyStoreAddressForm addressForm = new MyStoreAddressForm(driver);
        addressForm.fillFirstName(firstName);
    }

    @And("^Fill last name: (.+)$")
    public void fillLastNameLastName(String lastName) {
        MyStoreAddressForm addressForm = new MyStoreAddressForm(driver);
        addressForm.fillLastName(lastName);
    }

    @And("^Fill address: (.+)$")
    public void fillAddressAddress(String address) {
        MyStoreAddressForm addressForm = new MyStoreAddressForm(driver);
        addressForm.fillAddress(address);
    }


    @And("^Fill city: (.+)$")
    public void fillCityCity(String city) {
        MyStoreAddressForm addressForm = new MyStoreAddressForm(driver);
        addressForm.fillCity(city);
    }


    @And("^Fill zip code: (.+)$")
    public void fillZipCodeZipCode(String zipCode) {
        MyStoreAddressForm addressForm = new MyStoreAddressForm(driver);
        addressForm.fillZipCode(zipCode);
    }

    @And("^Fill phone number: (.+)$")
    public void fillPhoneNumberPhoneNumber(String phoneNumber) {
        MyStoreAddressForm addressForm = new MyStoreAddressForm(driver);
        addressForm.fillPhoneNumber(phoneNumber);
    }

    @And("Save the new address")
    public void saveTheNewAddress() {
        MyStoreAddressForm addressForm = new MyStoreAddressForm(driver);
        addressForm.signInClick();
    }

    @Then("^Find proper tile with new address by alias, and compare data of (.+), (.+), (.+), (.+), (.+), (.+), (.+), (.+)$")
    public void findProperTileWithNewAddress(String alias, String firstName, String lastName, String adress, String city, String zipCode, String phoneNumber, String country) {
        String data = alias + firstName + lastName + adress + city + zipCode + phoneNumber + country;
        data = data.toLowerCase(Locale.ROOT).replaceAll("\\s", "");
        String childrenOfAlias = driver.findElement(By.xpath("//*[text() = '" + alias + "']/..")).getText();
        childrenOfAlias = childrenOfAlias.toLowerCase(Locale.ROOT).replaceAll("\\s", "");
        Assertions.assertEquals(childrenOfAlias, data);


    }
}