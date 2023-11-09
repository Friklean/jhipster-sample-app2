package fr.it_akademy.aaa.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class LivreurTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Livreur getLivreurSample1() {
        return new Livreur().id(1L).commandePreparer("commandePreparer1").adresseLivraison("adresseLivraison1");
    }

    public static Livreur getLivreurSample2() {
        return new Livreur().id(2L).commandePreparer("commandePreparer2").adresseLivraison("adresseLivraison2");
    }

    public static Livreur getLivreurRandomSampleGenerator() {
        return new Livreur()
            .id(longCount.incrementAndGet())
            .commandePreparer(UUID.randomUUID().toString())
            .adresseLivraison(UUID.randomUUID().toString());
    }
}
