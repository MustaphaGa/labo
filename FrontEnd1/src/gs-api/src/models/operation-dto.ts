/* tslint:disable */
import { CompteDTO } from './compte-dto';
export interface OperationDTO {
  idOperation?: number;
  dateOperation?: string;
  typeOperation?: string;
  description?: string;
  compte?: CompteDTO;
  annee?: number;
  montant?: number;
}
