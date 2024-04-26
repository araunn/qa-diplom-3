package qa_yandex_diplom3.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckExistUserForm {
	private WebDriver driver;
	 private By personAreaButton = By.xpath(".//p[(@class = 'AppHeader_header__linkText__3q_va ml-2') and (text() = 'Личный Кабинет')]");
	 private By entranceField = By.xpath(".//input[@class ='text input__textfield text_type_main-default']");
	 private By enterButtonOnPersonArea = By.xpath(".//button[(@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa') and (text() = 'Войти')]");
	 private By logoButton = By.xpath(".//div[(@class = 'AppHeader_header__logo__2D0X2')]");


	public CheckExistUserForm(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
    public void goToEntrancePageThroughPersonArea() {
    	new WebDriverWait(driver, 7);
    	driver.findElement(personAreaButton).click();
    }
    
    public void fillEntranceForm (String email, String password) {
    	List<WebElement> items = driver.findElements(entranceField); 
       	items.get(1).sendKeys(password);
    	items.get(0).sendKeys(email);
    	driver.findElement(enterButtonOnPersonArea).click();
    }
    
    public void goToMainPageFromPersonArea() {
    	driver.findElement(logoButton).click();
    }
    
    public WebElement getCreateOrderButton() {
    	new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(enterButtonOnPersonArea));
    	return driver.findElement(enterButtonOnPersonArea);
    }

}
