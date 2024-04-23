package qa_yandex_diplom3.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnteranceForm {
	private WebDriver driver;
	 private By personAreaButton = By.xpath(".//p[(@class = 'AppHeader_header__linkText__3q_va ml-2') and (text() = 'Личный Кабинет')]");
	 private By entranceField = By.xpath(".//input[@class ='text input__textfield text_type_main-default']");
	 private By enterButtonOnPersonArea = By.xpath(".//button[(@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa') and (text() = 'Войти')]");
	 private By enterButtonOnMainPage = By.xpath(".//button[(@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg') and (text() = 'Войти в аккаунт')]");
	 private By regButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj') and (text() = 'Зарегистрироваться')]");
	 private By createOrderButton = By.xpath(".//button[(@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg') and (text() = 'Оформить заказ')]");
	 private By enterButtonOnRegPage = By.xpath(".//a[(@class = 'Auth_link__1fOlj') and (text() = 'Войти')]");
	 private By restorePasswordButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj') and (text() = 'Восстановить пароль')]");
	 private By personAreaProfileButton = By.xpath(".//a[(@class = 'Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9') and (text() = 'Профиль')]");
	 private By constructordButton = By.xpath(".//p[(@class = 'AppHeader_header__linkText__3q_va ml-2') and (text() = 'Конструктор')]");
	 private By logoButton = By.xpath(".//div[(@class = 'AppHeader_header__logo__2D0X2')]");
	 private By exitAccountButton = By.xpath(".//button[(@class = 'Account_button__14Yp3 text text_type_main-medium text_color_inactive') and (text() = 'Выход')]");

	 
	public EnteranceForm(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
    public void goToEntrancePageThroughPersonArea() {
    	new WebDriverWait(driver, 7);
    	driver.findElement(personAreaButton).click();
    }
    
    public void goToConstractorPageFromPersonArea() {
    	new WebDriverWait(driver, 7);
    	driver.findElement(constructordButton).click();
    }
    
    public void goToMainPageFromPersonArea() {
    	new WebDriverWait(driver, 7);
    	driver.findElement(logoButton).click();
    }
    
    public void goToEntrancePageThroughMainPage() {
    	new WebDriverWait(driver, 7);
    	driver.findElement(enterButtonOnMainPage).click();
    }
    
    public void exitFromAccount() {
    	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(exitAccountButton));
    	driver.findElement(exitAccountButton).click();
    }
    
    public void goToEntrancePageTroughRegPage() {
    	driver.findElement(personAreaButton).click();
    	driver.findElement(restorePasswordButton).click();
    	driver.findElement(enterButtonOnRegPage).click();
    }
    
    public void goToEntrancePageTroughRestorePage() {
    	driver.findElement(personAreaButton).click();
    	driver.findElement(regButton).click();
    	driver.findElement(enterButtonOnRegPage).click();
    }
	
    public void fillEntranceForm (String email, String password) {
    	List<WebElement> items = driver.findElements(entranceField); 
       	items.get(1).sendKeys(password);
    	items.get(0).sendKeys(email);
    	driver.findElement(enterButtonOnPersonArea).click();
    }
	
    public WebElement getCreateOrderButton() {
    	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(createOrderButton));
    	return driver.findElement(createOrderButton);
    }
    
    public WebElement getProfileButton() {
    	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(personAreaProfileButton));
    	return driver.findElement(personAreaProfileButton);
    }
    
    public WebElement getEnterButtonOnPersonAreaButton() {
    	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(enterButtonOnPersonArea));
    	return driver.findElement(enterButtonOnPersonArea);
    }

}
