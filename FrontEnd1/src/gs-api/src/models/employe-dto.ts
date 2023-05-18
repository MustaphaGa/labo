/* tslint:disable */
import { RolesDTO } from './roles-dto';
import { LaboDTO } from './labo-dto';
export interface EmployeDTO {
  idEmploye?: number;
  nom?: string;
  prenom?: string;
  email?: string;
  cin?: string;
  adresse?: string;
  telephone?: string;
  salaire?: number;
  password?: string;
  date_embauchDate?: number;
  photo?: string;
  roles?: Array<RolesDTO>;
  labo?: LaboDTO;
}
