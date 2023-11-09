import client from 'app/entities/client/client.reducer';
import commande from 'app/entities/commande/commande.reducer';
import restaurant from 'app/entities/restaurant/restaurant.reducer';
import livreur from 'app/entities/livreur/livreur.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

const entitiesReducers = {
  client,
  commande,
  restaurant,
  livreur,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
};

export default entitiesReducers;
