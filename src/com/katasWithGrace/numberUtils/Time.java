package com.katasWithGrace.numberUtils;

public class Time {
    private int hour;
    private int minute;

//    public Time(){
//        this(0,0);
//    }
    public Time(int hour, int minute){
        if (isValidInput(hour, minute)){
        this.hour = hour;
        this.minute = minute;}
        else{
         throw new InvalidTimeException("Time Entered is invalid");
        }
    }

    public Time(int hour){
        this(hour, 0);

    }

    private static boolean isValidInput(int hour, int minutes){
        boolean isValidInput = true;
        if (hour>24)
        {
            isValidInput= false;
        }
        else if(minutes>60){isValidInput= false;}
        return isValidInput;

    }


    public Time(String time){

        String[] timeArray = time.split(":");
        if (timeArray.length < 2) {
            timeArray = time.split("\\.");
        }
        if (timeArray.length < 2) {
            timeArray = time.split(" ");
        }
        if (timeArray.length < 2) {
            timeArray = new String[2];
            timeArray[0]= time;
            timeArray[1] = "0";

        }
        int hour;
        int minute;
        try {
            hour = Integer.parseInt(timeArray[0]);
            minute = Integer.parseInt(timeArray[1]);
        }
        catch (NumberFormatException numberFormatException){
            throw new InvalidTimeException("Time Entered is invalid");
        }
        if (isValidInput(hour, minute)) {
            this.hour = hour;
            this.minute = minute;
        }
        else{
                throw new InvalidTimeException("Time Entered is invalid");
            }
        }



    public Time(String hour, String minute){
        this(Integer.parseInt(hour),Integer.parseInt(minute));
    }

//    public Time(int... time) {
//        this(time[0], time[1]);
//    }
//    public Time(String... time){
//        this(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
//    }
//

    public int getHour() {
        return hour;
    }

//    public void setHour(int hour) {
//        this.hour = hour;
//    }

    public int getMinute() {
        return minute;
    }

//    public void setMinute(int minute) {
//        this.minute = minute;
//    }

    static class InvalidTimeException extends RuntimeException{

        public InvalidTimeException(String message) {
            super(message);
        }
    }


}
