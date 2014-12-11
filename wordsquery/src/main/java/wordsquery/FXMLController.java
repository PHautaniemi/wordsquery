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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
    @FXML
    private Button ClearButton;
    
    String AnswerText;
    String result;
    public static int ResultIndex;
    public static ObservableList ResultData = FXCollections.observableArrayList();

    /**
    * menuQuit method that calls exit()
    */
    @FXML
    private void menuQuit() {
        System.out.println("menu clicked");
        Platform.exit();
    }

    /**
    * menuNew method that invokes InfoDialog with texts
    */
    @FXML
    private void menuNew() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu New functionality", 
        "Not implemented yet. Invokes new chapter.");
        dlg.showAndWait();
    }

    /**
    * menuOpen method that invokes InfoDialog with texts
    */
    @FXML
    private void menuOpen() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu Open functionality", 
        "Not implemented yet. Opens saved chapter.");
        dlg.showAndWait();
    }

    /**
    * menuOpenRecent method that invokes InfoDialog with texts
    */
    @FXML
    private void menuOpenRecent() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu Open Recent functionality", 
        "Not implemented yet. Open list of recently saved chapters.");
        dlg.showAndWait();
    }

    /**
    * menuClose method that invokes InfoDialog with texts
    */
    @FXML
    private void menuClose() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu Close functionality", 
        "Not implemented yet. Closes chapter without save.");
        dlg.showAndWait();
    }

    /**
    * menuSave method that invokes InfoDialog with texts
    */
    @FXML
    private void menuSave() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu Save functionality", 
        "Not implemented yet. Save named chapter with words.");
        dlg.showAndWait();
    }

    /**
    * menuSaveAs method that invokes InfoDialog with texts
    */
    @FXML
    private void menuSaveAs() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu Save As functionality", 
        "Not implemented yet. Save chapter with different name or formats");
        dlg.showAndWait();
    }

    /**
    * menuUndo method that invokes InfoDialog with texts
    */
    @FXML
    private void menuUndo() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu Undo functionality", 
        "Not implemented yet. Undo the last change.");
        dlg.showAndWait();
    }

    /**
    * menuRedo method that invokes InfoDialog with texts
    */
    @FXML
    private void menuRedo() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu Redo functionality", 
        "Not implemented yet. Redo last undo.");
        dlg.showAndWait();
    }

    /**
    * menuCut method that invokes InfoDialog with texts
    */
    @FXML
    private void menuCut() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu Cut functionality", 
        "Not implemented yet. Removes selection with cut function.");
        dlg.showAndWait();
    }

    /**
    * menuCopy method that invokes InfoDialog with texts
    */
    @FXML
    private void menuCopy() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu Copy functionality", 
        "Not implemented yet. Copies selected text.");
        dlg.showAndWait();
    }

    /**
    * menuPaste method that invokes InfoDialog with texts
    */
    @FXML
    private void menuPaste() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu Paste functionality", 
        "Not implemented yet. Paste the copied text.");
        dlg.showAndWait();
    }

    /**
    * menuDelete method that invokes InfoDialog with texts
    */
    @FXML
    private void menuDelete() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu Delete functionality", 
        "Not implemented yet. Delete the selected text.");
        dlg.showAndWait();
    }

    /**
    * menuCopy method that invokes InfoDialog with texts
    */
    @FXML
    private void menuSelectAll() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("Menu Select All functionality", 
        "Not implemented yet. Selects all text in area.");
        dlg.showAndWait();
    }

    /**
    * menuAbout method that invokes InfoDialog with about texts
    */
    @FXML
    private void menuAbout() {
        InfoDialog dlg = new InfoDialog();
        dlg.setProperties("About Words Query", "WordsQuery version 0.5");
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
    
    /**
    * This method clears the collected word list
    */
    @FXML
    public void ClearAllResults(MouseEvent event) {
        Results r = new Results(ResultData, ResultTextArea);    
        try {
            r.ClearResults();
        }
        catch (RuntimeException exception) {
        }
        
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
