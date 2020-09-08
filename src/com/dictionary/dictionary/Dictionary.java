package com.dictionary.dictionary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public abstract class Dictionary implements DictionaryInterface {
    HashMap<String, ?> dictionaryFiles;
    Set<String> wordList;
    ObjectMapper jsonMapper = new ObjectMapper();

    public Dictionary() {

    }

    public Dictionary(String dictionaryFilePath) throws IOException {

        try {
            dictionaryFiles = jsonMapper.readValue((new File(dictionaryFilePath)), new TypeReference<>() {
            });
            wordList = dictionaryFiles.keySet();
        } catch (IOException e) {
            HashMap<String, String> dictionaryFiles;
            dictionaryFiles = jsonMapper.readValue((new File(dictionaryFilePath)), HashMap.class);
            wordList = dictionaryFiles.keySet();
            // Logger.getLogger()
            e.printStackTrace();
        }
//

    }

    public void loadDictionary(String filePath) {
        try {
            dictionaryFiles = jsonMapper.readValue(new File(filePath), new TypeReference<>() {
            });
            wordList = dictionaryFiles.keySet();
        } catch (IOException e) {
            // Logger.getLogger()
            e.printStackTrace();
        }

    }

    public String searchWord(String word) {
        if (checkIfWordExist(word.toLowerCase())) {
            return displaySearchResults((List<String>) dictionaryFiles.get(word.toLowerCase()));
            //return dictionaryFiles.get(word.toLowerCase());
        } else {
            return "Word not in database";
        }
    }

    protected abstract String displaySearchResults(List<String> strings);

    public boolean checkIfWordExist(String word) {
        return dictionaryFiles.containsKey(word);

    }

    public void suggestWords(String word) {

    }

    public void addWords(String word) {

    }

    public void logMissingWords(String word) {

    }

    public abstract String displaySearchResults(String results);

}
