import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Selenium_Gmail_Sign_In {
    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops=new FirefoxOptions();
//        ops.addArguments("--headless");//run test without opening browser
        ops.addArguments("--headed");
        driver=new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void signInToGmail(){
        driver.get("https://www.gmail.com");
//        driver.findElement(By.xpath("//input[@id='Ycyxxc']")).click();
        driver.findElement(By.cssSelector("#identifierId")).sendKeys("aminul@gmail.com");
        driver.findElement(By.cssSelector("#identifierId")).sendKeys(Keys.ENTER);
//        driver.findElement(By.cssSelector("")).sendKeys(""); //send password in here

//        String text= driver.findElement(By.cssSelector("VfPpkd-vQzf8d")).getText();
//        Assert.assertTrue(text.contains(""));
    }

    @Test
    public void signInToGmail_convertedToEnglish(){
        driver.get("https://www.gmail.com");
        driver.findElement(By.xpath("//div[@class='ry3kXd Ulgu9']")).click();
        driver.findElement(By.xpath("//div[@class='OA0qNb ncFHed']//div[@class='MocG8c B9IrJb LMgvRb']//span[@class='vRMGwf oJeWuf'][contains(text(),'English (United States)')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        driver.findElement(By.xpath("//div[@class='ry3kXd Ulgu9']")).click();
        driver.findElement(By.xpath("//div[@class='OA0qNb ncFHed']//div[@class='MocG8c B9IrJb LMgvRb']//span[@class='vRMGwf oJeWuf'][contains(text(),'English (United States)')]")).click();

        driver.findElement(By.cssSelector("#identifierId")).sendKeys("aminul@gmail.com");
        driver.findElement(By.cssSelector("#identifierId")).sendKeys(Keys.ENTER);
//        driver.findElement(By.cssSelector("")).sendKeys(""); //send password in here

//
        String text = driver.findElement(By.xpath("//span[contains(@class,'VfPpkd-vQzf8d')]")).getText();
//        System.out.println(text);
        Assert.assertTrue(text.contains("Next"));
    }

    @After
    public void finishTest(){
        driver.close();
    }
}


