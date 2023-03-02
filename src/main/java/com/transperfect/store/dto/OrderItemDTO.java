package com.transperfect.store.dto;

import lombok.Data;

@Data
public class OrderItemDTO {

    private Long itemId;

    private double itemPrice;

    private long quantity;

    public double getPrice()
    {
        return itemPrice * quantity;
    }
}
