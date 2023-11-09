package fr.it_akademy.aaa.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link fr.it_akademy.aaa.domain.Livreur} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class LivreurDTO implements Serializable {

    private Long id;

    private String commandePreparer;

    private String adresseLivraison;

    private RestaurantDTO restaurant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommandePreparer() {
        return commandePreparer;
    }

    public void setCommandePreparer(String commandePreparer) {
        this.commandePreparer = commandePreparer;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public RestaurantDTO getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantDTO restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LivreurDTO)) {
            return false;
        }

        LivreurDTO livreurDTO = (LivreurDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, livreurDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LivreurDTO{" +
            "id=" + getId() +
            ", commandePreparer='" + getCommandePreparer() + "'" +
            ", adresseLivraison='" + getAdresseLivraison() + "'" +
            ", restaurant=" + getRestaurant() +
            "}";
    }
}
