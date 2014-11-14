/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsquery;

import com.gtranslate.Language; 
import com.gtranslate.Translator;

/**
 *
 * @author saaritim
 */
public class Translation {
        
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
         String translatedText = translator.translate(Word,
                    ConvertToPrefix(FromLanguage), 
                    ConvertToPrefix(ToLanguage)); 
        return translatedText; 
    } 
}
