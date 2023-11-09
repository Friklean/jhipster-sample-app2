package fr.it_akademy.aaa.service.impl;

import fr.it_akademy.aaa.domain.Livreur;
import fr.it_akademy.aaa.repository.LivreurRepository;
import fr.it_akademy.aaa.service.LivreurService;
import fr.it_akademy.aaa.service.dto.LivreurDTO;
import fr.it_akademy.aaa.service.mapper.LivreurMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link fr.it_akademy.aaa.domain.Livreur}.
 */
@Service
@Transactional
public class LivreurServiceImpl implements LivreurService {

    private final Logger log = LoggerFactory.getLogger(LivreurServiceImpl.class);

    private final LivreurRepository livreurRepository;

    private final LivreurMapper livreurMapper;

    public LivreurServiceImpl(LivreurRepository livreurRepository, LivreurMapper livreurMapper) {
        this.livreurRepository = livreurRepository;
        this.livreurMapper = livreurMapper;
    }

    @Override
    public LivreurDTO save(LivreurDTO livreurDTO) {
        log.debug("Request to save Livreur : {}", livreurDTO);
        Livreur livreur = livreurMapper.toEntity(livreurDTO);
        livreur = livreurRepository.save(livreur);
        return livreurMapper.toDto(livreur);
    }

    @Override
    public LivreurDTO update(LivreurDTO livreurDTO) {
        log.debug("Request to update Livreur : {}", livreurDTO);
        Livreur livreur = livreurMapper.toEntity(livreurDTO);
        livreur = livreurRepository.save(livreur);
        return livreurMapper.toDto(livreur);
    }

    @Override
    public Optional<LivreurDTO> partialUpdate(LivreurDTO livreurDTO) {
        log.debug("Request to partially update Livreur : {}", livreurDTO);

        return livreurRepository
            .findById(livreurDTO.getId())
            .map(existingLivreur -> {
                livreurMapper.partialUpdate(existingLivreur, livreurDTO);

                return existingLivreur;
            })
            .map(livreurRepository::save)
            .map(livreurMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LivreurDTO> findAll() {
        log.debug("Request to get all Livreurs");
        return livreurRepository.findAll().stream().map(livreurMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LivreurDTO> findOne(Long id) {
        log.debug("Request to get Livreur : {}", id);
        return livreurRepository.findById(id).map(livreurMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Livreur : {}", id);
        livreurRepository.deleteById(id);
    }
}
