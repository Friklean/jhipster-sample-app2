package fr.it_akademy.aaa.repository;

import fr.it_akademy.aaa.domain.Commande;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/**
 * Utility repository to load bag relationships based on https://vladmihalcea.com/hibernate-multiplebagfetchexception/
 */
public class CommandeRepositoryWithBagRelationshipsImpl implements CommandeRepositoryWithBagRelationships {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Commande> fetchBagRelationships(Optional<Commande> commande) {
        return commande.map(this::fetchRestaurants);
    }

    @Override
    public Page<Commande> fetchBagRelationships(Page<Commande> commandes) {
        return new PageImpl<>(fetchBagRelationships(commandes.getContent()), commandes.getPageable(), commandes.getTotalElements());
    }

    @Override
    public List<Commande> fetchBagRelationships(List<Commande> commandes) {
        return Optional.of(commandes).map(this::fetchRestaurants).orElse(Collections.emptyList());
    }

    Commande fetchRestaurants(Commande result) {
        return entityManager
            .createQuery(
                "select commande from Commande commande left join fetch commande.restaurants where commande.id = :id",
                Commande.class
            )
            .setParameter("id", result.getId())
            .getSingleResult();
    }

    List<Commande> fetchRestaurants(List<Commande> commandes) {
        HashMap<Object, Integer> order = new HashMap<>();
        IntStream.range(0, commandes.size()).forEach(index -> order.put(commandes.get(index).getId(), index));
        List<Commande> result = entityManager
            .createQuery(
                "select commande from Commande commande left join fetch commande.restaurants where commande in :commandes",
                Commande.class
            )
            .setParameter("commandes", commandes)
            .getResultList();
        Collections.sort(result, (o1, o2) -> Integer.compare(order.get(o1.getId()), order.get(o2.getId())));
        return result;
    }
}
