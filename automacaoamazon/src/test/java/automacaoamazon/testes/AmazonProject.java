package automacaoamazon.testes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class AmazonProject {

	WebDriver driver;
	
	@Before
	public void abrirNavegador(){	
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
	}

	@After
	public void fecharNavegador ()
	{
		driver.quit();
	}
	
	@Test
	public void validarTitulodaPagina ()
	{
		String tituloEsperado = "Amazon.com. Spend less. Smile more.";
		String tituloEncontrado;
		
		tituloEncontrado = driver.getTitle();
		assertEquals(tituloEsperado, tituloEncontrado);
		
	}
	
	
	@Test
	public void procurarProduto() throws InterruptedException
	{
		String produto = "Apple Watch";
		String categoria = "Electronics";
		String username = "alexandresilveira89@gmail.com";
		String password = "sofia21";
		
		
		 WebElement selecionarDropBox = driver.findElement(By.id("searchDropdownBox"));
		 Select selecionarCategoria = new Select(selecionarDropBox);
		 selecionarCategoria.selectByVisibleText(categoria);
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(produto);
		 driver.findElement(By.xpath("//input[@value='Go']")).click();
		 driver.findElement(By.xpath("//img[@alt = 'SUPCASE [Unicorn Beetle Pro] Designed for Apple Watch Series 8 / 7 [45mm], Rugged Protective Case with Strap Bands for App...']")).click();
		 Thread.sleep(60);
		 Select quantity = new Select(driver.findElement(By.xpath("//select[@name = 'quantity']")));
		 quantity.selectByIndex(1);
		 driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		 driver.findElement(By.xpath("//input[@data-feature-id='proceed-to-checkout-action']")).click();
		 driver.findElement(By.xpath("//input[@type= 'email']")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@id='continue']")).click();
		 driver.findElement(By.xpath("//input[@type= 'password']")).sendKeys(password);
		 driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		 Thread.sleep(6000);
		 driver.findElement(By.xpath("//*[@id='addressChangeLinkId']")).click();
		 Thread.sleep(6000);
		 
		/* public static void clickElementByJs(WebElement element; WebDriver driver)
		 {	 
			 JavascriptExecutor executor = ((JavascriptExecutor)driver);
			 executor.executeScript("arguments[0].click();",element);
		 }

		 WebElement buttomUseThisAddress = driver.findElement(By.xpath("//input['@data-testid='Address_selectShipToThisAddress']"));
		 
		 clickElementByJs(buttomUseThisAddress,driver);
		 
		 */
		 
		 
		 
		 
		 //executor.executeScript("document.getElementById('addressChangeLinkId').click()");
		 
		 //driver.findElement(By.xpath("//*[@id='payChangeButtonId']")).click();
		
		 
		 
			 	
		 
	}

	//private void clickElementByJs(WebElement buttomUseThisAddress, WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}


