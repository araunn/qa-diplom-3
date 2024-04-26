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
public class GoToPersonAreaPageTest {
	private WebDriver driver;
	WebDriverData driverType= new WebDriverData();
	private final String browserName;
	
    public GoToPersonAreaPageTest(String browserName) {
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
	public void GoToPersonAreaChromeTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageThroughPersonArea();
		form.fillEntranceForm(CommonData.EMAIL, CommonData.PASSWORD);
		form.goToEntrancePageThroughPersonArea();
		assertEquals(CommonData.PROFILE_BUTTON_MESSAGE, form.getProfileButton().getText());
	}

}
