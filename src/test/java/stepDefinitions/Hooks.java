package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    /*
        Cucumber'da, step definitions package'i icerisinde
        @before, @after gibi bir notasyon varsa
        extends testBase dememiz gerek kalmadan
        her senaryodan önce ve/veya sonra bu methodlar calisacaktir

        Bu da bizim isteyecegimiz bir durum degildir

        Cucumber'da @before, @after kullanma ihtiyacimiz olursa
        bunu step definitions package'i altinda olusturacagimiz
        hooks classina koyariz

        Biz her senaryodan sonra test sonucunu kontrol edip
        failed olan senaryolar icin ss olmasi amaciyla
        @after method'u kullnacagiz
     */

    @After
    public void tearDown(Scenario scenario){
        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png","screenshots");
        }
        Driver.closeDriver();
    }
}
