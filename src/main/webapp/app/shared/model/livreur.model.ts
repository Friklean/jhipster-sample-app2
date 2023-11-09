import { IRestaurant } from 'app/shared/model/restaurant.model';

export interface ILivreur {
  id?: number;
  commandePreparer?: string | null;
  adresseLivraison?: string | null;
  restaurant?: IRestaurant | null;
}

export const defaultValue: Readonly<ILivreur> = {};
