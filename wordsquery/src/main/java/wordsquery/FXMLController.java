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
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FXMLController implements Initializable {
    
    private Label label;
    
    @FXML
    private ChoiceBox FromLanguage;
    
    @FXML
    private ChoiceBox ToLanguage;
    @FXML
    private VBox MainVBox;
    @FXML
    private MenuBar MainMenu;
    @FXML
    private SplitPane MainVertSplitPane;
    @FXML
    private Color x2;
    @FXML
    private Font x1;
    @FXML
    private TextField FromWord;
    @FXML
    private TextField ToWord;
    @FXML
    private Color x4;
    @FXML
    private Font x3;
    @FXML
    private ListView<?> ResultTextArea;
    @FXML
    private Button AddOwnToList;
    @FXML
    private Button AddAnswerToList;
    
    String AnswerText;
    String result;
    public static int ResultIndex;
    public static ObservableList ResultData = FXCollections.observableArrayList();

    /**
    * TODO
    */
    @FXML
    private void menuQuit() {
        System.out.println("menu clicked");
        Platform.exit();
    }

    /**
    * TODO
    */
    @FXML
    private void menuAbout() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("About Words Query");
        dlg.showAndWait();
    }
    
    /**
    * This method enables user to add different word to Results list 
    * than translate returned. Button is visible only when this is needed.
    */
    @FXML
    private void AddOwnToListReleased(MouseEvent event) {
        Results r = new Results(ResultData, ResultTextArea);
        r.SaveResult(FromWord.getText(), AnswerText, true);
        FromWord.setText(null);
        setFocus();
    }
    
    /**
    * This method enables user to add the translate returned 
    * word to Results list when own word was not correct. 
    * Button is visible only when this is needed.
    */
    @FXML
    private void AddAnswerToListReleased(MouseEvent event) {
        Results r = new Results(ResultData, ResultTextArea);
        r.SaveResult(FromWord.getText(), result, true);
        FromWord.setText(null);
        setFocus();
    }
    
    /**
    * This method moves focus back to FromWord text box and
    * also hide buttons.
    */
    public void setFocus() {
        AddOwnToList.setVisible(false);
        AddAnswerToList.setVisible(false);
        ToWord.setText(null);
        FromWord.requestFocus();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToLanguage.setItems(FXCollections.observableArrayList("English", "Swedish", "Finnish"));
        FromLanguage.setItems(FXCollections.observableArrayList("Finnish", "Swedish", "English"));
        ToLanguage.getSelectionModel().selectFirst();
        FromLanguage.getSelectionModel().selectFirst();
    
        ResultIndex=0;
        //ResultTextArea.setPrefSize(200, 250);
        
        
       // ResultTextArea.appendText("                Query Results              \n");
       // ResultTextArea.appendText("\n");
        
    }    

    @FXML
    private void FromWordKeyPressed(KeyEvent event) {
        
        ToWord.setText("");
        setFocus();
        if (event.getCode() == KeyCode.ENTER)
        {
              System.out.println("ENTER");
        }

    }

    @FXML
    private void ToWordKeyPressed(KeyEvent event) {
 
        ToWord.setStyle("-fx-text-inner-color: black;");
        AddOwnToList.setVisible(false);
        AddAnswerToList.setVisible(false);
        if (event.getCode() == KeyCode.ENTER)
        {
            Translation t = new Translation();
            result=t.Translate(FromLanguage.getSelectionModel().getSelectedItem().toString(),
            ToLanguage.getSelectionModel().getSelectedItem().toString(), FromWord.getText());
            AnswerText=ToWord.getText();
            Results r = new Results(ResultData, ResultTextArea);
            if(r.CheckResult(result, FromWord.getText(), ToWord.getText()))
            {
                ToWord.setStyle("-fx-text-inner-color: green;");
                r.SaveResult(FromWord.getText(),AnswerText, true);
                FromWord.setText(null);
                setFocus();
            }  
            else
            {
                ToWord.setStyle("-fx-text-inner-color: red;");
                System.out.println("result="+result);
                System.out.println("from="+FromWord.getText()); 
                if(FromWord.getText().equals(result)){
                    String s="No word for '"+result+"'";
                    ToWord.setText(s);
                    AddOwnToList.setVisible(true);
                }
                else
                {
                   String s="'"+AnswerText+"' is wrong! corect answer is '"+result+"'";
                   ToWord.setText(s);
                   AddOwnToList.setVisible(true);
                   AddAnswerToList.setVisible(true);
                }
            }
        
        }
    } 
    
 
}
