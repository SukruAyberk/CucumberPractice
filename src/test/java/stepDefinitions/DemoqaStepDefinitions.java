package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DemoqaPage;
import utilities.Driver;

import java.time.Duration;

public class DemoqaStepDefinitions {

    DemoqaPage demoqa = new DemoqaPage();

    @Then("kullanici alertse tiklar")
    public void kullanici_alertse_tiklar() {
        demoqa.alertButton.click();
    }

    @And("On button click, alert will appear after five seconds karsisindaki click me butonuna basar")
    public void onButtonClickAlertWillAppearAfterFiveSecondsKarsisindakiClickMeButonunaBasar() {
        demoqa.fiveSecAlertButton.click();
    }

    @Then("Allert’in gorunur olmasini bekleyin")
    public void allert_in_gorunur_olmasini_bekleyin() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @And("Allert uzerindeki yazinin {string} oldugunu test edin")
    public void allertUzerindekiYazininOldugunuTestEdin(String expectedResult) {
        String actualResult = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Then("Ok diyerek alerti kapatin")
    public void ok_diyerek_alerti_kapatin() {
        Driver.getDriver().switchTo().alert().accept();
    }


}
