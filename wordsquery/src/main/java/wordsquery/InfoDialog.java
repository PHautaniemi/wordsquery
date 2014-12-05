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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Base class for FXML info dialogs. Tailored usage of the dialog
 * can be done with setProperties method.
 * 
 */
public class InfoDialog extends Stage {

    @FXML
    private TextField InfoText;
 
    public InfoDialog() {
        this.loadFXML();
        initModality(Modality.APPLICATION_MODAL);
    }

    @FXML
    public void InfoDialogClose(ActionEvent event) {
        System.out.println("InfoDialogClose ActionEvent");
        this.hide();
    }
    
    private void loadFXML() {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(this);
        loader.setLocation(this.getClass().getResource("/fxml/InfoDialog.fxml"));
        try {
            setScene(new Scene((Parent) loader.load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * setProperties method makes the title text and text field to have
    * values defined by the caller.
    * 
    * @param title
    * @param text
    */
    public void setProperties (String title, String text) {
        this.setTitle(title);
        InfoText.setText(text);
    }
}