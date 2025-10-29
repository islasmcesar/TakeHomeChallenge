package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Elements.ENavigation;

public class NavigationPage extends BasePage{
    
    ENavigation elements = new ENavigation();
    public NavigationPage(org.openqa.selenium.WebDriver driver) { super(driver); }

    public void clickMexico(){
        WebElement mx2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elements.txtMexico)));
        mx2.click();
    }

    public void searchPlaystation5(){
        search("playstation 5");
    }

    public void filterByNuevos(){
        scrollAndClick(By.xpath(elements.txtNuevos));
    }

    public void filterByLocation(){
        scrollAndClick(elements.txtLocal);
    }

    public void orderByMostToLeast(){
        sleep(5);
        clickElement(elements.arrowFiltroPrecio);
        sleep(2);
        clickElement(elements.txtMayorPrecio);
    }

    public String getXpathOptProductoPLP(int i){
        return elements.producto1.substring(0, 41) + i + elements.producto1.substring(42);
    }

    public By getByOptProductoPLP(int i){
        return By.xpath(elements.producto1.substring(0, 41) + i + elements.producto1.substring(42));
    }

    public By getByOptPrecioPLP(String selector,int i){
        return By.xpath(selector.substring(0, 41) + i + selector.substring(42));
    }

    public void printFirstFiveProductsAndPricePLP(){
        By byProducto;
        By byPrecio;
        System.out.println("\n\nPrimeros 5 productos ordenados por Nuevo, Local y Mayor precio:\n");
        for(int i = 1;i <= 5;i++){
            byProducto = getByOptProductoPLP(i);
            byPrecio = getByOptPrecioPLP(elements.precioProducto1,i);
            scrollIntoView(byProducto);
            System.out.println("\t" + driver.findElement(byProducto).getText());
            try{
                scrollIntoView(byPrecio);
            }catch(Exception e){
                byPrecio = getByOptPrecioPLP(elements.precioProducto2,i);
                scrollIntoView(byPrecio);
            }
            System.out.println("\tPrecio: $" + driver.findElement(byPrecio).getText() + "\n");
        }
    }
}
