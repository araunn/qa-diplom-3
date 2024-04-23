package qa_yandex_diplom3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import qa_yandex_diplom3.data.CommonData;
import qa_yandex_diplom3.pageobject.EnteranceForm;

public class GoToPersonAreaPageChromeTest {
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
	public void GoToPersonAreaChromeTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageThroughPersonArea();
		form.fillEntranceForm(CommonData.EMAIL, CommonData.PASSWORD);
		form.goToEntrancePageThroughPersonArea();
		assertEquals(CommonData.PROFILE_BUTTON_MESSAGE, form.getProfileButton().getText());
	}

}
