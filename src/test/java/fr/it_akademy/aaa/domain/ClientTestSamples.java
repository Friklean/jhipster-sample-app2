package fr.it_akademy.aaa.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ClientTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Client getClientSample1() {
        return new Client().id(1L).nom("nom1").prenom("prenom1").adresse("adresse1").codePostal("codePostal1").ville("ville1");
    }

    public static Client getClientSample2() {
        return new Client().id(2L).nom("nom2").prenom("prenom2").adresse("adresse2").codePostal("codePostal2").ville("ville2");
    }

    public static Client getClientRandomSampleGenerator() {
        return new Client()
            .id(longCount.incrementAndGet())
            .nom(UUID.randomUUID().toString())
            .prenom(UUID.randomUUID().toString())
            .adresse(UUID.randomUUID().toString())
            .codePostal(UUID.randomUUID().toString())
            .ville(UUID.randomUUID().toString());
    }
}
