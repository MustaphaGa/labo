/* tslint:disable */
import { RhDTO } from './rh-dto';
export interface MouvementDTO {
  idMouvement?: number;
  typeMouvement?: string;
  detailMouvement?: string;
  frais?: number;
  rh?: RhDTO;
}
