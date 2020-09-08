package com.dictionary.dictionary;

public interface DictionaryInterface {

    void loadDictionary(String filePath);

     String searchWord(String word);
    boolean checkIfWordExist(String word);
    void suggestWords(String word);

    void addWords(String word);

    void logMissingWords(String word);

    String displaySearchResults(String results);
}
