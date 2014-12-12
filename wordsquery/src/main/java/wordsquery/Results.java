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

import java.awt.Font;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;

/**
 * Results Class is responsible of handling list or words that are added in
 * ResultData.
 * 
 */
public class Results{
   
     ObservableList ResultData;
     int ResultIndex;
     ListView ResultTextArea;
     private boolean ListCleared;
     
     Results(ObservableList Results,ListView List)
     {
        ResultIndex=0;
        ResultData = Results;
        ResultTextArea = List;
     }
     public void SaveResult(String QueryWord, String AnswerWord, boolean Result){ 
        
         /* If result list has just been cleared, remove the comment set with
            ClearResults from first index. Also ResultData.clear(); could be used
            but removing first index is sufficient */
         if ( getClearedValue() ) {
             ResultData.remove(0);
             setClearedValue(false);
         }
         String s=QueryWord+" -> "+AnswerWord+"\n";
         final Text t = TextBuilder.create()
            .text(s)
            .x(50).y(50)
            .build(); 
         if(Result)
         {           
             t.setFill(Color.GREEN);
         }
         else
         {
             t.setFill(Color.RED);
         }    
         ResultData.add(t);
         ResultTextArea.setItems(ResultData);
     }
     public void ClearResults() {
     
         ResultData.clear();
         String s=" You emptied the query results.. ";
         ResultData.add(s);
         ResultTextArea.setItems(ResultData);
         setClearedValue(true);
     }
     
     public void setClearedValue(Boolean b) {  
      this.ListCleared = b;  
     } 
     public Boolean getClearedValue(){
     return this.ListCleared;
     }
     public boolean CheckResult(String TranslatedWord, String FromWord, String ToWord){
         if(TranslatedWord.equals(ToWord))
             if(FromWord.equals(ToWord))
                 return false;  /* Word not found from dictionary so both word equals */
             else
                 return true;
         else
             return false;
        
     }
}
