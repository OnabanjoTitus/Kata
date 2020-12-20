package com.katasWithGrace.numberUtils;

import java.math.BigDecimal;

public interface NumberUtilities {


    String convertAnyNumberToWords(Double number);
    String convertAnyNumberToWords(String number) ;

    String convertAnyNumberToWords(int number);
    String convertAnyNumberToWords(long number);
    String convertAnyNumberToWords(BigDecimal number);


}


