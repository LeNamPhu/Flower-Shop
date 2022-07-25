
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class RegisterTest {
@Test
    public void test() throws InterruptedException {
        String email = ("tester27@gmail.com");
        System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/Workshop/");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("txtemail")).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(By.name("txtfullname")).sendKeys("Phu Le");
        Thread.sleep(1000);
        driver.findElement(By.name("txtpassword")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.name("txtphone")).sendKeys("0123456");
        Thread.sleep(1000);
        driver.findElement(By.id("register")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Main Page")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("txtemail")).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(By.name("txtpassword")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Change Profile")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("txtPassword")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("txtPassword")).sendKeys("654321");
         Thread.sleep(1000);
        driver.findElement(By.name("action")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("logout")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("txtemail")).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(By.name("txtpassword")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Log in again")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("txtemail")).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(By.name("txtpassword")).sendKeys("654321");
        Thread.sleep(1000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(4000);
        driver.close();
    }
}
