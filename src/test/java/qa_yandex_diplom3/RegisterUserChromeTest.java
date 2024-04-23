package qa_yandex_diplom3;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import qa_yandex_diplom3.data.CommonData;
import qa_yandex_diplom3.pageobject.RegForm;

public class RegisterUserChromeTest {
	private WebDriver driver= new ChromeDriver();
	
    @Before
    public void checkExistUser () {
		driver.get(CommonData.SITE_ADRESS);
    }

	@After
	public void teardown() {
	    driver.quit();
	}

	@Test
	public void RegisterWrongUserDataChromeTest() {
		RegForm regUser = new RegForm(driver);
		regUser.goToRegPage();
		regUser.fillRegForm(CommonData.NAME, CommonData.EMAIL, CommonData.WRONG_PASSWORD);
		assertEquals(CommonData.WRONG_PASSOWRD_MESSAGE, regUser.getwrongPasswordHolder().getText());
	}
	
	@Test
	public void RegisterChromeTest() {
		RegForm regUser = new RegForm(driver);
		regUser.goToRegPage();
		regUser.fillRegForm(CommonData.NAME, CommonData.EMAIL+(int)(Math.random()*10000000), CommonData.PASSWORD);
		assertEquals(CommonData.ENTER_BUTTON_MESSAGE, regUser.getEnterButton().getText());
	}
}
