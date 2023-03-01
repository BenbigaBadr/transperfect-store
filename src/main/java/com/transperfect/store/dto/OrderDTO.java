package com.transperfect.store.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class OrderDTO {

    private Long id;

    private String reference;

    private List<OrderItemDTO> items;

    @JsonProperty("amount")
    public Double getAmount()
    {
        return this.items.stream().map(OrderItemDTO::getPrice).mapToDouble(s -> s).sum();
    }
}
