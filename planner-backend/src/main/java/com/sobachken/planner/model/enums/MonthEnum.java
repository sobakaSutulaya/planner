package com.sobachken.planner.model.enums;

public enum MonthEnum {
    JANUARY("January", 31, 1),
    FEBRUARY("February", 28, 2),//i dont even want to think about leap years
    MARCH("March", 31, 3),
    APRIL("April", 30, 4),
    MAY("May", 31, 5),
    JUNE("June", 30, 6),
    JULY("July", 31, 7),
    AUGUST("August",31, 8),
    SEPTEMBER("September",30, 9),
    OCTOBER("October", 31, 10),
    NOVEMBER("November",30,  11),
    DECEMBER("December", 31, 12);

    private final String name;
    private final int days;
    private final int priority;

    MonthEnum(String name, int days, int priority) {
        this.name = name;
        this.days = days;
        this.priority = priority;
    }
}
