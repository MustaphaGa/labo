/* tslint:disable */
import { LaboDTO } from './labo-dto';
export interface EmployeDTO {
  id_employe?: number;
  nom?: string;
  prenom?: string;
  email?: string;
  cin?: string;
  adresse?: string;
  telephone?: string;
  salaire?: number;
  password?: string;
  date_embauchDate?: Date;
  photo?: string;
  labo?: LaboDTO;
}
