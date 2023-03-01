package com.transperfect.store.mapper;


import com.transperfect.store.domain.Order;
import com.transperfect.store.dto.OrderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface OrderMapper {

    OrderDTO toDTO(Order source);
}
