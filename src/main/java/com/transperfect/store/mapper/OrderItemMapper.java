package com.transperfect.store.mapper;

import com.transperfect.store.domain.OrderItem;
import com.transperfect.store.dto.OrderItemDTO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    @Mapping(source = "source.item.price", target = "itemPrice")
    @Mapping(source = "source.item.id", target = "itemId")
    @Mapping(source = "source.order.id", target = "orderId")
    OrderItemDTO toDTO(OrderItem source);

    @InheritConfiguration
    List<OrderItemDTO> toDTOs(List<OrderItem> source);
}
