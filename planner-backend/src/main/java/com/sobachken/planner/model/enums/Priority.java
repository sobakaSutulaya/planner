package com.sobachken.planner.model.enums;

public enum Priority {
    NONE(0),
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int priority;

    Priority (int priority) {
        this.priority = priority;
    }
}
