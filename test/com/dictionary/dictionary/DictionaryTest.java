package com.dictionary.dictionary;

import java.io.IOException;

class DictionaryTest {
   //Dictionary dictionary;

   public static void main(String[] args) throws IOException {
      Dictionary dictionary = new WebsterDictionary();
      System.out.println(dictionary.searchWord("sheriff"));
      //System.out.println(dictionary.checkIfWordExist("seyi"));
   }
//    @BeforeEach
//    void setUp() {
//        dictionary = new WebsterDictionary();
//
//    }
//
//    @Test
//    void loadDictionary() {
//        assertNotNull(dictionary);
//
//    }
//
//    @Test
//    void searchWord() {
//    }
//
//    @Test
//    void addWords() {
//    }
//
//    @Test
//    void logMissingWords() {
//    }
}