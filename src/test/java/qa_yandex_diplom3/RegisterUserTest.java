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
import qa_yandex_diplom3.pageobject.RegForm;

@RunWith(Parameterized.class)
public class RegisterUserTest {
	private WebDriver driver;
	WebDriverData driverType= new WebDriverData();
	private final String browserName;
	
    public RegisterUserTest(String browserName) {
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
