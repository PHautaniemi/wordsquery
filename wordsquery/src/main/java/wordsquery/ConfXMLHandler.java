/***********************************************************************
WordsQuery helps user to study new words with any language.
Copyright (C) 2014  WordsQuery team.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

***********************************************************************/
package wordsquery;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * ConfXMLHandler Class handles the configuration and save configuration
 * and chapter wordlist in XML format using JAXB.
 * 
 */
public class ConfXMLHandler extends Stage {
    File filePath;

    public ConfXMLHandler() {
        this.filePath = null;
    }
    
    
    /**
    * getFilePath method returns the saved chapter filePath.
    * 
    * @return File or null if empty
    */
   public File getFilePath() {
       return filePath;
   }
   
    /**
    * openFile method returns the user selected filePath.
    * 
    * @return File or null if cancelled
    */
   public File openFile() {
       FileChooser fileChooser = new FileChooser();
       fileChooser.setTitle("Open Saved Wordlist");
       if (filePath != null) { /* open last file directory */
           fileChooser.setInitialDirectory(filePath.getParentFile());
       }
       File file = fileChooser.showOpenDialog(new Stage());
       if (file != null) { /* New file selected */
           filePath = file;
       }
       return file;
    }
}
