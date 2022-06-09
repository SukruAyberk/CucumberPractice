package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HMCPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HMCStepDefinitions {

    HMCPage hmc = new HMCPage();

    @Given("kullanici {string} anasayfasinda")
    public void kullanici_anasayfasinda(String sayfaUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(sayfaUrl));
    }

    @Then("login butonuna basar")
    public void login_butonuna_basar() {
        hmc.loginButton1.click();
    }

    @Then("username {string} girer")
    public void username_girer(String username) {
        hmc.username.sendKeys(username);
    }

    @Then("password {string} girer")
    public void password_girer(String password) {
        hmc.password.sendKeys(password);
    }

    @Then("login click eder")
    public void login_click_eder() {
        hmc.loginButton2.click();
    }

    @Then("giris yapilamadigini kontrol eder")
    public void giris_yapilamadigini_kontrol_eder() {
        Assert.assertTrue(hmc.tryAgainText.isDisplayed());
    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }
}
