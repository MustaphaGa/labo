/* tslint:disable */
import { BiologisteDTO } from './biologiste-dto';
import { AnalyseMedicalDTO } from './analyse-medical-dto';
export interface DetailResultatDTO {
  idResultat?: number;
  description?: string;
  valeur?: number;
  biologiste?: BiologisteDTO;
  analyseMedical?: AnalyseMedicalDTO;
}
