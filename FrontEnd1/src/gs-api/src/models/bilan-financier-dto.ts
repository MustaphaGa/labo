/* tslint:disable */
import { CompteDTO } from './compte-dto';
export interface BilanFinancierDTO {
  idBilan?: number;
  compte?: CompteDTO;
  annee_BF?: string;
  montant_BF?: number;
}
