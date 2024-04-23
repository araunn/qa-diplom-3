package qa_yandex_diplom3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import qa_yandex_diplom3.data.CommonData;
import qa_yandex_diplom3.pageobject.RegForm;

public class RegisterUserYandexTest {
	private WebDriver driver;

	@Before 
	public void setUp() {
		ChromeOptions options = new ChromeOptions();		
		System.setProperty("webdriver.chrome.driver", "webdriver/yandexdriver.exe");
		driver = new ChromeDriver(options);
		driver.get(CommonData.SITE_ADRESS);
	}
	
	@After
	public void teardown() {
	    driver.quit();
	}
	
	@Test
	public void RegisterWrongUserDataYandexTest() {
		RegForm regUser = new RegForm(driver);
		regUser.goToRegPage();
		regUser.fillRegForm(CommonData.NAME, CommonData.EMAIL_YA, CommonData.WRONG_PASSWORD);
		assertEquals(CommonData.WRONG_PASSOWRD_MESSAGE, regUser.getwrongPasswordHolder().getText());
	}
	
	@Test
	public void RegisterYandexTest() {
		RegForm regUser = new RegForm(driver);
		regUser.goToRegPage();
		regUser.fillRegForm(CommonData.NAME, CommonData.EMAIL_YA+(int)(Math.random()*10000000), CommonData.PASSWORD);
		assertEquals(CommonData.ENTER_BUTTON_MESSAGE, regUser.getEnterButton().getText());
	}

}
