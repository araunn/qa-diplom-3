package qa_yandex_diplom3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import qa_yandex_diplom3.data.CommonData;
import qa_yandex_diplom3.pageobject.ConstructorForm;

public class GoToSectionYandexTest {
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
	public void GoToFillingSectionYandexTest() {
		ConstructorForm section = new ConstructorForm(driver);
        section.goToFillingButton();
		assertEquals(CommonData.SELECTED_SECTION_CLASS_NAME, section.getFillingActiveButton().getAttribute("class"));
	}
	
	@Test
	public void GoToBunSectionYandexTest() {
		ConstructorForm section = new ConstructorForm(driver);
		section.goToFillingButton();
        section.goToBunButton();
		assertEquals(CommonData.SELECTED_SECTION_CLASS_NAME, section.getBunActiveButton().getAttribute("class"));
	}

	@Test
	public void GoToSouseSectionYandexTest() {
		ConstructorForm section = new ConstructorForm(driver);
        section.goToSouseButton();
		assertEquals(CommonData.SELECTED_SECTION_CLASS_NAME, section.getSouseActiveButton().getAttribute("class"));
	}
}
