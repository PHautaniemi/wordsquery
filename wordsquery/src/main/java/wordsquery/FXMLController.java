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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private ChoiceBox FromLanguage;
    
    @FXML
    private ChoiceBox ToLanguage;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("WordsQuery!");
        label.setText("Version 0.1");
    }
    
    @FXML
    private void handleFromLanguageChoice(MouseEvent event) {
        FromLanguage.setItems(FXCollections.observableArrayList("Finnish", "Swedish", "English"));
    //TODO: Get language settings from Google Translate
    }

    @FXML
    private void handleToLanguageChoice(MouseEvent event) {
        ToLanguage.setItems(FXCollections.observableArrayList("Finnish", "Swedish", "English"));
    //TODO: Get language settings from Google Translate    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
