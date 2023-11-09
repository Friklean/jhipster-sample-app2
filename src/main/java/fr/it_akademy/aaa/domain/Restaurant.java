package fr.it_akademy.aaa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Restaurant.
 */
@Entity
@Table(name = "restaurant")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "preparation_commande")
    private String preparationCommande;

    @Column(name = "heure_de_preparation")
    private String heureDePreparation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "restaurant" }, allowSetters = true)
    private Set<Livreur> livreurs = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "restaurants")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "restaurants", "client" }, allowSetters = true)
    private Set<Commande> commandes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Restaurant id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreparationCommande() {
        return this.preparationCommande;
    }

    public Restaurant preparationCommande(String preparationCommande) {
        this.setPreparationCommande(preparationCommande);
        return this;
    }

    public void setPreparationCommande(String preparationCommande) {
        this.preparationCommande = preparationCommande;
    }

    public String getHeureDePreparation() {
        return this.heureDePreparation;
    }

    public Restaurant heureDePreparation(String heureDePreparation) {
        this.setHeureDePreparation(heureDePreparation);
        return this;
    }

    public void setHeureDePreparation(String heureDePreparation) {
        this.heureDePreparation = heureDePreparation;
    }

    public Set<Livreur> getLivreurs() {
        return this.livreurs;
    }

    public void setLivreurs(Set<Livreur> livreurs) {
        if (this.livreurs != null) {
            this.livreurs.forEach(i -> i.setRestaurant(null));
        }
        if (livreurs != null) {
            livreurs.forEach(i -> i.setRestaurant(this));
        }
        this.livreurs = livreurs;
    }

    public Restaurant livreurs(Set<Livreur> livreurs) {
        this.setLivreurs(livreurs);
        return this;
    }

    public Restaurant addLivreur(Livreur livreur) {
        this.livreurs.add(livreur);
        livreur.setRestaurant(this);
        return this;
    }

    public Restaurant removeLivreur(Livreur livreur) {
        this.livreurs.remove(livreur);
        livreur.setRestaurant(null);
        return this;
    }

    public Set<Commande> getCommandes() {
        return this.commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        if (this.commandes != null) {
            this.commandes.forEach(i -> i.removeRestaurant(this));
        }
        if (commandes != null) {
            commandes.forEach(i -> i.addRestaurant(this));
        }
        this.commandes = commandes;
    }

    public Restaurant commandes(Set<Commande> commandes) {
        this.setCommandes(commandes);
        return this;
    }

    public Restaurant addCommande(Commande commande) {
        this.commandes.add(commande);
        commande.getRestaurants().add(this);
        return this;
    }

    public Restaurant removeCommande(Commande commande) {
        this.commandes.remove(commande);
        commande.getRestaurants().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Restaurant)) {
            return false;
        }
        return getId() != null && getId().equals(((Restaurant) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Restaurant{" +
            "id=" + getId() +
            ", preparationCommande='" + getPreparationCommande() + "'" +
            ", heureDePreparation='" + getHeureDePreparation() + "'" +
            "}";
    }
}
