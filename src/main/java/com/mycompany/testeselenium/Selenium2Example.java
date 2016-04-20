package com.mycompany.testeselenium;
/*
http://www.seleniumhq.org/docs/03_webdriver.jsp#setting-up-webdriver-project
https://www.google.com.br/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&cad=rja&uact=8&ved=0ahUKEwi8mpTtuZvMAhXDfpAKHbjeCRMQFgglMAE&url=http%3A%2F%2Fsamples.leanpub.com%2Fselenium-recipes-in-java-sample.pdf&usg=AFQjCNE_abgKub1ipYWdqcCPicfqm2vpuQ&sig2=oQjRwB3n67f1FjDQEe4svg
HTTP requests cannot be recorded most likely because the NetBeans HTTP Server is not running. Go to the IDE and start the server from within the IDE to fix this problem.
http://goo.gl/IHP6Qw
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2Example  {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");
        //element.sendKeys("pudim.com.br");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        
        //Close the browser
        driver.quit();
    }
}