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

import com.gtranslate.Language;
import com.gtranslate.Translator;
/**
 *
 * @author saaritim
 */
public class Translation{
    
    String ConvertToPrefix(String Lang)
    {
       switch (Lang)
       {    
           case "Finnish":
           return Language.FINNISH;
           case "English":
           return Language.ENGLISH;
           case "Swedish":
           return Language.SWEDISH;
           default:
           return Language.ENGLISH;
       }    
  
    }        
    
     public String Translate(String FromLanguage, String ToLanguage, String Word){
        Translator translator = Translator.getInstance();
        String translatedText = translator.translate(
                    Word,
                    ConvertToPrefix(FromLanguage),
                    ConvertToPrefix(ToLanguage));
        return translatedText;
    }
}
