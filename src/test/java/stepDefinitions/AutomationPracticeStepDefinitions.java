package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.AutomationPracticePage;
import utilities.Driver;

public class AutomationPracticeStepDefinitions {

    AutomationPracticePage ap = new AutomationPracticePage();

    @Then("kullanici singine tiklar")
    public void kullanici_singine_tiklar() {
        ap.singInButton.click();
    }

    @Then("kullanici create account bolumune email adresi girer")
    public void kullanici_create_account_bolumune_email_adresi_girer() {
        ap.emailTextBox.sendKeys("kratonodinson33@gmail.com");
    }

    @Then("kullanici create an account butonuna basar")
    public void kullanici_create_an_account_butonuna_basar() {
        ap.createAccountButton.click();
    }

    @Then("kullanici gerekli bilgileri girer")
    public void kullanici_gerekli_bilgileri_girer() {
        ap.gender.click();
        ap.firstName.sendKeys("Kratos");
        ap.lastName.sendKeys("OdinSon");
        ap.password.sendKeys("B.nhJ45sV@Wv5$9");

        Select select1 = new Select(ap.ddmDay);
        select1.selectByValue("1");

        Select select2 = new Select(ap.ddmMonth);
        select2.selectByValue("1");

        Select select3 = new Select(ap.ddmYear);
        select3.selectByValue("1987");

        ap.firstName2.sendKeys("Kratos");
        ap.lastName2.sendKeys("OdinSon");
        ap.company.sendKeys("Sony Productions");
        ap.address1.sendKeys("Santa Monica");
        ap.address2.sendKeys("Midgard");
        ap.city.sendKeys("Midgard");

        Select select4 = new Select(ap.ddmState);
        select4.selectByVisibleText("Florida");

        ap.zip.sendKeys("32244");

        Select select5 = new Select(ap.ddmCountry);
        select5.selectByVisibleText("United States");

        ap.info.sendKeys("Zeusu kestim");
        ap.homePhone.sendKeys("+905055555555");
        ap.mobilePhone.sendKeys("+905055555554");
        ap.myAddress.sendKeys("www.facebook.com");
    }

    @Then("kullanici Register butonuna basar")
    public void kullanici_register_butonuna_basar() {
        ap.registerButton.click();
    }

    @Then("hesap olustugunu dogrular")
    public void hesap_olustugunu_dogrular() {
        Assert.assertTrue(ap.positiveResultText.isDisplayed());
    }

    @And("kullanici create account bolumune gecersiz email adresi girer")
    public void kullaniciCreateAccountBolumuneGecersizEmailAdresiGirer() {
        ap.emailTextBox.sendKeys("sdşflskdşflkşsldk");
    }

    @Then("error mesajinin {string} oldugunu dogrula")
    public void errorMesajininOldugunuDogrula(String errorMessage) {
        Assert.assertTrue(ap.negativeResultText.getText().equals(errorMessage));
    }
}
