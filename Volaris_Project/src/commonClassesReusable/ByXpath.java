package commonClassesReusable;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ByXpath extends BrowserSelection {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */

	static WebElement element;
	static List<WebElement> eleXpath = null;
	static Select select;
	static Actions act;

	public static void moveToElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

	public static void actionClick(String finalxpath) throws InterruptedException {
		try {
			if (ByXpath.isObjectAvailable(finalxpath)) {
				act = new Actions(driver);
				act.moveToElement(driver.findElement(By.xpath(finalxpath))).click().perform();
			} else
				throw new NoSuchElementException("Element was not found on page: " + finalxpath);
		} catch (NoSuchElementException e) {
			Thread.sleep(1000);
			if (ByXpath.isObjectAvailable(finalxpath)) {
				act = new Actions(driver);
				act.moveToElement(driver.findElement(By.xpath(finalxpath))).click().perform();
			} else
				throw new NoSuchElementException("Still element is not avaialbe on page: " + finalxpath);

		} catch (WebDriverException e) {
			Thread.sleep(1000);
			if (ByXpath.isObjectAvailable(finalxpath)) {
				act = new Actions(driver);
				act.moveToElement(driver.findElement(By.xpath(finalxpath))).click().perform();
			} else
				throw new WebDriverException("Still element is not avaialbe on page: " + finalxpath);

		}
	}

	public static void jClick(String finalxpath) throws InterruptedException {

		dynamicwait.WaitUntilElement(By.xpath(finalxpath));
		WebElement element = driver.findElement(By.xpath(finalxpath));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		log1.info("Clicked on: ." + finalxpath);

	}

	public static void click(String finalxpath) throws InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			element = driver.findElement(By.xpath(finalxpath));
			Jexecutor.highlightElement(element);
			element.click();
			log1.info("Clicked.");

		} catch (WebDriverException e) {
			Thread.sleep(1500);
			if (ByXpath.isObjectAvailable(finalxpath)) {
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				Jexecutor.highlightElement(element);
				moveToElement(element);
				element.click();
				log1.info("Clicked.");

			} else
				throw new WebDriverException("Still Element is not found on page for: " + finalxpath);
		}
	}

	
	public static void submit(String finalxpath) throws InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			element = driver.findElement(By.xpath(finalxpath));
			Jexecutor.highlightElement(element);
			element.submit();
			log1.info("Clicked.");

		} catch (WebDriverException e) {
			Thread.sleep(1500);
			if (ByXpath.isObjectAvailable(finalxpath)) {
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				Jexecutor.highlightElement(element);
				moveToElement(element);
				element.submit();
				log1.info("Clicked.");

			} else
				throw new WebDriverException("Still Element is not found on page for: " + finalxpath);
		}
	}

	public static String getText(String finalxpath) throws InterruptedException {
		try {
			if (ByXpath.isObjectAvailable(finalxpath)) {
				String textvalue = null;
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				textvalue = element.getText();
				return textvalue;
			} else
				throw new NoSuchElementException("Element was not found on page: " + finalxpath);
		} catch (NoSuchElementException e) {
			Thread.sleep(1500);
			if (ByXpath.isObjectAvailable(finalxpath)) {
				String textvalue = null;
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				textvalue = element.getText();
				return textvalue;
			} else
				throw new NoSuchElementException("Still Element is not found on page: " + finalxpath);

		} catch (WebDriverException e) {
			Thread.sleep(1500);
			if (ByXpath.isObjectAvailable(finalxpath)) {
				String textvalue = null;
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				textvalue = element.getText();
				return textvalue;
			} else
				throw new WebDriverException("Still Element is not found on page: " + finalxpath);

		}

	}

	public static void drpdwnByIndex(String finalxpath, int value) throws InterruptedException {

		try {
			if (ByXpath.isObjectAvailable(finalxpath)) {
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				Jexecutor.highlightElement(element);
				select = new Select(driver.findElement(By.xpath(finalxpath)));
				select.selectByIndex(value);
				log1.info("Value Selected.");
			} else
				throw new NoSuchElementException("Element was not found on page: " + finalxpath);
		} catch (NoSuchElementException e) {
			Thread.sleep(1500);
			if (ByXpath.isObjectAvailable(finalxpath)) {
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				Jexecutor.highlightElement(element);
				select = new Select(driver.findElement(By.xpath(finalxpath)));
				select.selectByIndex(value);
				log1.info("Value Selected.");
			} else
				throw new NoSuchElementException("Still Element is not found on page: " + finalxpath);

		} catch (WebDriverException e) {
			Thread.sleep(1500);
			if (ByXpath.isObjectAvailable(finalxpath)) {
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				Jexecutor.highlightElement(element);
				select = new Select(driver.findElement(By.xpath(finalxpath)));
				select.selectByIndex(value);
				log1.info("Value Selected.");
			} else
				throw new WebDriverException("Still Element is not found on page: " + finalxpath);

		}

	}

	public static void drpdwnByText(String finalxpath, String visibleText) throws InterruptedException {

		try {
			if (ByXpath.isObjectAvailable(finalxpath)) {
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				Jexecutor.highlightElement(element);
				select = new Select(driver.findElement(By.xpath(finalxpath)));
				select.selectByVisibleText((visibleText.trim()));
				log1.info("Value Selected.");
			} else
				throw new NoSuchElementException("Element was not found on page: " + finalxpath);
		} catch (NoSuchElementException e) {
			Thread.sleep(1500);
			if (ByXpath.isObjectAvailable(finalxpath)) {
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				Jexecutor.highlightElement(element);
				select = new Select(driver.findElement(By.xpath(finalxpath)));
				select.selectByVisibleText((visibleText.trim()));
				log1.info("Value Selected.");
			} else
				throw new NoSuchElementException("Still Element is not found on page: " + finalxpath);

		} catch (WebDriverException e) {
			Thread.sleep(1500);
			if (ByXpath.isObjectAvailable(finalxpath)) {
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				Jexecutor.highlightElement(element);
				select = new Select(driver.findElement(By.xpath(finalxpath)));
				select.selectByVisibleText((visibleText.trim()));
				log1.info("Value Selected.");
			} else
				throw new WebDriverException("Still Element is not found on page: " + finalxpath);

		}

	}

	public static String getAttributeValue(String finalxpath, String attributeName) throws InterruptedException {

		try {
		
			String value = "";
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			element = driver.findElement(By.xpath(finalxpath));
			value = element.getAttribute(attributeName.trim());
			Thread.sleep(1500);
			return value;

		} catch (NoSuchElementException e) {
			Thread.sleep(1500);

			String value = "";
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			element = driver.findElement(By.xpath(finalxpath));
			value = element.getAttribute(attributeName.trim());
			return value;

		} catch (WebDriverException e) {
			Thread.sleep(1500);

			String value = "";
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			element = driver.findElement(By.xpath(finalxpath));
			value = element.getAttribute(attributeName.trim());
			return value;

		}

	}

	public static void sendKeys(String finalxpath, String data) throws InterruptedException {

		try {
			if (ByXpath.isObjectAvailable(finalxpath)) {
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				element.sendKeys(data.trim());
				log1.info("Data send to control.");
			} else
				throw new NoSuchElementException("Element was not found on page: " + finalxpath);
		} catch (NoSuchElementException e) {
			Thread.sleep(1500);
			if (ByXpath.isObjectAvailable(finalxpath)) {
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				element.sendKeys(data.trim());
				log1.info("Data send to control.");
			} else
				throw new NoSuchElementException("Still Element is not found on page: " + finalxpath);

		} catch (WebDriverException e) {
			Thread.sleep(1500);
			if (ByXpath.isObjectAvailable(finalxpath)) {
				dynamicwait.WaitUntilElement(By.xpath(finalxpath));
				element = driver.findElement(By.xpath(finalxpath));
				element.sendKeys(data.trim());
				log1.info("Data send to control.");
			} else
				throw new WebDriverException("Still Element is not found on page: " + finalxpath);

		}
	}
	
    public static String getInnerHTML(String finalxpath) throws InterruptedException {
        try {
            if (ByXpath.isObjectAvailable(finalxpath)) {
                String textvalue = null;
                dynamicwait.WaitUntilElement(By.xpath(finalxpath));
                element = driver.findElement(By.xpath(finalxpath));
                textvalue = element.getAttribute("innerHTML");
                return textvalue;
            } else
                throw new NoSuchElementException("Element was not found on page: " + finalxpath);
        } catch (NoSuchElementException e) {
            Thread.sleep(1500);
            if (ByXpath.isObjectAvailable(finalxpath)) {
                String textvalue = null;
                dynamicwait.WaitUntilElement(By.xpath(finalxpath));
                element = driver.findElement(By.xpath(finalxpath));
                textvalue = element.getAttribute("innerHTML");
                return textvalue;
            } else
                throw new NoSuchElementException("Still Element is not found on page: " + finalxpath);

        } catch (WebDriverException e) {
            Thread.sleep(1500);
            if (ByXpath.isObjectAvailable(finalxpath)) {
                String textvalue = null;
                dynamicwait.WaitUntilElement(By.xpath(finalxpath));
                element = driver.findElement(By.xpath(finalxpath));
                textvalue = element.getAttribute("innerHTML");
                return textvalue;
            } else
                throw new WebDriverException("Still Element is not found on page: " + finalxpath);

        }

    }


	public static boolean isObjectAvailable(String xPath) throws NoSuchElementException, InterruptedException {
		dynamicwait.WaitUntilElement(By.xpath(xPath));
		if (driver.findElements(By.xpath(xPath)).size()!=0)
			return true;
		else
			return false;
	}
}
