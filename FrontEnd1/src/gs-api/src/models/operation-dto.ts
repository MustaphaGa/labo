/* tslint:disable */
import { CompteDTO } from './compte-dto';
import { NatureOperationDTO } from './nature-operation-dto';
export interface OperationDTO {
 // favoriteSeason: string;
  idOperation?: number;
  dateOperation?: string;
  description?: string;
  compte?: CompteDTO;
  natureOperation?: NatureOperationDTO;
  montant?: number;
  annee?: number;
}
