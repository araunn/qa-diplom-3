package qa_yandex_diplom3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import qa_yandex_diplom3.data.CommonData;
import qa_yandex_diplom3.pageobject.EnteranceForm;

public class EntranceUserChromeTest {
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
	public void EntranceTroughPersonAreaCromeTest() {
		EnteranceForm form = new EnteranceForm(driver);
		System.out.println("-----------------------");
		form.goToEntrancePageThroughPersonArea();
		System.out.println("-----------------------");
		form.fillEntranceForm(CommonData.EMAIL, CommonData.PASSWORD);
		System.out.println("-----------------------");
		assertEquals(CommonData.CREATE_ORDER_BUTTON_MESSAGE, form.getCreateOrderButton().getText());
		
	}
	
	@Test
	public void EntranceTroughMainPageCromeTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageThroughMainPage();
		form.fillEntranceForm(CommonData.EMAIL, CommonData.PASSWORD);
		assertEquals(CommonData.CREATE_ORDER_BUTTON_MESSAGE, form.getCreateOrderButton().getText());
		
	}
	
	@Test
	public void EntranceTroughRegPageCromeTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageTroughRegPage();
		form.fillEntranceForm(CommonData.EMAIL, CommonData.PASSWORD);
		assertEquals(CommonData.CREATE_ORDER_BUTTON_MESSAGE, form.getCreateOrderButton().getText());
		
	}
	
	@Test
	public void EntranceTroughRestorePasswordPageCromeTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageTroughRestorePage();;
		form.fillEntranceForm(CommonData.EMAIL, CommonData.PASSWORD);
		assertEquals(CommonData.CREATE_ORDER_BUTTON_MESSAGE, form.getCreateOrderButton().getText());
		
	}
}
