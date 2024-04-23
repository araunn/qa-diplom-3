package qa_yandex_diplom3.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegForm {
	private WebDriver driver;
    private By personAreaButton = By.xpath(".//p[(@class = 'AppHeader_header__linkText__3q_va ml-2') and (text() = 'Личный Кабинет')]");
    private By regButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj') and (text() = 'Зарегистрироваться')]");
    private By regField = By.xpath(".//input[@class ='text input__textfield text_type_main-default']");
    private By registrateButton = By.xpath(".//button[(@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa') and (text() = 'Зарегистрироваться')]");
    private By wromgPasswordHolder = By.xpath(".//p[(@class = 'input__error text_type_main-default') and (text() = 'Некорректный пароль')]");
    private By enterButton = By.xpath(".//button[(@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa') and (text() = 'Войти')]");
    private By logoButton = By.xpath(".//div[(@class = 'AppHeader_header__logo__2D0X2')]");
    
    
    public RegForm(WebDriver driver) {
		super();
		this.driver = driver;
	}

    public void goToRegPage() {
    	new WebDriverWait(driver, 7);
    	driver.findElement(personAreaButton).click();
    	driver.findElement(regButton).click();
    }
    
    public void goToMainPageFromPersonArea() {
    	new WebDriverWait(driver, 7);
    	driver.findElement(logoButton).click();
    }
    
    public void fillRegForm (String name, String email, String password) {
    	List<WebElement> items = driver.findElements(regField); 
       	items.get(2).sendKeys(password);
    	items.get(1).sendKeys(email);
    	items.get(0).sendKeys(name);
    	driver.findElement(registrateButton).click();
    }
    
    public WebElement getwrongPasswordHolder () {
    	return driver.findElement(wromgPasswordHolder);
    }
    
    public WebElement getEnterButton() {
    	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(enterButton));
    	return driver.findElement(enterButton);
    }
}
