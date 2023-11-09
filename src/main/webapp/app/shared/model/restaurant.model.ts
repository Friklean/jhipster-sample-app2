import { ILivreur } from 'app/shared/model/livreur.model';
import { ICommande } from 'app/shared/model/commande.model';

export interface IRestaurant {
  id?: number;
  preparationCommande?: string | null;
  heureDePreparation?: string | null;
  livreurs?: ILivreur[] | null;
  commandes?: ICommande[] | null;
}

export const defaultValue: Readonly<IRestaurant> = {};
