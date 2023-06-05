/* tslint:disable */
import { BonCommandeDTO } from './bon-commande-dto';
import { StockDTO } from './stock-dto';
export interface ArticleDTO {
  idArticle?: number;
  articleName?: string;
  quantite?: string;
  bonCommande?: BonCommandeDTO;
  stock?: StockDTO;
}
