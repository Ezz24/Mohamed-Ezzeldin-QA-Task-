import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.validation.Validations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestClass {


    @Test
    public void FindGoogleLogo(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com.eg/");
        By googleLogo_image = By.xpath("//img[@alt='Google']");
       boolean isDisplayed = driver.findElement(googleLogo_image).isDisplayed();
        Assert.assertTrue(isDisplayed);
        driver.quit();
    }
    @Test
    public void GoogleLogoDisplayed(){
       WebDriver driver;
       driver = DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver,"https://www.google.com.eg/");
        By googleLogo_image = By.xpath("//img[@alt='Google']");
        Validations.assertThat()
                .element(driver, googleLogo_image)
                .matchesReferenceImage()
                .withCustomReportMessage("ASSERT THAT GOOGLE LOGO IMAGE IS DISPLAYED")
                .perform();
        BrowserActions.closeCurrentWindow(driver);

    }

    @Test
    public void GoogleSearch(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lavad\\Downloads\\chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver = DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver,"https://www.google.com.eg/");
        driver.findElement(By.name("q")).sendKeys("irbid");

        WebElement list = driver.findElement(By.xpath("//ul[@role='listbox']"));
        List<WebElement> allSug = list.findElements(By.tagName("span"));


        for (int i = 0 ; i<allSug.size(); i++){
            System.out.println(allSug.get(i).getText());
        }

        driver.quit();




    }


}
