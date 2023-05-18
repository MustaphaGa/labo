/* tslint:disable */
import { ServiceFinanceDTO } from './service-finance-dto';
import { BilanFinancierDTO } from './bilan-financier-dto';
export interface OperationDTO {
  idOperation?: number;
  dateOperation?: string;
  typeOperation?: string;
  serviceFinance?: ServiceFinanceDTO;
  bilanFinancier?: BilanFinancierDTO;
}
