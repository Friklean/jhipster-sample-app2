package fr.it_akademy.aaa.service;

import fr.it_akademy.aaa.service.dto.RestaurantDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link fr.it_akademy.aaa.domain.Restaurant}.
 */
public interface RestaurantService {
    /**
     * Save a restaurant.
     *
     * @param restaurantDTO the entity to save.
     * @return the persisted entity.
     */
    RestaurantDTO save(RestaurantDTO restaurantDTO);

    /**
     * Updates a restaurant.
     *
     * @param restaurantDTO the entity to update.
     * @return the persisted entity.
     */
    RestaurantDTO update(RestaurantDTO restaurantDTO);

    /**
     * Partially updates a restaurant.
     *
     * @param restaurantDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<RestaurantDTO> partialUpdate(RestaurantDTO restaurantDTO);

    /**
     * Get all the restaurants.
     *
     * @return the list of entities.
     */
    List<RestaurantDTO> findAll();

    /**
     * Get the "id" restaurant.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RestaurantDTO> findOne(Long id);

    /**
     * Delete the "id" restaurant.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
