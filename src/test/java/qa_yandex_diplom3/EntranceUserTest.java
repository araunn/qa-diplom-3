package qa_yandex_diplom3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import qa_yandex_diplom3.data.CommonData;
import qa_yandex_diplom3.data.WebBrowserData;
import qa_yandex_diplom3.data.WebDriverData;
import qa_yandex_diplom3.pageobject.EnteranceForm;

@RunWith(Parameterized.class)
public class EntranceUserTest {
	private WebDriver driver;
	WebDriverData driverType= new WebDriverData();
	private final String browserName;
	
    public EntranceUserTest(String browserName) {
		this.browserName = browserName;
	}
   
	@Parameterized.Parameters
	public static Object[][] testAnimalsParam() {
	   return new Object[][] {
	           {WebBrowserData.CROME_DRIVER},
	           {WebBrowserData.YANDEX_DRIVER},
	   };
	}
		
	@Before
    public void checkExistUser () {
		 switch (browserName) {
         case WebBrowserData.CROME_DRIVER:{driver = driverType.getCromeDiver(); break;}
         case WebBrowserData.YANDEX_DRIVER: {driver= driverType.getYandexDiver();  break;}
		 }
		driver.get(CommonData.SITE_ADRESS);
    }

	@After
	public void teardown() {
	    driver.quit();
	}

	@Test
	public void EntranceTroughPersonAreaCromeTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageThroughPersonArea();
		form.fillEntranceForm(CommonData.EMAIL, CommonData.PASSWORD);
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
