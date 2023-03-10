package core;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver driver;

	public static WebDriver lanch() {
		String browser = properties("commanLocators", "browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static String properties(String path, String global) {
		String varGlobal = null;
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\pathLocators\\pathOfLocators.prop");
			Properties prop = new Properties();
			prop.load(fis);
			String pathOfPage = prop.getProperty(path);
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + pathOfPage);
			prop.load(fi);
			varGlobal = prop.getProperty(global);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return varGlobal;

	}

	public static void getUrl() {
		driver.get(properties("commanLocators", "url"));
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static void clickToControl(String path, String global) {
		getElement(path, global).click();
	}

	public static void waitForElementVisble(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement getElement(String path, String global) {
		WebElement element = driver.findElement(By.xpath(properties(path, global)));
		return element;
	}

	public static void delayWithMilliseconds(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<WebElement> getElements(String path, String global) {
		return driver.findElements(By.xpath(properties(path, global)));
	}
	
	public static void moveToElement(String path, String global)
	{
		Actions a=new Actions(driver);
		a.moveToElement(getElement(path, global)).click().perform();
	}
	
	public static void moveToElement(WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).click().perform();
	}
	public static void browserBack()
	{
		driver.navigate().back();
	}
	public static void browserClose()
	{
		driver.close();
	}
}
