package fr.it_akademy.aaa.service;

import fr.it_akademy.aaa.service.dto.LivreurDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link fr.it_akademy.aaa.domain.Livreur}.
 */
public interface LivreurService {
    /**
     * Save a livreur.
     *
     * @param livreurDTO the entity to save.
     * @return the persisted entity.
     */
    LivreurDTO save(LivreurDTO livreurDTO);

    /**
     * Updates a livreur.
     *
     * @param livreurDTO the entity to update.
     * @return the persisted entity.
     */
    LivreurDTO update(LivreurDTO livreurDTO);

    /**
     * Partially updates a livreur.
     *
     * @param livreurDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<LivreurDTO> partialUpdate(LivreurDTO livreurDTO);

    /**
     * Get all the livreurs.
     *
     * @return the list of entities.
     */
    List<LivreurDTO> findAll();

    /**
     * Get the "id" livreur.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<LivreurDTO> findOne(Long id);

    /**
     * Delete the "id" livreur.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
