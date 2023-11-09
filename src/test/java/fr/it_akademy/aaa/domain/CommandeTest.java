package fr.it_akademy.aaa.domain;

import static fr.it_akademy.aaa.domain.ClientTestSamples.*;
import static fr.it_akademy.aaa.domain.CommandeTestSamples.*;
import static fr.it_akademy.aaa.domain.RestaurantTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import fr.it_akademy.aaa.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CommandeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Commande.class);
        Commande commande1 = getCommandeSample1();
        Commande commande2 = new Commande();
        assertThat(commande1).isNotEqualTo(commande2);

        commande2.setId(commande1.getId());
        assertThat(commande1).isEqualTo(commande2);

        commande2 = getCommandeSample2();
        assertThat(commande1).isNotEqualTo(commande2);
    }

    @Test
    void restaurantTest() throws Exception {
        Commande commande = getCommandeRandomSampleGenerator();
        Restaurant restaurantBack = getRestaurantRandomSampleGenerator();

        commande.addRestaurant(restaurantBack);
        assertThat(commande.getRestaurants()).containsOnly(restaurantBack);

        commande.removeRestaurant(restaurantBack);
        assertThat(commande.getRestaurants()).doesNotContain(restaurantBack);

        commande.restaurants(new HashSet<>(Set.of(restaurantBack)));
        assertThat(commande.getRestaurants()).containsOnly(restaurantBack);

        commande.setRestaurants(new HashSet<>());
        assertThat(commande.getRestaurants()).doesNotContain(restaurantBack);
    }

    @Test
    void clientTest() throws Exception {
        Commande commande = getCommandeRandomSampleGenerator();
        Client clientBack = getClientRandomSampleGenerator();

        commande.setClient(clientBack);
        assertThat(commande.getClient()).isEqualTo(clientBack);

        commande.client(null);
        assertThat(commande.getClient()).isNull();
    }
}
