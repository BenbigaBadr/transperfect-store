package com.transperfect.store.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transperfect.store.type.OrderStatus;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private Long id;

    private OrderStatus status;

    private String reference;

    @JsonProperty("shoppingCart")
    private List<OrderItemDTO> items;

    @JsonProperty("amount")
    public Double getAmount()
    {
        return this.items.stream().map(OrderItemDTO::getPrice).mapToDouble(s -> s).sum();
    }
}
