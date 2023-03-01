package com.transperfect.store.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class OrderDTO {

    private Long id;

    private String reference;

    private Set<OrderItemDTO> items = new HashSet<>();

    @JsonProperty("amount")
    public Double getAmount()
    {
        return this.items.stream().map(OrderItemDTO::getPrice).mapToDouble(s -> s).sum();
    }
}
