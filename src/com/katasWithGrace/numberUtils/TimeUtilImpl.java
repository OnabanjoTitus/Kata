package com.katasWithGrace.numberUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtilImpl implements TimeUtil{
    static NumberUtilities numberUtilities = new NumberUtilitiesImpl();

    @Override
    public String tellTheTime(String hour, String minute) {
        return tellTheTimeHelper(new Time(hour, minute));
    }

    @Override
    public  String tellTheTime(String time) {
        return tellTheTimeHelper(new Time(time));
    }
    @Override
    public String tellTheTime(int hour, int minute) {
        return tellTheTimeHelper(new Time(hour, minute));
    }
    @Override
    public  String tellTheTime(Time time){
        return tellTheTimeHelper(time);
    }

    @Override
    public String whatIsTheCurrentTime() {
        return tellTheTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
    }
    @Override
    public String greetUser() {
        return "Good " + whatIsTheTimeOfDay(LocalTime.now().format((DateTimeFormatter.ofPattern("HH:mm")))) + " " + whatIsTheNameOfTheOwnerOfThisComputer();
    }

    @Override
    public String tellTheTime(int hour) {
        return tellTheTimeHelper(new Time(hour));
    }

    private static String tellTheTimeHelper(Time time) {
        String stringTime;
        int hour = time.getHour();
        int minute = time.getMinute();
        if(hour >12){
            hour =hour %12;
        }
        if(hour == 0){
            hour =12;
        }

        if(minute >0 && minute < 10){
            stringTime =  "It's "+ convertTimeDigitsToWordHelper(hour) + " O'"+ convertTimeDigitsToWordHelper(minute);
        }
        else {

            stringTime = "It's " + convertTimeDigitsToWordHelper(hour) + " " + convertTimeDigitsToWordHelper(minute);
        }
        return stringTime;
    }

    private static String convertTimeDigitsToWordHelper(int number){
        String word = "O' clock";
        if(number>0 && number <= 10){
            word = numberUtilities.convertAnyNumberToWords(number);
        }
        if(number>10){
            return numberUtilities.convertAnyNumberToWords(number);
        }

        return word;
    }

    private static String whatIsTheTimeOfDayHelper(int hourOfTheDay){
        String result ="";
        boolean isMorning = hourOfTheDay >=0 && hourOfTheDay<12;
        boolean isAfternoon = hourOfTheDay>=12 && hourOfTheDay<18;
        boolean isEvening = !isMorning && !isAfternoon;
        if(isMorning){
            result="Morning";
        }
        if(isAfternoon){
            result="Afternoon";
        }
        if(isEvening) {
            result="Evening";
        }
        return result;
    }

    private static String whatIsTheTImeOfTheDayHelper(Time time) {
        String result;
        int hour = time.getHour();
        int minutes = time.getMinute();
        boolean isNoon = hour == 12 && minutes == 0;
        boolean isMidnight = (hour == 24 || hour ==0) && minutes == 0;
        if(isNoon){
            result="Noon";
        }
        else if(isMidnight){
            result="Mid-Night";
        }

        else result= (whatIsTheTimeOfDayHelper(hour));

        return result;
    }

    private static String whatIsTheNameOfTheOwnerOfThisComputer(){
        return System.getProperty("user.name");
    }

    private static String whatIsTheTimeOfDay(String time){
        return whatIsTheTImeOfTheDayHelper(new Time(time));
    }




}
