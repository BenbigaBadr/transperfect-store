package com.transperfect.store.consts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiPath {

    public static final String ORDERS = "/orders";
    public static final String ORDER_STATUS = "/{orderId}/status";
}
