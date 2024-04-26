package qa_yandex_diplom3.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebBrowserData {
	public static final String CROME_DRIVER = "Chrome";
	public static final String YANDEX_DRIVER = "Yandex";
	
	public static ChromeOptions getOptions() {
		ChromeOptions options = new ChromeOptions();		
		System.setProperty("webdriver.chrome.driver", "webdriver/yandexdriver.exe");
		return options;
	}
	

}
