package com.transperfect.store.mapper;

import com.transperfect.store.domain.Item;
import com.transperfect.store.dto.ItemDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDTO toDTO(Item source);

    List<ItemDTO> toDTOs(List<Item> sources);
}
