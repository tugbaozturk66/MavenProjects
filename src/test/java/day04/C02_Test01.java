package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test01 {
    public static void main(String[] args) {
        //1-Test01 isimli bir class olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //2- https://www.walmart.com/ adresine gidin
        driver.get("https://www.walmart.com/");
        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        String actuelTitle=driver.getTitle();
        String arananKelime="Save";
        if (actuelTitle.contains(arananKelime)){
            System.out.println("Title "+ arananKelime+ " kelimesini iceriyor, test PASSED");
        }else{
            System.out.println("Title "+ arananKelime+ " kelimesini icermiyor, test FAILED");

        }
        //6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        String expectedTitle="Walmart.com | Save Money.Live Better";
        if (expectedTitle.equals(actuelTitle)){
            System.out.println("sayfa title'i beklenen ile ayni, test PASSED");

        }else{
            System.out.println("sayfa title'i beklenen ile ayni degil, test FAILED");
            System.out.println("actuel title: "+ actuelTitle);
        }
        //7- URL in walmart.com icerdigini control edin
        String actuelUrl=driver.getCurrentUrl();
        String urlArananKlime="walmart.com";
        if (actuelUrl.contains(urlArananKlime)){
            System.out.println("url "+ urlArananKlime+ " kelimesini iceriyor test PASSED");
        }else{
            System.out.println("url "+ urlArananKlime+ " kelimesini icermiyor test FAILED");

        }
        //8-”Nutella” icin arama yapiniz
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //9- Kac sonuc bulundugunu yaziniz
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='f4 f3-m lh-title ma0 di']"));
        System.out.println(sonucYazisiElementi.getText());
        //10-Sayfayi kapatin
        driver.close();






    }
}
