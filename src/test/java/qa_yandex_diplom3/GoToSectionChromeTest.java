package qa_yandex_diplom3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import qa_yandex_diplom3.data.CommonData;
import qa_yandex_diplom3.pageobject.ConstructorForm;

public class GoToSectionChromeTest {
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
