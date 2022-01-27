
package com.mycompany.autoupdate;

import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Mortazavi-PC
 */
public class Login {


    public static void setSection(int section, WebDriver driver, WebDriverWait wait) throws InterruptedException, IOException {


            
        
             Thread.sleep(5000);

            if(driver.findElement(By.id("logoutlink")).isDisplayed())
            {
                WebElement logout = driver.findElement(By.id("logoutlink"));
 
                logout.click();
                Thread.sleep(2000);
                WebElement yesloguot = driver.findElement(By.id("yesbtn"));
                yesloguot.click();                      
            }  
            
               
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("iran_name")));             
           WebElement user=driver.findElement(By.id("iran_name"));
           WebElement password=driver.findElement(By.id("iran_password"));
           WebElement login=driver.findElement(By.id("login-button"));
           user.sendKeys("Root");
           password.sendKeys("MtC-UT@M85#90R0B");
           Thread.sleep(1000);
           login.click();
           Thread.sleep(1000);
           if(!(driver.findElement(By.id("logoutlink")).isDisplayed())){               
               
               log2(driver,wait);

           }
            
            
            
    }
    private static void log2(WebDriver driver, WebDriverWait wait) throws InterruptedException {
           
           driver.switchTo().alert().accept();
           driver.getWindowHandle();
           driver.get("192.168.1.1");
                     
         //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("iran_name")));             
           WebElement user=driver.findElement(By.id("iran_name"));
           WebElement password=driver.findElement(By.id("iran_password"));
           WebElement login=driver.findElement(By.id("login-button"));
           user.clear();
           password.clear();
           user.sendKeys("root");
           password.sendKeys("MtC-UT@M85#90R0B%");
         
           login.click();
  

        
        
    }

    
}
