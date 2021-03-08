package com.sobachken.planner.model.enums;

public enum DayEnum {
    MONDAY("Monday", 1),
    TUESDAY("Tuesday", 2),
    WEDNESDAY("Wednesday", 3),
    THURSDAY("Thursday", 4),
    FRIDAY("Friday", 5),
    SATURDAY("Saturday", 6),
    SUNDAY("Sunday", 7);

    private final String name;
    private final int priority;

    DayEnum(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}
