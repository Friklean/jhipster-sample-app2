package fr.it_akademy.aaa.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link fr.it_akademy.aaa.domain.Commande} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CommandeDTO implements Serializable {

    private Long id;

    private String listeArticle;

    private String heureDeCommande;

    private String paiement;

    private Set<RestaurantDTO> restaurants = new HashSet<>();

    private ClientDTO client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListeArticle() {
        return listeArticle;
    }

    public void setListeArticle(String listeArticle) {
        this.listeArticle = listeArticle;
    }

    public String getHeureDeCommande() {
        return heureDeCommande;
    }

    public void setHeureDeCommande(String heureDeCommande) {
        this.heureDeCommande = heureDeCommande;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    public Set<RestaurantDTO> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<RestaurantDTO> restaurants) {
        this.restaurants = restaurants;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommandeDTO)) {
            return false;
        }

        CommandeDTO commandeDTO = (CommandeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, commandeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CommandeDTO{" +
            "id=" + getId() +
            ", listeArticle='" + getListeArticle() + "'" +
            ", heureDeCommande='" + getHeureDeCommande() + "'" +
            ", paiement='" + getPaiement() + "'" +
            ", restaurants=" + getRestaurants() +
            ", client=" + getClient() +
            "}";
    }
}
