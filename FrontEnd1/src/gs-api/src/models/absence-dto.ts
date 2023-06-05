/* tslint:disable */
import { EmployeDTO } from './employe-dto';
export interface AbsenceDTO {
  idAbsence?: number;
  dateDebut?: string;
  dateFin?: string;
  justifie?: string;
  motif?: string;
  pieceJustificatifString?: string;
  employe?: EmployeDTO;
}
