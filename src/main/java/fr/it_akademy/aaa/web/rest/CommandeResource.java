package fr.it_akademy.aaa.web.rest;

import fr.it_akademy.aaa.repository.CommandeRepository;
import fr.it_akademy.aaa.service.CommandeService;
import fr.it_akademy.aaa.service.dto.CommandeDTO;
import fr.it_akademy.aaa.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link fr.it_akademy.aaa.domain.Commande}.
 */
@RestController
@RequestMapping("/api/commandes")
public class CommandeResource {

    private final Logger log = LoggerFactory.getLogger(CommandeResource.class);

    private static final String ENTITY_NAME = "commande";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CommandeService commandeService;

    private final CommandeRepository commandeRepository;

    public CommandeResource(CommandeService commandeService, CommandeRepository commandeRepository) {
        this.commandeService = commandeService;
        this.commandeRepository = commandeRepository;
    }

    /**
     * {@code POST  /commandes} : Create a new commande.
     *
     * @param commandeDTO the commandeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new commandeDTO, or with status {@code 400 (Bad Request)} if the commande has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<CommandeDTO> createCommande(@RequestBody CommandeDTO commandeDTO) throws URISyntaxException {
        log.debug("REST request to save Commande : {}", commandeDTO);
        if (commandeDTO.getId() != null) {
            throw new BadRequestAlertException("A new commande cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CommandeDTO result = commandeService.save(commandeDTO);
        return ResponseEntity
            .created(new URI("/api/commandes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /commandes/:id} : Updates an existing commande.
     *
     * @param id the id of the commandeDTO to save.
     * @param commandeDTO the commandeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated commandeDTO,
     * or with status {@code 400 (Bad Request)} if the commandeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the commandeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CommandeDTO> updateCommande(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CommandeDTO commandeDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Commande : {}, {}", id, commandeDTO);
        if (commandeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, commandeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!commandeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CommandeDTO result = commandeService.update(commandeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, commandeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /commandes/:id} : Partial updates given fields of an existing commande, field will ignore if it is null
     *
     * @param id the id of the commandeDTO to save.
     * @param commandeDTO the commandeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated commandeDTO,
     * or with status {@code 400 (Bad Request)} if the commandeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the commandeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the commandeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<CommandeDTO> partialUpdateCommande(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody CommandeDTO commandeDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Commande partially : {}, {}", id, commandeDTO);
        if (commandeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, commandeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!commandeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CommandeDTO> result = commandeService.partialUpdate(commandeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, commandeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /commandes} : get all the commandes.
     *
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of commandes in body.
     */
    @GetMapping("")
    public List<CommandeDTO> getAllCommandes(@RequestParam(required = false, defaultValue = "true") boolean eagerload) {
        log.debug("REST request to get all Commandes");
        return commandeService.findAll();
    }

    /**
     * {@code GET  /commandes/:id} : get the "id" commande.
     *
     * @param id the id of the commandeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the commandeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CommandeDTO> getCommande(@PathVariable Long id) {
        log.debug("REST request to get Commande : {}", id);
        Optional<CommandeDTO> commandeDTO = commandeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(commandeDTO);
    }

    /**
     * {@code DELETE  /commandes/:id} : delete the "id" commande.
     *
     * @param id the id of the commandeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        log.debug("REST request to delete Commande : {}", id);
        commandeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}