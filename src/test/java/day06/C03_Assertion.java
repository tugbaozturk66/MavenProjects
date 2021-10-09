package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Assertion {
   //1.Bir Class olusturalim YanlisEmailTesti
   //2.http://automationpractice.com/index.php sayfasina gidelim
   //3.Sign in butonuna basalim
   //4.Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim

   static WebDriver driver;
   @BeforeClass
   public static void setup(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      driver.get("http://automationpractice.com/index.php");
   }
   @Test
   public void gecersizMail() throws InterruptedException {
driver.findElement(By.partialLinkText("Sign in")).click();
Thread.sleep(3000);
WebElement emailGirisKutusu= driver.findElement(By.id("email_create"));
emailGirisKutusu.sendKeys("Merhaba Televole"+ Keys.ENTER);
Thread.sleep(3000);
WebElement hataYazisiElementi=driver.findElement(By.id("create_account_error"));
      Assert.assertTrue("mesaj gorunmedi",hataYazisiElementi.isDisplayed());
   }
   @AfterClass
   public static void tearDown(){
      driver.close();
   }
}
