package fr.it_akademy.aaa.service;

import fr.it_akademy.aaa.service.dto.CommandeDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link fr.it_akademy.aaa.domain.Commande}.
 */
public interface CommandeService {
    /**
     * Save a commande.
     *
     * @param commandeDTO the entity to save.
     * @return the persisted entity.
     */
    CommandeDTO save(CommandeDTO commandeDTO);

    /**
     * Updates a commande.
     *
     * @param commandeDTO the entity to update.
     * @return the persisted entity.
     */
    CommandeDTO update(CommandeDTO commandeDTO);

    /**
     * Partially updates a commande.
     *
     * @param commandeDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CommandeDTO> partialUpdate(CommandeDTO commandeDTO);

    /**
     * Get all the commandes.
     *
     * @return the list of entities.
     */
    List<CommandeDTO> findAll();

    /**
     * Get all the commandes with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CommandeDTO> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" commande.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CommandeDTO> findOne(Long id);

    /**
     * Delete the "id" commande.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
