/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autoupdate;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Window;


public class FileCatcher {
    
    
    int FileSt;
    String FileAdd;
  

    public String AdCatcher(String FileName) {
        
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ZIP files "+FileName, FileName);
                fileChooser.getExtensionFilters().add(extFilter);
                 Window primaryStage = null;
                File file = fileChooser.showOpenDialog(primaryStage);
                 FileAdd = (file.toString());
                 return FileAdd;       
    }

    public String getFileAdd() {
        return FileAdd;
    }
    
  
    
}
