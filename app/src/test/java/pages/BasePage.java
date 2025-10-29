package pages;

import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.Objects;
import org.openqa.selenium.interactions.Actions;

import Elements.EBasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final static EBasePage elements = new EBasePage();

    protected BasePage(WebDriver driver) {
        this.driver = Objects.requireNonNull(driver, "driver no puede ser null");
        this.wait   = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void sleep(int s){
        try{
                Thread.sleep(s*1000);    
            }catch(InterruptedException e){}
    }

    public void navigateToMercadoLibre() {
        driver.get("https://www.mercadolibre.com");
    }
 
    //Método estático para navegar a una URL.
    public void navigateTo(String url) {
        driver.get(url);
    }
 
    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath, esperando a que esté presentente en el DOM
    private WebElement find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    private WebElement find(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
 
    public void clickElement(String locator){
        find(locator).click();
    }

    public void clickElement(By by){
        find(by).click();
    }

    public void search(String item){
        WebElement navBar = driver.findElement(By.xpath(elements.navBar));
        navBar.sendKeys(item);
        navBar.sendKeys(Keys.RETURN);

    }

    public void scrollTo(By by){
        Actions action = new Actions(driver);
        
        int i = 0;
        while(!find(by).isDisplayed() || i < 30){
            sleep(1);
            action.sendKeys(Keys.PAGE_DOWN).perform();
            i++;
        }

        if(i >= 30) throw new NoSuchElementException("Elemento no encontrado durante scroll");
    }

    public boolean isInViewport(WebElement el, boolean allowPartial) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script =
            "var el=arguments[0], r=el.getBoundingClientRect();" +
            "var vh = window.innerHeight || document.documentElement.clientHeight;" +
            "var vw = window.innerWidth  || document.documentElement.clientWidth;" +
            "if (arguments[1]) {" + // parcial
            "  return r.bottom > 0 && r.right > 0 && r.top < vh && r.left < vw;" +
            "} else {" +            // completo
            "  return r.top >= 0 && r.left >= 0 && r.bottom <= vh && r.right <= vw;" +
            "}";
        return (Boolean) js.executeScript(script, el, allowPartial);
    }

    public WebElement scrollIntoView(By locator) {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center', inline:'nearest'});", el);
        wait.until(d -> isInViewport(el, true));
        return el;
    }

    public void scrollAndClick(By by){
        scrollIntoView(by);
        clickElement(by);
    }

    public void scrollAndClick(String locator){
        By by = By.xpath(locator);
        
        scrollIntoView(by);
        clickElement(by);
    }

    public void doubleClick(String locator) {
        By by = By.xpath(locator);

        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        new Actions(driver).moveToElement(el).doubleClick().perform();
    }

    public void jsClick(String locator) {
        By by = By.xpath(locator);

        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }
 
}
