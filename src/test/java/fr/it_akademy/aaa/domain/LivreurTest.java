package fr.it_akademy.aaa.domain;

import static fr.it_akademy.aaa.domain.LivreurTestSamples.*;
import static fr.it_akademy.aaa.domain.RestaurantTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import fr.it_akademy.aaa.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class LivreurTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Livreur.class);
        Livreur livreur1 = getLivreurSample1();
        Livreur livreur2 = new Livreur();
        assertThat(livreur1).isNotEqualTo(livreur2);

        livreur2.setId(livreur1.getId());
        assertThat(livreur1).isEqualTo(livreur2);

        livreur2 = getLivreurSample2();
        assertThat(livreur1).isNotEqualTo(livreur2);
    }

    @Test
    void restaurantTest() throws Exception {
        Livreur livreur = getLivreurRandomSampleGenerator();
        Restaurant restaurantBack = getRestaurantRandomSampleGenerator();

        livreur.setRestaurant(restaurantBack);
        assertThat(livreur.getRestaurant()).isEqualTo(restaurantBack);

        livreur.restaurant(null);
        assertThat(livreur.getRestaurant()).isNull();
    }
}
