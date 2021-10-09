package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C06_Odev {
    //1-Test01 isimli bir class olusturun
    //2- https://www.amazon.com/ adresine gidin
    //3- Browseri tam sayfa yapin
    //4-Sayfayi "refresh" yapin
    //5- Sayfa basliginin "Amazon" ifadesi icerdigini control edin
    //6-Sayfa basliginin "Amazon.com. Spend less. Smile more." a esit oldugunu control ediniz
    //7- URL in amazon.com icerdigini control edin
    //8-"Nutella" icin arama yapiniz byid "twotabsearchtextbox"
    //9- Kac sonuc bulundugunu yaziniz
    //10-Sayfayi kapatin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
    }
    @Test
    public void test1(){
        if (driver.getTitle().contains("Amazon")){
            System.out.println("sayfa basligi Amazon ifadesini iceriyor. Test PASSED");
        }else{
            System.out.println("sayfa basligi Amazon kelimesini icermiyor. Test FAILED");
        }
    }
    @Test
    public void test2(){
        if (driver.getTitle().equals("Amazon.com. Spend less. Smile more.")){
            System.out.println(" Sayfa basligi Amazon.com. Spend less. Smile more seklindedir. Test PASSED");
        }else{
            System.out.println(" Sayfa basligi Amazon.com. Spend less. Smile more seklinde degildir. Test FAILED");

        }
    }
    @Test
    public void test3(){
        if (driver.getCurrentUrl().contains("amazon.com")){
            System.out.println("Sayfa url si amazon.com icermektedir. Test PASSED");
        }else {
            System.out.println("Sayfa url si amazon.com icermemektedir. Test FAILED");

        }
    }
    @Test
    public void test4(){
        WebElement arama= driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("Nutella"+ Keys.ENTER);
        WebElement aramaSonucu= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(aramaSonucu.getText());
    }

    @After
   public void tearDown(){
     driver.close();
   }


}
