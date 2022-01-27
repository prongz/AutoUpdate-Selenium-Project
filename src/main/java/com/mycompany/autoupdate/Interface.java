

//****************** First Interface Menu ********************//

package com.mycompany.autoupdate;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//************************* INIT **************************//

public  class Interface implements Initializable {

    @FXML
    private Button firstchoose;
    @FXML
    private TextField firstadress;
    @FXML
    private TextField secondadress;
    @FXML
    private Button start;
    @FXML
    private Label Status;

    String FileName1 = "ARG_v3_UpdateConfig_MBN_ver4.104_newflashcfg_ML100+_CPE_1E0XXX_V1R07B01T07P43_TZ01_new_flash_1.00.zip" ;
    String FileName2 = "ARG_v3_UpdateConfig_MBN_ver4.105_newflashcfg_ML100+_CPE_1E0XXX_V1R07B01T07P43_TZ01_new_flash_signature_1.00.zip";
    String File1,File2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Status.setText("Please Dont Close Any Window During Update");

          
    }    
    @FXML
    private void getfile1() throws InterruptedException {

        FileCatcher Catch = new FileCatcher();   
          firstadress.setText(Catch.AdCatcher(FileName1));
          File1 = Catch.getFileAdd();
    }

    @FXML
    private void getfile2() throws InterruptedException {     
         FileCatcher Catch = new FileCatcher();         
        secondadress.setText(Catch.AdCatcher(FileName2));
        File2 = Catch.getFileAdd();
    }
    

    @FXML
    public void start()  throws IOException, InterruptedException, AWTException
    {

   System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");     
        Status.setText("");
        if((File1 == null) | (File2 == null))   
        
            Status.setText("Please Choose Both Files");

        else
            {   
            WebDriver driver=new ChromeDriver(); 
            WebDriverWait wait = new WebDriverWait(driver, 2500);
             driver.manage().window().maximize();
             driver.get("http://192.168.1.1");
            
            Login.setSection(1,driver,wait);
            SoftwareUpLoad su = new SoftwareUpLoad();
            su.setWait(wait, driver, File1);
       
            Thread.sleep(120000);
            driver.get("http://192.168.1.1");
            Login.setSection(1,driver,wait);
            su.setWait(wait, driver, File2);
             
            driver.close();
            Status.setText("DONE");
            }
                      

                    
            
     
    }
  
}
