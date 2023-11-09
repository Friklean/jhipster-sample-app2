package fr.it_akademy.aaa.service.mapper;

import fr.it_akademy.aaa.domain.Restaurant;
import fr.it_akademy.aaa.service.dto.RestaurantDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Restaurant} and its DTO {@link RestaurantDTO}.
 */
@Mapper(componentModel = "spring")
public interface RestaurantMapper extends EntityMapper<RestaurantDTO, Restaurant> {}
