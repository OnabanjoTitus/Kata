package com.creditCardVerification;

import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Hello, Kindly Enter Card details to verify");
        System.out.println(CreditCardFactory.createCreditCard(userInput.nextLine()));




    }
}
