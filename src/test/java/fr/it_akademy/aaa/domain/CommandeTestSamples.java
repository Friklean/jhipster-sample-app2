package fr.it_akademy.aaa.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class CommandeTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Commande getCommandeSample1() {
        return new Commande().id(1L).listeArticle("listeArticle1").heureDeCommande("heureDeCommande1").paiement("paiement1");
    }

    public static Commande getCommandeSample2() {
        return new Commande().id(2L).listeArticle("listeArticle2").heureDeCommande("heureDeCommande2").paiement("paiement2");
    }

    public static Commande getCommandeRandomSampleGenerator() {
        return new Commande()
            .id(longCount.incrementAndGet())
            .listeArticle(UUID.randomUUID().toString())
            .heureDeCommande(UUID.randomUUID().toString())
            .paiement(UUID.randomUUID().toString());
    }
}
