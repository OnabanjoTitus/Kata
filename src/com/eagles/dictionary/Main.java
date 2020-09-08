package com.eagles.dictionary;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary webster = new WebsterDictionary();
        Dictionary quickDictionary = new QuickDictionary();
        String userWord;


        do {
            userWord = JOptionPane.showInputDialog("Search A Word");
          //  JOptionPane.showConfirmDialog()
            JOptionPane.showMessageDialog(
                    null, (quickDictionary.searchWord(userWord)));
            JOptionPane.showMessageDialog(
                    null, (webster.searchWord(userWord)));
        }
        while (true);


    }
}
