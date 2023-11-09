package fr.it_akademy.aaa.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link fr.it_akademy.aaa.domain.Restaurant} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RestaurantDTO implements Serializable {

    private Long id;

    private String preparationCommande;

    private String heureDePreparation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreparationCommande() {
        return preparationCommande;
    }

    public void setPreparationCommande(String preparationCommande) {
        this.preparationCommande = preparationCommande;
    }

    public String getHeureDePreparation() {
        return heureDePreparation;
    }

    public void setHeureDePreparation(String heureDePreparation) {
        this.heureDePreparation = heureDePreparation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestaurantDTO)) {
            return false;
        }

        RestaurantDTO restaurantDTO = (RestaurantDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, restaurantDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RestaurantDTO{" +
            "id=" + getId() +
            ", preparationCommande='" + getPreparationCommande() + "'" +
            ", heureDePreparation='" + getHeureDePreparation() + "'" +
            "}";
    }
}
