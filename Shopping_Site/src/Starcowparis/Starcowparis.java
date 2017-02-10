package Starcowparis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Starcowparis {

	private static WebElement element;
	private static ChromeDriver driver;
	private static WebDriverWait wait;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\Shopping_Site\\src\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://www.starcowparis.com/");

		// login
		clickOnElement("#userBlock > a", "css", driver);

		typeTextInElement("lysilab@gmail.com", "#email", "css", driver);

		typeTextInElement("Abcd1234!!", "#passwd", "css", driver);

		clickOnElement("#SubmitLogin", "css", driver);

		clickOnElement("#mainmenuBlock > ul > li:nth-child(1) > a", "css", driver);

		clickOnElement("#categoriesFilter > ul > li:nth-child(2) > a", "css", driver);

		driver.findElement(By.xpath("//*[@id='content']/h1[contains(text(),'Footwear')]")).isDisplayed();

		clickOnElement("#content > div.productList > div:nth-child(1) > a > span.image > img", "css", driver);

		clickOnElement("#add_to_cart > button", "css", driver);

		clickOnElement("#main > p.cart_navigation > a.exclusive", "css", driver);

//		typeTextInElement("test", "#address1", "css", driver);
//
//		typeTextInElement("00000", "#postcode", "css", driver);
//
//		typeTextInElement("test", "#city", "css", driver);
//
//		typeTextInElement("00000", "#phone_mobile", "css", driver);
//
//		clickOnElement("#submitAddress", "css", driver);

		clickOnElement("#main > form > p > button > span", "css", driver);

		clickOnElement("#cgv", "css", driver);

		clickOnElement("#form > p > button > span", "css", driver);

		clickOnElement("#HOOK_PAYMENT > div > div > p > a > img", "css", driver);
	}
	
	private static void clickOnElement(String elementPath, String selectionType, WebDriver driver) {
		wait = new WebDriverWait(driver, 20);

		switch (selectionType) {
		case "css":
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementPath)));
			element = driver.findElement(By.cssSelector(elementPath));
			break;
		case "xpath":
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementPath)));
			element = driver.findElement(By.xpath(elementPath));
			break;

		default:
			break;
		}

		element.click();
	}

	private static void typeTextInElement(String enterText, String elementPath, String selectionType,
			WebDriver driver) {
		wait = new WebDriverWait(driver, 30);

		switch (selectionType) {
		case "css":
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementPath)));
			element = driver.findElement(By.cssSelector(elementPath));
			break;
		case "xpath":
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementPath)));
			element = driver.findElement(By.xpath(elementPath));
			break;

		default:
			break;
		}

		element.sendKeys(enterText);
		;
	}

}
