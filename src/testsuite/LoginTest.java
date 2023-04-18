package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
   String baseUrl = "http://the-internet.herokuapp.com/login";

   @Before
   public void setUp(){
       openBrowser(baseUrl);
   }
   @Test

    public void userShouldLoginSuccessfullyWithValidCredentials(){
       //find login link and click on login link
       WebElement loginLink = driver.findElement(By.xpath("//h2[text() = 'Login Page']"));
       loginLink.click();
       // find the email field element and type email
       WebElement emailField = driver.findElement(By.id("username"));
       emailField.sendKeys("tomsmith");

       // find the password field element and type the password
       driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

       //Find the Login btn Element and click
       WebElement loginBtn = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
       loginBtn.click();
       String expectedMessage = "Secure Area";
       WebElement actualTestElement = driver.findElement(By.xpath("//h2[text() =' Secure Area']"));
       String actualMessage = actualTestElement.getText();
       Assert.assertEquals(expectedMessage,actualMessage);
       driver.quit();



   }
    @Test
    public void verifyTheUsernameErrorMessage(){
        WebElement loginLink = driver.findElement(By.xpath("//h2[text() = 'Login Page']"));
        loginLink.click();
        // find the email field element and type email
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("tomsmith1");

        // find the password field element and type the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //Find the Login btn Element and click
        WebElement loginBtn = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginBtn.click();
        String expectedMessage = "Your username is invalid!\n" +
                "×";
        WebElement actualTestElement = driver.findElement(By.id("flash"));
        String actualMessage = actualTestElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        driver.quit();





    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //find login link and click on login link
        WebElement loginLink = driver.findElement(By.xpath("//h2[text() = 'Login Page']"));
        loginLink.click();
        // find the email field element and type email
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("tomsmith");

        // find the password field element and type the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        //Find the Login btn Element and click
        WebElement loginBtn = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginBtn.click();
        String expectedMessage = "Your password is invalid!\n" +
                "×";
        WebElement actualTestElement = driver.findElement(By.id("flash"));
        String actualMessage = actualTestElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        driver.quit();

    }

}
