package commonClassesReusable;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dynamicwait extends BrowserSelection {

	static WebDriverWait wait = new WebDriverWait(driver, 20, 500);

	/**
	 * @param args
	 */
	static int i = 0;

	public static void WaitUntilElement(By by) throws InterruptedException {
		try {
			driver.manage().timeouts().pageLoadTimeout(-1, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			System.out.println("There is some performance issue page was not loaded at all.");
		}
		
		for (i = 0; i <= 10; i++) {
			try {
				if (driver.findElement(By.xpath(loaderEle)).getAttribute("style").contains("block")
						|| driver.findElement(By.xpath(loaderEle)).getAttribute("style").contains("inline")) {
					Thread.sleep(200);
					System.out.println("Loading!");
				} else {
					Thread.sleep(100);
					System.out.println("Loading done!");
					break;
				}
			} catch (NoSuchElementException e) {
				break;
			}
		}

		

		for (i = 0; i <= 20; i++) {
			Thread.sleep(200);
			if (driver.findElements(by).size() != 0) {
				System.out.println("Element was found");
				break;
			} else {
				Thread.sleep(100);
				System.out.println("Element was not found."+i);
				
			}
		}
}

	public static void waitFluent(By by) {

		Wait<WebDriver> waits = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		waits.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
	}

	public static void waitFor(String xPath) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
	}

}
