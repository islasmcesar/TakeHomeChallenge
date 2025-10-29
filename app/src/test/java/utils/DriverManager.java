package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    
    private static final ThreadLocal<WebDriver> TL = new ThreadLocal<>();

    public static void start() {
        WebDriverManager.chromedriver().setup();
        TL.set(new ChromeDriver());
    }

    public static WebDriver get() {
        return TL.get();
    }

    public static void stop() {
        WebDriver d = TL.get();
        if (d != null) {
        d.quit();
        TL.remove();
        }
    }
}

