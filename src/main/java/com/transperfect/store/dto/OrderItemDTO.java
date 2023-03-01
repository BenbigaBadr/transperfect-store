package com.transperfect.store.dto;

import lombok.Data;

@Data
public class OrderItemDTO {

    private ItemDTO item;

    private OrderDTO order;

    private long quantity;

    public double getPrice()
    {
        return item.getPrice() * quantity;
    }
}
