package com.gates.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityDTOMapper {

	EntityDTOMapper MAPPER = Mappers.getMapper(EntityDTOMapper.class);

}
