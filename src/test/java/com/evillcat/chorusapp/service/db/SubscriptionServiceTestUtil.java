package com.evillcat.chorusapp.service.db;

import com.evillcat.chorusapp.model.Member;

public final class SubscriptionServiceTestUtil {
    private SubscriptionServiceTestUtil(){}

    public static final Member SUB_MEMBER =
        Member.builder().nameAndSurname("Виноградов Алексей").phoneNumber("+79998432341").build();

}
