import { ICommande } from 'app/shared/model/commande.model';

export interface IClient {
  id?: number;
  nom?: string | null;
  prenom?: string | null;
  adresse?: string | null;
  codePostal?: string | null;
  ville?: string | null;
  commandes?: ICommande[] | null;
}

export const defaultValue: Readonly<IClient> = {};
