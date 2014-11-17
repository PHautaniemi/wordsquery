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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.collections.ObservableList;

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
    private Sphere VerdictLamp;
    @FXML
    private Color x4;
    @FXML
    private Font x3;
    @FXML
    private ListView<?> ResultTextArea;
    @FXML
    private Button AddToList;
    
    public static int ResultIndex;
    public static ObservableList ResultData = FXCollections.observableArrayList();
    
  
    @FXML
    private void AddToListReleased(MouseEvent event) {
    //TODO: Get incorrect answers added to Results word list
        AddToList.setVisible(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToLanguage.setItems(FXCollections.observableArrayList("English", "Swedish", "Finnish"));
        FromLanguage.setItems(FXCollections.observableArrayList("Finnish", "Swedish", "English"));
        ToLanguage.getSelectionModel().selectFirst();
        FromLanguage.getSelectionModel().selectFirst();
    
        ResultIndex=0;
        ResultTextArea.setPrefSize(200, 250);
        
        
       // ResultTextArea.appendText("                Query Results              \n");
       // ResultTextArea.appendText("\n");
        
    }    

    @FXML
    private void FromWordKeyPressed(KeyEvent event) {
        
        ToWord.setText("");
        if (event.getCode() == KeyCode.ENTER)
        {
              System.out.println("ENTER");
        }

    }

    @FXML
    private void ToWordKeyPressed(KeyEvent event) {
 
        ToWord.setStyle("-fx-text-inner-color: black;");
        if (event.getCode() == KeyCode.ENTER)
        {
            Translation t = new Translation();
            String result=t.Translate(FromLanguage.getSelectionModel().getSelectedItem().toString(),
            ToLanguage.getSelectionModel().getSelectedItem().toString(), FromWord.getText());
            String AnswerText=ToWord.getText();
            Results r = new Results(ResultData, ResultTextArea);
            if(r.CheckResult(result, FromWord.getText(), ToWord.getText()))
            {
                ToWord.setStyle("-fx-text-inner-color: green;");
                String s="'"+AnswerText+"' is correct!";
                ToWord.setText(s);
                r.SaveResult(FromWord.getText(),AnswerText, true);
            }  
            else
            {
                AddToList.setVisible(true);
                ToWord.setStyle("-fx-text-inner-color: red;");
                System.out.println("result="+result);
                System.out.println("from="+FromWord.getText()); 
                if(FromWord.getText().equals(result)){
                    String s="No word for '"+result+"'";
                    ToWord.setText(s);
                }
                else
                {
                   String s="'"+AnswerText+"' is wrong! corect answer is '"+result+"'";
                   ToWord.setText(s);
                   r.SaveResult(FromWord.getText(),AnswerText, false);
                }
            }
        
        }
    } 
    
 
}
