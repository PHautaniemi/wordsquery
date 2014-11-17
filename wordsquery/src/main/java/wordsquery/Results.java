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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
/**
 *
 * @author saaritim
 */
public class Results{
   
     ObservableList ResultData;
     int ResultIndex;
     ListView ResultTextArea;
     
     Results(ObservableList Results,ListView List)
     {
        ResultData=Results;
        ResultTextArea=List;  
     }
     public void SaveResult(String QueryWord, String AnswerWord, boolean Result){ 
        
        
        if(Result)
        {
            String s=QueryWord+" -> "+AnswerWord+"\n";
            final Text t = TextBuilder.create()
            .text(s)
            .x(50).y(50)
            .fill(Color.GREEN)
            .build(); 
           
           ResultData.add(t);
           ResultTextArea.setItems(ResultData);

        }
        else
        {
           String s=QueryWord+" -> "+AnswerWord+"\n";
            final Text t = TextBuilder.create()
            .text(s)
            .x(50).y(50)
            .fill(Color.RED)
            .build(); 
            ResultData.add(t);
            ResultTextArea.setItems(ResultData);
        
        }    
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
