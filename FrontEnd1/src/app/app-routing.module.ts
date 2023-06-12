import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { PageLoginComponent } from './pages/page-login/page-login.component';
import { PageInscriptionComponent } from './pages/page-inscription/page-inscription.component';
import { PageAccueilComponent } from './pages/page-accueil/page-accueil.component';
import { PageStatistiquesComponent } from './pages/page-statistiques/page-statistiques.component';
import { PageAnalyseComponent } from './pages/analyses/page-analyse/page-analyse.component';
import { NouvelAnalyseComponent } from './pages/analyses/nouvel-analyse/nouvel-analyse.component';
import { PagePatientComponent } from './pages/patient/page-patient/page-patient.component';
import { PageBiologisteComponent } from './pages/biologiste/page-biologiste/page-biologiste.component';
import { NouveauBiologisteComponent } from './composants/nouveau-biologiste/nouveau-biologiste.component';
import { NouveauPatientComponent } from './composants/nouveau-patient/nouveau-patient.component';
import { PagePreleveurComponent } from './pages/preleveur/page-preleveur/page-preleveur.component';
import {ApplicationGuardService} from './services/guard/application-guard.service';
import { NouveauPreleveurComponent } from './composants/nouveau-preleveur/nouveau-preleveur.component';
import { PageReservationComponent } from './pages/patient/page-reservation/page-reservation.component';
import { NouveauReservationComponent } from './composants/nouveau-reservation/nouveau-reservation.component';
import { PageDepartementComponent } from './pages/page-departement/page-departement.component';
import { NouveauDepartementComponent } from './composants/nouveau-departement/nouveau-departement.component';
import { NouveauTypeAnalyseComponent } from './composants/nouveau-type-analyse/nouveau-type-analyse.component';
import { PageTypeAnalyseComponent } from './pages/page-type-analyse/page-type-analyse.component';
import { PageFactureComponent } from './pages/page-facture/page-facture.component';
import { NouveauFactureComponent } from './composants/nouveau-facture/nouveau-facture.component';
import { NouveauResultatComponent } from './composants/nouveau-resultat/nouveau-resultat.component';
import { PageResultatComponent } from './pages/page-resultat/page-resultat.component';
import { PatientDetaillComponent } from './detaill/patient-detaill/patient-detaill.component';
import { BiologisteDetaillComponent } from './detaill/biologiste-detaill/biologiste-detaill.component';
import { PreleveurDetaillComponent } from './detaill/preleveur-detaill/preleveur-detaill.component';
import { AnalyseDetaillComponent } from './detaill/analyse-detaill/analyse-detaill.component';
import { FactureDetaillComponent } from './detaill/facture-detaill/facture-detaill.component';
import { ResultatDetaillComponent } from './detaill/resultat-detaill/resultat-detaill.component';
import { ReservationDetaillComponent } from './detaill/reservation-detaill/reservation-detaill.component';
import { ExportePatientComponent } from './composants/exportationDonner/exporte-patient/exporte-patient.component';
import { ExporteReservationComponent } from './composants/exportationDonner/exporte-reservation/exporte-reservation.component';
import { ExporteAnalyseComponent } from './composants/exportationDonner/exporte-analyse/exporte-analyse.component';
import { ExporteFactureComponent } from './composants/exportationDonner/exporte-facture/exporte-facture.component';
import { ExporteResultatComponent } from './composants/exportationDonner/exporte-resultat/exporte-resultat.component';
import { PdfResultatComponent } from './pdf-resultat/pdf-resultat.component';
import { PageEmployeesComponent } from './pages/employee/page-employees/page-employees.component';
import { NouveauEmployeComponent } from './composants/nouveau-employe/nouveau-employe.component';
import {PageLaboComponent} from './pages/page-labo/page-labo.component';
import {NouveauLaboComponent} from './composants/nouveau-labo/nouveau-labo.component';
import {PageAccueilPrincipalComponent} from './pages/page-accueil-principal/page-accueil-principal.component';
import {PageCongesComponent} from './pages/page-conges/page-conges.component';
import {PageRecrutementComponent} from './pages/page-recrutement/page-recrutement.component';
import {PageMouvementComponent} from './pages/page-mouvement/page-mouvement.component';
import {NouveauRecrutementComponent} from './composants/nouveau-recrutement/nouveau-recrutement.component';
import {NouveauMouvementComponent} from './composants/nouveau-mouvement/nouveau-mouvement.component';
import {PageAbsenceComponent} from './pages/page-absence/page-absence.component';
import { NouveauAbsenceComponent } from './composants/nouveau-absence/nouveau-absence/nouveau-absence.component';
import {AbsenceDetaillComponent} from './detaill/absence-detaill/absence-detaill/absence-detaill.component';
import {PageArticleComponent} from './pages/page-article/page-article.component';
import {PageBonCommandeComponent} from './pages/page-bon-commande/page-bon-commande.component';
import {PageStockComponent} from './pages/page-stock/page-stock.component';
import {PageFournisseurComponent} from './pages/page-fournisseur/page-fournisseur.component';
import {PageOperationComponent} from './pages/page-operation/page-operation.component';
import {PageBilanFinancierComponent} from './pages/page-bilan-financier/page-bilan-financier.component';
import {PageServiceFinanceComponent} from './pages/page-service-finance/page-service-finance.component';
import { NouveauArticleComponent } from './composants/nouveau-article/nouveau-article.component';
import { ArticleDetaillComponent } from './detaill/article-detaill/article-detaill/article-detaill.component';
import {NouveauCongerComponent} from './composants/nouveau-conger/nouveau-conger.component';
const routes: Routes = [
  {
    path: 'pagAccPrincp',
    component: PageAccueilPrincipalComponent
  },
  {
    path: 'login',
    component: PageLoginComponent
  },
  {
    path: 'register',
    component: PageInscriptionComponent

  },
  {
    path: '',
    component: PageAccueilComponent,
    canActivate: [ApplicationGuardService],
    children : [
      {
        path: 'statistiques',
        component: PageStatistiquesComponent,
        canActivate: [ApplicationGuardService]
      },
      {
        path: 'analyses',
        component: PageAnalyseComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouvelanalyse',
        component: NouvelAnalyseComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouvelanalyse/:idAnalyse',
        component: NouvelAnalyseComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'detailanalyse/:idAnalyse',
        component: AnalyseDetaillComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'exporteAnalyse',
        component: ExporteAnalyseComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'facture',
        component: PageFactureComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouvelfacture',
        component: NouveauFactureComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouvelfacture/:idFacture',
        component: NouveauFactureComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'detailfacture/:idFacture',
        component: FactureDetaillComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'exportfacture',
        component: ExporteFactureComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'detailresultat',
        component: PageResultatComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouvelResultat',
        component: NouveauResultatComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouvelResultat/:idResultat',
        component: NouveauResultatComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'detailResultat/:idResultat',
        component: ResultatDetaillComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'exportpdf1/:idResultat',
        component: PdfResultatComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'exportResultat',
        component: ExporteResultatComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'exportpdf/:idPatient',
        component: PdfResultatComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'patients',
        component: PagePatientComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauPatient',
        component: NouveauPatientComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauPatient/:idPatient',
        component: NouveauPatientComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'detailPatient/:idPatient',
        component: AbsenceDetaillComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'exportePatient',
        component: ExportePatientComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'reservation',
        component: PageReservationComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauReservation',
        component: NouveauReservationComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauReservation/:idReservation',
        component: NouveauReservationComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'exporteReservation',
        component: ExporteReservationComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'detailReservation/:idReservation',
        component: ReservationDetaillComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'departement',
        component: PageDepartementComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauDepartement',
        component: NouveauDepartementComponent,

      },
      {
        path: 'preleveurs',
        component: PagePreleveurComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauPreleveurs',
        component: NouveauPreleveurComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauPreleveurs/:idPreleveur',
        component: NouveauPreleveurComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'detailPreleveurs/:idPreleveur',
        component: PreleveurDetaillComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'biologiste',
        component: PageBiologisteComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauBiologist',
        component: NouveauBiologisteComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauBiologist/:idBiologiste',
        component: NouveauBiologisteComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'detailBiologist/:idBiologiste',
        component: BiologisteDetaillComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauTypeAnalyse',
        component: NouveauTypeAnalyseComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'TypeAnalyse',
        component: PageTypeAnalyseComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'employees',
        component: PageEmployeesComponent,
        canActivate: [ApplicationGuardService]

      },
      // '''''''' ''''''''conger'''''''''''''''
      {
        path: 'conges',
        component: PageCongesComponent,
        canActivate: [ApplicationGuardService]
      },

      {
        path: 'nouveauconger',
        component: NouveauCongerComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauconger/:idConge',
        component: NouveauCongerComponent,
        canActivate: [ApplicationGuardService]
      },

      {
        path: 'detailconger/:idConge',
        component: PreleveurDetaillComponent,
        canActivate: [ApplicationGuardService]
      },

      // '''''''' '''''''''''''''''''''''

      {
        path: 'recrutement',
        component: PageRecrutementComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'mouvement',
        component: PageMouvementComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauMouvement',
        component: NouveauMouvementComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauMouvement/:idMouvement',
        component: NouveauMouvementComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'absence',
        component: PageAbsenceComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauAbsence',
        component: NouveauAbsenceComponent,
         canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauAbsence/:idAbsence',
        component: NouveauAbsenceComponent,
         canActivate: [ApplicationGuardService]

      },
      {
        path: 'detailAbsence/:idAbsence',
        component: AbsenceDetaillComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouvelEmployee',
        component: NouveauEmployeComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouvelEmployee/:idEmploye',
        component: NouveauEmployeComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'labo',
        component: PageLaboComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauLabo',
        component: NouveauLaboComponent,
         canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauRecrutement',
        component: NouveauRecrutementComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauRecrutement/:idRecrutement',
        component: NouveauRecrutementComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'article',
        component: PageArticleComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'bonCmd',
        component: PageBonCommandeComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'stock',
        component: PageStockComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'article',
        component: PageArticleComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauArticle',
        component: NouveauArticleComponent,
         canActivate: [ApplicationGuardService]

      },
      {
        path: 'nouveauArticle/:idArticle',
        component: NouveauArticleComponent,
         canActivate: [ApplicationGuardService]

      },
      {
        path: 'detailArticle/:idArticle',
        component: ArticleDetaillComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'fournisseur',
        component: PageFournisseurComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'operation',
        component: PageOperationComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'bilanFinance',
        component: PageBilanFinancierComponent,
        canActivate: [ApplicationGuardService]

      },
      {
        path: 'serviceFinance',
        component: PageServiceFinanceComponent,
        canActivate: [ApplicationGuardService]

      },
    ]
  }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
