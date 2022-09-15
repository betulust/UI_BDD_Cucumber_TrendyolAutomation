package Steps;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
// In TestRunner.java
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import io.cucumber.core.cli.Main;
import org.testng.asserts.Assertion;

public class TestSteps {

	private WebDriver driver;
	
	
	
	
	@Given("Trendyol sitesine giris yapilir.")
	public void trendyol_sitesine_giris_yapilir() throws InterruptedException {
		
		
		driver=Driver.getDriver();
		driver.manage().window().maximize();
		driver.get("https://www.trendyol.com/");
		driver.findElement(By.xpath("//div[@class='link account-user']")).click();
		driver.findElement(By.id("login-email")).sendKeys("vakiftest44@gmail.com");
		driver.findElement(By.id("login-password-input")).sendKeys("Test124!");
		driver.findElement(By.cssSelector("#login-register > div.lr-container > div.q-layout.login > form > button")).click();
		Thread.sleep(1000);
		
		System.out.println("Siteye giris yapildi");
	    
	}

	@And("Urun arama alanina masaustu bilgisayar yazilir Enter basilir.")
	public void urun_arama_alanina_yazilir_enter_basilir() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.className("search-box")).sendKeys("masaustu bilgisayar");
		Thread.sleep(1000);
		driver.findElement(By.className("search-icon")).click();
		Thread.sleep(500);
		System.out.println("Urun arama yapildi");


	}

	@And("Bir urun secilir.")
	public void bir_urun_secilir() {
		
		driver.findElement(By.cssSelector("div.prdct-cntnr-wrppr  > div:nth-child(2)")).click();
		
		System.out.println("Urun secildi");
	   
	}

	@And("Urun sepete eklenir.")
	public void urun_sepete_eklenir() throws InterruptedException {
		
	Set<String> handle = driver.getWindowHandles();
		
		Iterator<String> i =handle.iterator();
		
		String parent =i.next();
		String child=i.next();
		driver.switchTo().window(child);

		Thread.sleep(1000);
		driver.findElement(By.className("add-to-basket-button-text")).click();
		Thread.sleep(1000);
		System.out.println("Urun sepete eklendi");
	    
	}

	@And("Sepete gidilir.")
	public void sepete_gidilir()throws InterruptedException  {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='link account-basket']")).click();
		Thread.sleep(2000);
		
		System.out.println("Sepete gidildi.");
	}

	
	@And("Sepetteki urun adinin dogru oldugu kontrol edilir.")
	public void sepetteki_urun_adinin_dogru_oldugu_kontrol_edilir() throws InterruptedException  {
		
		Thread.sleep(1000);
	    String getText=driver.findElement(By.cssSelector("div.pb-basket-item > a :nth-child(1)")).getText();
		Thread.sleep(1000);
	    //org.testng.Assert.assertEquals(isim, getText);
		org.testng.Assert.assertTrue(getText.contains("Oyuncu"));
		System.out.println("Sepetteki urun adinin dogru oldugu kontrol edildi");

	}

	 


	@And("cop butonuna tiklanir.")
	public void cop_butonuna_tiklanir() throws InterruptedException {
		driver.findElement(By.xpath("//i[@class='i-trash']")).click();
		Thread.sleep(1000);
		System.out.println("cop butonuna tikladi");
		
	}

	@And("Acilan popupta Sil butonuna tiklanir.")
	public void acilan_popupta_sil_butonuna_tiklanir() {
		driver.findElement(By.xpath("//button[@class=\"ty-font-w-semi-bold ty-button ty-bordered ty-transition ty-input-medium ty-primary\"]")).click();

		System.out.println("Acilan popupta Sil butonuna tiklandi.");
	}
	
	@And("Sepetim tiklanir.")
	public void sepetim_tiklanir() throws InterruptedException {

		Thread.sleep(500);
		
		driver.findElement(By.className("link-text")).click();
		
		
		System.out.println("Sepete gidildi.");
		
		
	}


	@Then("Sepette ilgili urunun bulunmadigi kontrol edilir.")
	public void sepette_ilgili_urunun_bulunmadigi_kontrol_edilir()throws InterruptedException  {
		Thread.sleep(1000);
		WebElement path=driver.findElement(By.xpath("//*[text()[contains(.,'Hesabınıza ait bir sipariş bulunamadı.')]]"));
		String responcemessage=path.getText();
		Thread.sleep(1000);
		String message="Siparişiniz Yok";
		//Assert.assertEquals(responcemessage, message);
		org.testng.Assert.assertTrue(responcemessage.contains("bulunamadı"));
		System.out.println("Sepette ilgili urunun bulunmadigi kontrol edildi.");
	}


}
