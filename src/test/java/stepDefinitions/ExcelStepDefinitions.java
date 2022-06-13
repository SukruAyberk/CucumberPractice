package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelStepDefinitions {

    Workbook workbook;
    String filePath = "src/test/resources/ulkeler.xlsx";
    FileInputStream fis = new FileInputStream(filePath);

    public ExcelStepDefinitions() throws FileNotFoundException {
    }

    @Given("kullanici excel dosyasini kullanilabilir hale getirir")
    public void kullanici_excel_dosyasini_kullanilabilir_hale_getirir() throws IOException {

        workbook = WorkbookFactory.create(fis);
    }

    @Then("{int}. satirdaki {int}. hucreyi yazdirir")
    public void satirdaki_hucreyi_yazdirir(Integer row, Integer column) {
        String istenenHucreYazisi = workbook.getSheet("Sayfa1").getRow(row - 1).getCell(column - 1).toString();
        System.out.println(row + ". satir " + column + ". sutundaki deger: " + istenenHucreYazisi);
    }

    @And("baskenti {string} olan ulke ismini yazdirir")
    public void baskentiOlanUlkeIsminiYazdirir(String baskent) {
        // for loop ile tum satirlari kontrol etmem lazim
        // bunun icinde satir sayisine ihtiyacim var
        int rowNum = workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <= rowNum; i++) {
            if (workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString().equals(baskent)) {
                System.out.println("Baskenti " + baskent + " olan ülke: " + workbook.getSheet("Sayfa1").getRow(i).getCell(0));
            }
        }
    }

    @Then("ulke sayisinin {int} oldugunu test eder")
    public void ulke_sayisinin_oldugunu_test_eder(Integer ulkeSayisi) {
        int actualUlkeSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(ulkeSayisi);
        System.out.println(actualUlkeSayisi);
        Assert.assertTrue(ulkeSayisi == actualUlkeSayisi);
    }

    @Then("fiziki olarak kullanilan satir sayisinin {int} oldugunu test eder")
    public void fiziki_olarak_kullanilan_satir_sayisinin_oldugunu_test_eder(Integer fizikiKullanilanSatir) {
        int actualFizKulSatir = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        Assert.assertTrue(fizikiKullanilanSatir == actualFizKulSatir);
    }

    @Then("kullanici {int} satir {int} celle {string} yazdirir")
    public void kullanici_satir_celle_yazdirir(Integer row, Integer cell, String istenenKelime) {
        workbook.getSheet("Sayfa2").getRow(row).createCell(cell).setCellValue(istenenKelime);
    }

    @And("dosyayi kaydeder ve kapatir")
    public void dosyayiKaydederVeKapatir() throws IOException {
        String filePath = "src/test/resources/ulkeler.xlsx";
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fis.close();
        fos.close();
    }
}
