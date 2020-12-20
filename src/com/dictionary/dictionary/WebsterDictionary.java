package com.dictionary.dictionary;

import java.io.IOException;
import java.util.List;

public class WebsterDictionary extends Dictionary {
    public WebsterDictionary() throws IOException {
        super("/home/chibuzo/IdeaProjects/Implementations/src/com/dictionary/dependencies/webster.json");
    }

    @Override
    public String searchWord(String word) {
        if (checkIfWordExist(word.toLowerCase())) {
            return displaySearchResults(dictionaryFiles.get(word.toLowerCase()).toString());
            //return dictionaryFiles.get(word.toLowerCase());
        } else {
            return "Word not in database";
        }

    }

    @Override
    protected String displaySearchResults(List<String> strings) {
        return null;
    }

    @Override
    public String displaySearchResults(String results) {
        String[] nounAndVerb = results.split("[\\r?\\n]{1,2}"); //split by new line to separate nouns and verbs
        String[] noun = nounAndVerb[0].split("[0-9]+.\\s+");

        StringBuilder result = new StringBuilder();
        int counter = 1;
        result.append("<html><head><title>Dictionary Meaning</title></head><body>");
        result.append("<b>Noun</b>");
        for (String lines : noun) {
            result.append("<p style='width: 1000px;'>");
            result.append(counter).append(". ").append(lines);
            result.append("</p><br>");
            counter++;
        }
        result.append("<br>");
        counter = 1;
        if (nounAndVerb.length >= 2) {
            result.append("Verb");
            String[] verb = nounAndVerb[1].split("[0-9]+.");
            for (String lines : verb) {
                result.append("<p style='width: 1000px;'>");
                result.append(counter).append(". ").append(lines);
                result.append("</p><br>");
                counter++;
            }
        }
        result.append("</body></html>");


        return result.toString();

    }


}
