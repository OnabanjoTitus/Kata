package com.katasWithGrace.numberUtils;

public interface TimeUtil {
    String tellTheTime(String hour, String minute);
    String tellTheTime(String time);
    String tellTheTime(int hour, int minute);
    String whatIsTheCurrentTime();
    String greetUser();

    String tellTheTime(Time time);
    String tellTheTime(int hour);

}
