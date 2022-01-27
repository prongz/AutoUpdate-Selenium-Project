
package com.mycompany.autoupdate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SoftwareUpLoad {



    public void setWait(WebDriverWait wait ,WebDriver driver,String File) throws InterruptedException, AWTException {
        

        //*********************************DEVICE-SETTINGS******************************************//  
          
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("signal")));
            WebElement devicesettings = driver.findElements(By.className("germanFont")).get(7);
            devicesettings.click();
         
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("system_upgrade")));    
            WebElement system_upgrade=driver.findElement(By.id("system_upgrade"));
            
            system_upgrade.click();
            
            //***********************************FILE-UPLOAD*******************************************//
                       Thread.sleep(2000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadBtn")));    
            WebElement fileField=driver.findElement(By.id("uploadBtn"));
            fileField.click();

            Thread.sleep(2000);
            
            Robot rb = new Robot();               
            StringSelection str1 = new StringSelection(File);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str1, null);     
                
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
                              
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);
                     
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);     
            Thread.sleep(1000);
            
            WebElement fileupload=driver.findElements(By.className("btn-primary")).get(0);
            fileupload.click();
            Thread.sleep(2000);
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-primary")));
            Thread.sleep(3000);

            WebElement sysupgrade=driver.findElements(By.className("btn-primary")).get(1);
            sysupgrade.click();
            Thread.sleep(1000);
          
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yesbtn")));
            WebElement confirm=driver.findElement(By.id("yesbtn"));
            confirm.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okbtn")));
            WebElement confirm2=driver.findElement(By.id("okbtn"));
            confirm2.click();
        
   
    }
  
  
  


        
       
   
    
    
         
    
}
