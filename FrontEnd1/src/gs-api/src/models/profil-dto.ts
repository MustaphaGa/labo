/* tslint:disable */
import { UtilisateurDTO } from './utilisateur-dto';
export interface ProfilDTO {
  idProfil?: number;
  nomProfil?: string;
  droit?: string;
  utilisateur?: UtilisateurDTO;
}
