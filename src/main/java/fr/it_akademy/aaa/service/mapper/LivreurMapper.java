package fr.it_akademy.aaa.service.mapper;

import fr.it_akademy.aaa.domain.Livreur;
import fr.it_akademy.aaa.domain.Restaurant;
import fr.it_akademy.aaa.service.dto.LivreurDTO;
import fr.it_akademy.aaa.service.dto.RestaurantDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Livreur} and its DTO {@link LivreurDTO}.
 */
@Mapper(componentModel = "spring")
public interface LivreurMapper extends EntityMapper<LivreurDTO, Livreur> {
    @Mapping(target = "restaurant", source = "restaurant", qualifiedByName = "restaurantId")
    LivreurDTO toDto(Livreur s);

    @Named("restaurantId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RestaurantDTO toDtoRestaurantId(Restaurant restaurant);
}
