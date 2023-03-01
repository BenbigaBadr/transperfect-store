package com.transperfect.store.mapper;

import com.transperfect.store.domain.OrderItem;
import com.transperfect.store.dto.OrderItemDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrderMapper.class, ItemMapper.class})
public interface OrderItemMapper {

    OrderItemDTO toDTO(OrderItem source);

    List<OrderItemDTO> toDTOs(List<OrderItem> source);
}
