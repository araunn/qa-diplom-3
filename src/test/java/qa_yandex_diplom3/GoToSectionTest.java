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
import qa_yandex_diplom3.pageobject.ConstructorForm;

@RunWith(Parameterized.class)
public class GoToSectionTest {
	private WebDriver driver;
	WebDriverData driverType= new WebDriverData();
	private final String browserName;
	
    public GoToSectionTest(String browserName) {
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
	public void GoToFillingSectionCromeTest() {
		ConstructorForm section = new ConstructorForm(driver);
        section.goToFillingButton();
		assertEquals(CommonData.SELECTED_SECTION_CLASS_NAME, section.getFillingActiveButton().getAttribute("class"));
	}
	
	@Test
	public void GoToBunSectionChromeTest() {
		ConstructorForm section = new ConstructorForm(driver);
		section.goToFillingButton();
        section.goToBunButton();
		assertEquals(CommonData.SELECTED_SECTION_CLASS_NAME, section.getBunActiveButton().getAttribute("class"));
	}

	@Test
	public void GoToSouseSectionChromeTest() {
		ConstructorForm section = new ConstructorForm(driver);
        section.goToSouseButton();
		assertEquals(CommonData.SELECTED_SECTION_CLASS_NAME, section.getSouseActiveButton().getAttribute("class"));
	}
}
