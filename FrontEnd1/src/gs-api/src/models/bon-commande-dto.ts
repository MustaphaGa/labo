/* tslint:disable */
import { FournisseurDTO } from './fournisseur-dto';
import { ArticleDTO } from './article-dto';
export interface BonCommandeDTO {
  idBonCommande?: number;
  dateCommande?: string;
  fournisseur?: FournisseurDTO;
  article?: ArticleDTO;
  quantiteCommande?: number;
}
