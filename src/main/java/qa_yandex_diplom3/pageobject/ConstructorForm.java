package qa_yandex_diplom3.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorForm {
	private WebDriver driver;
	 private By souseButton = By.xpath(".//span[(@class = 'text text_type_main-default') and (text() = 'Соусы')]");
	 private By selectedSouseButton = By.xpath(".//span[(@class = 'text text_type_main-default') and (text() = 'Соусы')]/..");
	 private By fillingButton = By.xpath(".//span[(@class = 'text text_type_main-default') and (text() = 'Начинки')]");
	 private By selectedFillingButton = By.xpath(".//span[(@class = 'text text_type_main-default') and (text() = 'Начинки')]/..");
	 private By bunButton = By.xpath(".//span[(@class = 'text text_type_main-default') and (text() = 'Булки')]");
	 private By selectedBunButton = By.xpath(".//span[(@class = 'text text_type_main-default') and (text() = 'Булки')]/..");

	public ConstructorForm(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void goToSouseButton() {
		new WebDriverWait(driver, 7);
		driver.findElement(souseButton).click();
	}
	
	public void goToFillingButton() {
		new WebDriverWait(driver, 7);
		driver.findElement(fillingButton).click();
	}
	
	public void goToBunButton() {
		new WebDriverWait(driver, 7);
		driver.findElement(bunButton).click();
	}
	
    public WebElement getFillingActiveButton() {
    	new WebDriverWait(driver, 7);
    	return driver.findElement(selectedFillingButton);
    }
    
    public WebElement getBunActiveButton() {
    	new WebDriverWait(driver, 7);
    	return driver.findElement(selectedBunButton);
    }
    
    public WebElement getSouseActiveButton() {
    	new WebDriverWait(driver, 7);
    	return driver.findElement(selectedSouseButton);
    }

}
