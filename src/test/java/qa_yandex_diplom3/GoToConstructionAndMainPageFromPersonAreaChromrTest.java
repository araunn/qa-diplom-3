package qa_yandex_diplom3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import qa_yandex_diplom3.data.CommonData;
import qa_yandex_diplom3.pageobject.EnteranceForm;

public class GoToConstructionAndMainPageFromPersonAreaChromrTest {
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
	public void GoToConstractorPageFromPersonAreaPageChromeTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageThroughPersonArea();
		form.fillEntranceForm(CommonData.EMAIL, CommonData.PASSWORD);
		form.goToEntrancePageThroughPersonArea();
		form.goToConstractorPageFromPersonArea();
		assertEquals(CommonData.CREATE_ORDER_BUTTON_MESSAGE, form.getCreateOrderButton().getText());
	}
	
	@Test
	public void GoToMainOageFromPersonAreaPageChromeTest() {
		EnteranceForm form = new EnteranceForm(driver);
		form.goToEntrancePageThroughPersonArea();
		form.fillEntranceForm(CommonData.EMAIL, CommonData.PASSWORD);
		form.goToEntrancePageThroughPersonArea();
		form.goToMainPageFromPersonArea();;
		assertEquals(CommonData.CREATE_ORDER_BUTTON_MESSAGE, form.getCreateOrderButton().getText());
	}

}
