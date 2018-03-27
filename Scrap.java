package Scrapper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.*******.com/Gurgaon/Spa-in-Gurgaon");
		driver.manage().window().maximize();	
	    WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("bcard99")));
		
		System.out.println(driver.getTitle());
		
		List<WebElement> byclass = driver.findElements(By.className("jcn"));
		  for(WebElement element:byclass){
			String href= element.findElement(By.tagName("a")).getAttribute("href");
		//	System.out.println(href);
	 try {
		Document doc = Jsoup.connect(href).get();
		String title= doc.title();
		System.out.print(title);
		Elements el=doc.getElementsByClass("lng_add");
		//System.out.println(" , "+el.text());
		Elements tel=doc.getElementsByClass("tel");
		for( Element ep:tel)
		{
			System.out.print(","+ep.text());
		}
		
		System.out.println();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		  }
		
	}

}
