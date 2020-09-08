package com.katasWithGrace;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberBaseConverterTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void binaryToBaseTenConversionTest(){
        int result = NumberBaseConverter.convertBinaryToBaseTen("110");
        assertEquals(6, result);

        result = NumberBaseConverter.convertBinaryToBaseTen("0110");
        assertEquals(6, result);

        result = NumberBaseConverter.convertBinaryToBaseTen("1111");
        assertEquals(15, result);

        result = NumberBaseConverter.convertBinaryToBaseTen("100000");
        assertEquals(32, result);
    }
}