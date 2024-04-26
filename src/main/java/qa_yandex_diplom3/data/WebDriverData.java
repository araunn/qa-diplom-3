package qa_yandex_diplom3.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverData {
	
	public WebDriver getCromeDiver() {
		return new ChromeDriver();
	}
	
	public WebDriver getYandexDiver() {
        ChromeOptions options = new ChromeOptions();		
		   System.setProperty("webdriver.chrome.driver", "webdriver/yandexdriver.exe");
		return new ChromeDriver(options);
	}

}
