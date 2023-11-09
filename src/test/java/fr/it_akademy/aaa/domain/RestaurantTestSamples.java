package fr.it_akademy.aaa.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class RestaurantTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Restaurant getRestaurantSample1() {
        return new Restaurant().id(1L).preparationCommande("preparationCommande1").heureDePreparation("heureDePreparation1");
    }

    public static Restaurant getRestaurantSample2() {
        return new Restaurant().id(2L).preparationCommande("preparationCommande2").heureDePreparation("heureDePreparation2");
    }

    public static Restaurant getRestaurantRandomSampleGenerator() {
        return new Restaurant()
            .id(longCount.incrementAndGet())
            .preparationCommande(UUID.randomUUID().toString())
            .heureDePreparation(UUID.randomUUID().toString());
    }
}
