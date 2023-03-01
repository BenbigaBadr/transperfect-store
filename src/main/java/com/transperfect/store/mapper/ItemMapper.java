package com.transperfect.store.mapper;

import com.transperfect.store.domain.Item;
import com.transperfect.store.dto.ItemDTO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(target = "items", ignore = true)
    ItemDTO toDTO(Item source);

    @InheritConfiguration
    List<ItemDTO> toDTOs(List<Item> sources);
}
