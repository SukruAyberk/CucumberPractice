package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GuruPage;
import utilities.Driver;

public class GuruStepDefinitions {

    GuruPage guru = new GuruPage();

    @Then("IstenenSatir {int} ve IstenenSutun {int} girdiginde degerini yazdirir")
    public void ıstenen_satir_ve_ıstenen_sutun_girdiginde_degerini_yazdirir(Integer satir, Integer sutun) {
        satir++;
        sutun++;
        WebElement istenenSatirSutun = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(istenenSatirSutun.getText());
    }


}
