package com.dictionary.dictionary;

import java.io.IOException;
import java.util.List;

public class QuickDictionary extends Dictionary{
    public QuickDictionary() throws IOException {
        super("src/com/eagles/dependencies/data.json");
    }



    @Override
    public String displaySearchResults(String results) {
        return null;
    }

    public String displaySearchResults(List<String> results){
        StringBuilder processedResult;
        StringBuilder dismantledList = new StringBuilder();
        for (String result : results) {
            dismantledList.append(result);
        }
        String[] nounAndVerb = (dismantledList.toString()).split("[\\r?\\n]{1,2}");
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
