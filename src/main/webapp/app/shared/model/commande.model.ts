import { IRestaurant } from 'app/shared/model/restaurant.model';
import { IClient } from 'app/shared/model/client.model';

export interface ICommande {
  id?: number;
  listeArticle?: string | null;
  heureDeCommande?: string | null;
  paiement?: string | null;
  restaurants?: IRestaurant[] | null;
  client?: IClient | null;
}

export const defaultValue: Readonly<ICommande> = {};
