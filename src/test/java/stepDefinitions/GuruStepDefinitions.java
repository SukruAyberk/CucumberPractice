package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GuruPage;
import utilities.Driver;

import java.util.List;

public class GuruStepDefinitions {

    GuruPage guru = new GuruPage();

    @Then("IstenenSatir {int} ve IstenenSutun {int} girdiginde degerini yazdirir")
    public void ıstenen_satir_ve_ıstenen_sutun_girdiginde_degerini_yazdirir(Integer satir, Integer sutun) {
        satir++;
        sutun++;
        WebElement istenenSatirSutun = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(istenenSatirSutun.getText());
    }


    @Then("{string} listesini yazdirir")
    public void listesiniYazdirir(String istenenSutun) {
        List<WebElement> tabloBaslikListesi = guru.baslikListesi;
        int baslikIndex = -3;
        for (int i = 0; i < tabloBaslikListesi.size(); i++) {
            if (tabloBaslikListesi.get(i).getText().equals(istenenSutun)) {
                baslikIndex = i + 1;
            }
        }

        if (baslikIndex != -3) {
            List<WebElement> istenenSutundakiElementler = Driver.getDriver().findElements(By.xpath("//tbody//tr//td[" + baslikIndex + "]"));
            for (WebElement i : istenenSutundakiElementler) {
                System.out.println(i.getText());
            }
        } else {
            System.out.println("istenen baslik bulunamadi");
        }
    }

    @And("{string} listesinde {string} oldugunu test eder")
    public void listesindeOldugunuTestEder(String istenenSutun, String istenenDeger) {
        List<WebElement> tabloBasliListesi = guru.baslikListesi;
        int baslikIndex = -3;
        for (int i = 0; i < tabloBasliListesi.size(); i++) {
            if (tabloBasliListesi.get(i).getText().equals(istenenSutun)) {
                baslikIndex = i + 1;
            }
        }
        if (baslikIndex != -3) {
            List<WebElement> istenenSutundakiElementler = Driver.getDriver().findElements(By.xpath("//tbody//tr//td[" + baslikIndex + "]"));
            Assert.assertFalse(tabloBasliListesi.contains(istenenDeger));
        } else {
            System.out.println("istenen baslik bulunamadi");
        }
    }


    @And("istenSatir {int} ve istenenSutun {int} Prev.Close degerini yazdirir")
    public void istensatirVeIstenenSutunPrevCloseDegeriniYazdirir(int satir, int sutun) {
        WebElement istenenSatirSutun = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + (satir + 1) + "]//td[" + (sutun + 1) + "]"));
        System.out.println(istenenSatirSutun.getText());
    }
}
