package fr.it_akademy.aaa.domain;

import static fr.it_akademy.aaa.domain.ClientTestSamples.*;
import static fr.it_akademy.aaa.domain.CommandeTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import fr.it_akademy.aaa.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ClientTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Client.class);
        Client client1 = getClientSample1();
        Client client2 = new Client();
        assertThat(client1).isNotEqualTo(client2);

        client2.setId(client1.getId());
        assertThat(client1).isEqualTo(client2);

        client2 = getClientSample2();
        assertThat(client1).isNotEqualTo(client2);
    }

    @Test
    void commandeTest() throws Exception {
        Client client = getClientRandomSampleGenerator();
        Commande commandeBack = getCommandeRandomSampleGenerator();

        client.addCommande(commandeBack);
        assertThat(client.getCommandes()).containsOnly(commandeBack);
        assertThat(commandeBack.getClient()).isEqualTo(client);

        client.removeCommande(commandeBack);
        assertThat(client.getCommandes()).doesNotContain(commandeBack);
        assertThat(commandeBack.getClient()).isNull();

        client.commandes(new HashSet<>(Set.of(commandeBack)));
        assertThat(client.getCommandes()).containsOnly(commandeBack);
        assertThat(commandeBack.getClient()).isEqualTo(client);

        client.setCommandes(new HashSet<>());
        assertThat(client.getCommandes()).doesNotContain(commandeBack);
        assertThat(commandeBack.getClient()).isNull();
    }
}
