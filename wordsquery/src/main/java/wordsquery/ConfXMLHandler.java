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
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

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

   public void savePersonDataToFile(File file, Results results) {
    try {
        JAXBContext context = JAXBContext
                .newInstance(Results.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Wrapping the data.
        Results wrapper = results;
        String data = wrapper.getResults();
        System.out.println(data);

        // Marshalling and saving XML to the file.
        m.marshal(wrapper, file);
        System.out.println(file);

        // Save the file path to the registry.
        //setPersonFilePath(file);
    } catch (Exception e) { // catches ANY exception
        System.out.println(e);
    }
}
}
