package com.practiceWithGrace;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilitiesTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void numberUtilitiesCanTellTheTimeInHoursTest(){
       String result = NumberUtilities.tellTheTime("10:00");
        System.out.println(result);
       assertEquals("It's Ten O' clock", result);

    }

    @Test
    void numberUtilitiesCanTellTheTimeInMinutesTest(){
       String result = NumberUtilities.tellTheTime("10:12");
        System.out.println(result);
       assertEquals("It's Ten Twelve", result);


        result = NumberUtilities.tellTheTime("10:19");
        System.out.println(result);
        assertEquals("It's Ten Nineteen", result);


        result = NumberUtilities.tellTheTime("12:19");
        System.out.println(result);
        assertEquals("It's Twelve Nineteen", result);


    }



    @Test
    void numberUtilitiesCanTellTheTImeCorrectlyTest(){
        String result = NumberUtilities.tellTheTime("10:35");
        System.out.println(result);
        assertEquals("It's Ten Thirty-Five", result);


        result = NumberUtilities.tellTheTime("11:54");
        System.out.println(result);

result = NumberUtilities.tellTheTime("12:56");
        System.out.println(result);
result = NumberUtilities.tellTheTime("23:35");
        System.out.println(result);
result = NumberUtilities.tellTheTime("16:23");
        System.out.println(result);
result = NumberUtilities.tellTheTime("04:13");
        System.out.println(result);

        result = NumberUtilities.tellTheTime("00:13");
        System.out.println(result);


    }


    @Test
    void numberUtilitiesCanTellTheTImeIfItIsTwentyFourHourTest() {
        String result = NumberUtilities.tellTheTime("13:35");
        System.out.println(result);
        assertEquals("It's One Thirty-Five", result);

        result = NumberUtilities.tellTheTime("24:35");
        System.out.println(result);
        assertEquals("It's Twelve Thirty-Five", result);

    }



    @Test
    void numberUtilitiesCanTellTheTImeIfItIsZeroHours() {
        String result = NumberUtilities.tellTheTime("0:35");
        System.out.println(result);
        assertEquals("It's Twelve Thirty-Five", result);

        result = NumberUtilities.tellTheTime("24:35");
        System.out.println(result);
        assertEquals("It's Twelve Thirty-Five", result);

    }

    @Test
    void numberUtilitiesWillNotTellTheTimeIfTheHourExceedsTwentyFour() {
        String result = NumberUtilities.tellTheTime("35:35");
        System.out.println(result);
        assertEquals("Hour cannot exceed 24 hours", result);

    }
    @Test
    void numberUtilitiesWillNotTellTheTimeIfTheMinutesExceedsSixty() {
        String result = NumberUtilities.tellTheTime("24:65");
        System.out.println(result);
        assertEquals("Minutes cannot exceed sixty", result);

    }


    @Test
    void numberUtilitiesGraceTest() {
        String result = NumberUtilities.tellTheTime("0:00");
        System.out.println(result);
        assertEquals("It's Twelve O' clock", result);

    }

    @Test
    void numberUtilitiesCanTellTimeCorrectlyWhenMinuteIslessThanTenTest() {
        String result = NumberUtilities.tellTheTime("0:05");
        System.out.println(result);
        assertEquals("It's Twelve O'Five", result);
        System.out.println(NumberUtilities.whatIsTheTime());

    }

    @Test
    void numberUtilitiesCanTellUnitCorrectly(){
        String result = NumberUtilities.convertNumberToWord("3");
        System.out.println(result);
        assertEquals("Three", result);


        result = NumberUtilities.convertNumberToWord("8");
        System.out.println(result);
        assertEquals("Eight", result);

        result = NumberUtilities.convertNumberToWord("0");
        System.out.println(result);
        assertEquals("Zero", result);
    }


    @Test
    void numberUtilitiesCanTellTensCorrectly(){
        String result = NumberUtilities.convertNumberToWord("12");
        System.out.println(result);
        assertEquals("Twelve", result);


        result = NumberUtilities.convertNumberToWord("18");
        System.out.println(result);
        assertEquals("Eighteen", result);

        result = NumberUtilities.convertNumberToWord("10");
        System.out.println(result);
        assertEquals("Ten", result);
    }

    @Test
    void numberUtilitiesCanTellHigherTensCorrectly(){
        String result = NumberUtilities.convertNumberToWord("35");
        System.out.println(result);
        assertEquals("Thirty-Five", result);


        result = NumberUtilities.convertNumberToWord("42");
        System.out.println(result);
        assertEquals("Forty-Two", result);

        result = NumberUtilities.convertNumberToWord("85");
        System.out.println(result);
        assertEquals("Eighty-Five", result);


        result = NumberUtilities.convertNumberToWord("20");
        System.out.println(result);
        assertEquals("Twenty", result);


        result = NumberUtilities.convertNumberToWord("40");
        System.out.println(result);
        assertEquals("Forty", result);

        System.out.println(NumberUtilities.whatIsTheTime());
    }

    @Test
    void numberUtilitiesCanTellHundredCorrectly(){
        String result = NumberUtilities.convertNumberToWord("125");
        System.out.println(result);
        assertEquals("One Hundred and Twenty Five", result);


        result = NumberUtilities.convertNumberToWord("530");
        System.out.println(result);
        assertEquals("Five Hundred and Thirty", result);

        result = NumberUtilities.convertNumberToWord("685");
        System.out.println(result);
        assertEquals("Six Hundred and Eighty-Five", result);


        result = NumberUtilities.convertNumberToWord("956");
        System.out.println(result);
        assertEquals("Nine Hundred and Fifty-Six", result);


        result = NumberUtilities.convertNumberToWord("40");
        System.out.println(result);
        assertEquals("Forty", result);



    }







}