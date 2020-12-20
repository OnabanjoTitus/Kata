package com.katasWithGrace.numberUtils;

import java.math.BigDecimal;

public interface NumberUtilities {
    String tellTheTime(String hour, String minute);
    String tellTheTime(String time);
    String tellTheTime(int hour, int minute);
    String whatIsTheCurrentTime();
    String greetUser();

    String tellTheTime(Time time);

    String convertNumberToWord(String userInput);

    String convertAnyNumberToWords(Double number);
    String convertAnyNumberToWords(String number) ;

    String convertAnyNumberToWords(int number);
    String convertAnyNumberToWords(long number);
    String convertAnyNumberToWords(BigDecimal number);

}
