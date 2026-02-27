package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GraphSteps {
	 WebDriver driver = DriverFactory.getDriver();


		@Given("User is logged in to the DSAlgo portal and on graph page")
		public void user_is_logged_in_to_the_ds_algo_portal_and_on_graph_page() {
			
		    
		}

		@When("User clicks {string} link in graph page")
		public void user_clicks_link_in_graph_page(String string) {
			driver.findElement(By.xpath("//a[@href='graph']")).click();
			driver.findElement(By.xpath("//a[@href='graph']")).click();
			//driver.findElement(By.xpath("//a[@href=\"/graph/graph-representations/\"]")).click();
			
		    
		}

		@Then("user should be redirected to {string} graph page")
		public void user_should_be_redirected_to_graph_page(String string) {
			
		    
		}

		@Given("User is on {string} page in Graph module")
		public void user_is_on_page_in_graph_module(String string) {
			
		    
		}

		@When("User clicks Try Here button on respective topics covered link in graph")
		public void user_clicks_try_here_button_on_respective_topics_covered_link_in_graph() {
		    
			
		}

		@Then("User should be redirected to Try Editor page with Run button in the respective link of graph module")
		public void user_should_be_redirected_to_try_editor_page_with_run_button_in_the_respective_link_of_graph_module() {
		    
			
		}



}
