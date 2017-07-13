package commonClassesReusable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Jexecutor extends BrowserSelection {

	public static void highlightElement(WebElement element) throws InterruptedException {
		if (jsExecutor) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: brown; border: 4px solid black;");
			Thread.sleep(100);
		}
	}

	public static void hidePopup(WebElement element) throws InterruptedException {
		// js.executeScript("arguments[0].setAttribute(style.visibility='visible';
		// ");
		((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden';", element);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].style.display='none';",element);
	}

	public static void setAttributeValue(String xPath, String attributeName, String attributeValue) throws NoSuchElementException, InterruptedException {
		if (ByXpath.isObjectAvailable(xPath)) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			element = driver.findElement(By.xpath(xPath));
			js.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "')", element);
			log1.info("Attribut value set.");
		} else
			throw new NoSuchElementException("Element was not found on page: " + xPath);

	}

	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");

	}

	public static void scrollUp() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(2000);
	}
}
