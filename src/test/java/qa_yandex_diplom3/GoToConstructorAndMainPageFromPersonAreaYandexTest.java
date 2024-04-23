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

public class GoToConstructorAndMainPageFromPersonAreaYandexTest {
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
	public void GoToConstractorPageFromPersonAreaPageYandexTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageThroughPersonArea();
		form.fillEntranceForm(CommonData.EMAIL_YA, CommonData.PASSWORD);
		form.goToEntrancePageThroughPersonArea();
		form.goToConstractorPageFromPersonArea();
		assertEquals(CommonData.CREATE_ORDER_BUTTON_MESSAGE, form.getCreateOrderButton().getText());
	}
	
	@Test
	public void GoToMainPageFromPersonAreaPageYandexTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageThroughPersonArea();
		form.fillEntranceForm(CommonData.EMAIL_YA, CommonData.PASSWORD);
		form.goToEntrancePageThroughPersonArea();
		form.goToMainPageFromPersonArea();;
		assertEquals(CommonData.CREATE_ORDER_BUTTON_MESSAGE, form.getCreateOrderButton().getText());
	}

}
