package qa_yandex_diplom3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import qa_yandex_diplom3.data.CommonData;
import qa_yandex_diplom3.pageobject.EnteranceForm;

public class EntranceUserYandexTest {
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
	public void EntranceTroughPersonAreaYandexTest() {
	EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageThroughPersonArea();
		form.fillEntranceForm(CommonData.EMAIL_YA, CommonData.PASSWORD);
		assertEquals(CommonData.CREATE_ORDER_BUTTON_MESSAGE, form.getCreateOrderButton().getText());	
	}
	
	@Test
	public void EntranceTroughMainPageYandexTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageThroughMainPage();
		form.fillEntranceForm(CommonData.EMAIL_YA, CommonData.PASSWORD);
		assertEquals(CommonData.CREATE_ORDER_BUTTON_MESSAGE, form.getCreateOrderButton().getText());
		
	}
	
	@Test
	public void EntranceTroughRegPageYandexTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageTroughRegPage();
		form.fillEntranceForm(CommonData.EMAIL_YA, CommonData.PASSWORD);
		assertEquals(CommonData.CREATE_ORDER_BUTTON_MESSAGE, form.getCreateOrderButton().getText());
		
	}
	
	@Test
	public void EntranceTroughRestorePasswordPageYandexTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageTroughRestorePage();;
		form.fillEntranceForm(CommonData.EMAIL_YA, CommonData.PASSWORD);
		assertEquals(CommonData.CREATE_ORDER_BUTTON_MESSAGE, form.getCreateOrderButton().getText());
		
	}
}
