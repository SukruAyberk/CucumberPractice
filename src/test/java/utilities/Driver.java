package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
        POM'de Driver için TestBase classına extends etmek yerine
        Driver classından static methodlar kullanarak
        driver oluşturup, ilgili ayarların yapılması
        ve en sonda driverın kapatılması tercih edilmiştir.

        POM'de Driver class'ındaki getDriver()'ın' obje oluşturularak kullanılmasını
        engellemek için Singleton pattern kullanımı benimsenmiştir

        Singleton Pattern: tekli kullanım, bir class'ın farklı classlardan
        obje oluşturularak kullanımını engellemek için kullanılır

        Bunu sağlamak için yapmamız gereken şey oldukça basit
        Obje oluşturmak için kullanılan constructor'ı private yaptığımızda
        başka classlarda Driver classından obje oluşturulması mümkün olmaz

     */


    private Driver() {

    }

    static WebDriver driver;

    public static WebDriver getDriver() {

        // her defasında yeni pencere açmaması için yaptık bunu
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }

    }
}
