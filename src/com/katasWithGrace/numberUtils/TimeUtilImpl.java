package com.katasWithGrace.numberUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtilImpl implements TimeUtil{
    static NumberUtilities numberUtilities = new NumberUtilitiesImpl();

    @Override
    public String tellTheTime(String hour, String minute) {
        return convertTimeToWordsHelper(new Time(hour, minute));
    }

    @Override
    public  String tellTheTime(String time) {
        time= time.replaceAll(",",":");
        return convertTimeToWordsHelper(new Time(time));
    }
    @Override
    public String tellTheTime(int hour, int minute) {
        return convertTimeToWordsHelper(new Time(hour, minute));
    }
    @Override
    public  String tellTheTime(Time time){
        return convertTimeToWordsHelper(time);
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
        return convertTimeToWordsHelper(new Time(hour));
    }

    private static String convertTimeToWordsHelper(Time time) {
        String timeInWords;
        int hour = time.getHour();
        int minute = time.getMinute();
        boolean hourIsGreaterThanTwelve = hour>12;
        if(hourIsGreaterThanTwelve){
            hour =hour %12;
        }
        if(hour == 0){
            hour =12;
        }
        boolean minutesIsLessThanTen = minute >0 && minute < 10;
        if(minutesIsLessThanTen){
            timeInWords =  ("It's "+ getWordFrom(hour)).replace(".","") + " O'"+ getWordFrom(minute);
        }
        else {
            timeInWords = ("It's " + getWordFrom(hour)).replace(".", "") + " " + getWordFrom(minute);
        }
        return timeInWords;
    }

    private static String getWordFrom(int digit){
        boolean digitsIsBetweenZeroAndFiftyNine = digit>0 && digit <=59;
        if(digitsIsBetweenZeroAndFiftyNine) return numberUtilities.convertAnyNumberToWords(digit);

        else if(digit==0) return "O' clock.";

        else return "Invalid digits";
    }


    private  String tellMeTheTimeOfTheDayFrom(Time time) {
        String timeOfTheDay;
        int hour = time.getHour();
        timeOfTheDay = isItMidnightOrNoon(time);

        if(timeOfTheDay.equals("It is neither")) timeOfTheDay= (isItMorningAfternoonOrEvening(hour));

        return timeOfTheDay;
    }

    private String isItMidnightOrNoon(Time time){
        String timeOfTheDay;
        int hour = time.getHour();
        int minutes = time.getMinute();
        boolean isNoon = hour == 12 && minutes == 0;
        boolean isMidnight = (hour == 24 || hour ==0) && minutes == 0;
        if(isNoon) timeOfTheDay="Noon";
        else if(isMidnight) timeOfTheDay="Mid-Night";
        else timeOfTheDay = "It is neither";
        return timeOfTheDay;
    }


    private  String isItMorningAfternoonOrEvening(int hourOfTheDay){
        String timeOfTheDay ="";
        boolean isMorning = hourOfTheDay >=0 && hourOfTheDay<12;
        boolean isAfternoon = hourOfTheDay>=12 && hourOfTheDay<18;
        boolean isEvening = !isMorning && !isAfternoon;
        if(isMorning) timeOfTheDay="Morning";

        if(isAfternoon) timeOfTheDay="Afternoon";

        if(isEvening) timeOfTheDay="Evening";

        return timeOfTheDay;
    }

    private  String whatIsTheNameOfTheOwnerOfThisComputer(){
        String userName = System.getProperty("user.name");
       userName = userName.replace(userName.charAt(0), Character.toUpperCase(userName.charAt(0)));
        return userName;
    }

    private String whatIsTheTimeOfDay(String time){
        return tellMeTheTimeOfTheDayFrom(new Time(time));
    }




}
