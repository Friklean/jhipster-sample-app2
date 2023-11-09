package fr.it_akademy.aaa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Commande.
 */
@Entity
@Table(name = "commande")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "liste_article")
    private String listeArticle;

    @Column(name = "heure_de_commande")
    private String heureDeCommande;

    @Column(name = "paiement")
    private String paiement;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "rel_commande__restaurant",
        joinColumns = @JoinColumn(name = "commande_id"),
        inverseJoinColumns = @JoinColumn(name = "restaurant_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "livreurs", "commandes" }, allowSetters = true)
    private Set<Restaurant> restaurants = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "commandes" }, allowSetters = true)
    private Client client;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Commande id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListeArticle() {
        return this.listeArticle;
    }

    public Commande listeArticle(String listeArticle) {
        this.setListeArticle(listeArticle);
        return this;
    }

    public void setListeArticle(String listeArticle) {
        this.listeArticle = listeArticle;
    }

    public String getHeureDeCommande() {
        return this.heureDeCommande;
    }

    public Commande heureDeCommande(String heureDeCommande) {
        this.setHeureDeCommande(heureDeCommande);
        return this;
    }

    public void setHeureDeCommande(String heureDeCommande) {
        this.heureDeCommande = heureDeCommande;
    }

    public String getPaiement() {
        return this.paiement;
    }

    public Commande paiement(String paiement) {
        this.setPaiement(paiement);
        return this;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    public Set<Restaurant> getRestaurants() {
        return this.restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Commande restaurants(Set<Restaurant> restaurants) {
        this.setRestaurants(restaurants);
        return this;
    }

    public Commande addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
        return this;
    }

    public Commande removeRestaurant(Restaurant restaurant) {
        this.restaurants.remove(restaurant);
        return this;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Commande client(Client client) {
        this.setClient(client);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Commande)) {
            return false;
        }
        return getId() != null && getId().equals(((Commande) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Commande{" +
            "id=" + getId() +
            ", listeArticle='" + getListeArticle() + "'" +
            ", heureDeCommande='" + getHeureDeCommande() + "'" +
            ", paiement='" + getPaiement() + "'" +
            "}";
    }
}
