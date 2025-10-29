package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.NavigationPage;

public class NavigationSteps {

    private NavigationPage np = new NavigationPage(DriverManager.get());

    @Given("Enter the website")
    public void enter_the_website() {
        System.out.println("Valor np enter_the_website() = " + np);
        np.navigateToMercadoLibre();
    }

    @Then("Select Mexico as a country")
    public void select_mexico_as_a_country(){
        np.clickMexico();
    }

    @Then("Search for the term playstation 5")
    public void search_for_the_term_playstation_5(){
        np.searchPlaystation5();
    }

    @Then("Filter by condition Nuevos")
    public void filter_by_condition_nuevos(){
        np.filterByNuevos();
    }

    @Then("Filter by location Cdmx")
    public void filter_by_location_cdmx(){
        np.filterByLocation();
    }

    @Then("Order by mayor a menor precio")
    public void order_by_mayor_a_menor_precio(){
        np.orderByMostToLeast();
    }

    @Then("Obtain the name and the price of the first 5 products")
    public void obtain_the_name_and_the_price_of_the_first_5_products(){
        np.printFirstFiveProductsAndPricePLP();
    }

    @Then("Print these products in the console")
    public void print_these_products_in_console(){
        
    }

    
}
