package com.myproject.idstudio.models.enums;

public enum SubscriptionType {
    BASIC,
    STANDARD,
    PREMIUM;

    public static boolean contains(String test) {
        for (SubscriptionType c: SubscriptionType.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        } return false;
    }
}


