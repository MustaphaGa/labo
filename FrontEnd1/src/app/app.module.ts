import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { PageLoginComponent } from './pages/page-login/page-login.component';
import { PageInscriptionComponent } from './pages/page-inscription/page-inscription.component';
import { PageAccueilComponent } from './pages/page-accueil/page-accueil.component';
import { PageStatistiquesComponent } from './pages/page-statistiques/page-statistiques.component';
import { MenuComponent } from './composants/menu/menu.component';
import { HeaderComponent } from './composants/header/header.component';
import { DetailUtilisateurComponent } from './composants/detail-utilisateur/detail-utilisateur.component';
import { PageAnalyseComponent } from './pages/analyses/page-analyse/page-analyse.component';
import { DetailAnalyseComponent } from './composants/detail-analyse/detail-analyse.component';
import { PaginationComponent } from './composants/pagination/pagination.component';
import { BouttonActionComponent } from './composants/boutton-action/boutton-action.component';
import { NouvelAnalyseComponent } from './pages/analyses/nouvel-analyse/nouvel-analyse.component';
import { DetailPatientComponent } from './composants/detail-patient/detail-patient.component';
import { PagePatientComponent } from './pages/patient/page-patient/page-patient.component';
import { PageBiologisteComponent } from './pages/biologiste/page-biologiste/page-biologiste.component';
import { DetailBiologisteComponent } from './composants/detail-biologiste/detail-biologiste.component';
import { NouveauPatientComponent } from './composants/nouveau-patient/nouveau-patient.component';
import { NouveauBiologisteComponent } from './composants/nouveau-biologiste/nouveau-biologiste.component';
import { DetailPreleveurComponent } from './composants/detail-preleveur/detail-preleveur.component';
import { PagePreleveurComponent } from './pages/preleveur/page-preleveur/page-preleveur.component';
import { NouveauPreleveurComponent } from './composants/nouveau-preleveur/nouveau-preleveur.component';
import { DetailReservationComponent } from './composants/detail-reservation/detail-reservation.component';
import { PageReservationComponent } from './pages/patient/page-reservation/page-reservation.component';
import { NouveauReservationComponent } from './composants/nouveau-reservation/nouveau-reservation.component';
import { NouveauDepartementComponent } from './composants/nouveau-departement/nouveau-departement.component';
import { PageDepartementComponent } from './pages/page-departement/page-departement.component';
import { PageTypeAnalyseComponent } from './pages/page-type-analyse/page-type-analyse.component';
import { NouveauTypeAnalyseComponent } from './composants/nouveau-type-analyse/nouveau-type-analyse.component';
import { NouveauFactureComponent } from './composants/nouveau-facture/nouveau-facture.component';
import { PageFactureComponent } from './pages/page-facture/page-facture.component';
import { DetailFactureComponent } from './composants/detail-facture/detail-facture.component';
import { DetailResultatComponent } from './composants/detail-resultat/detail-resultat.component';
import { NouveauResultatComponent } from './composants/nouveau-resultat/nouveau-resultat.component';
import { PageResultatComponent } from './pages/page-resultat/page-resultat.component';
import { DetaillComponent } from './detaill/detaill.component';
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
import { DetailEmployeComponent } from './composants/detail-employe/detail-employe.component';
import { NouveauEmployeComponent } from './composants/nouveau-employe/nouveau-employe.component';
import { PageLaboComponent } from './pages/page-labo/page-labo.component';
import { NouveauLaboComponent } from './composants/nouveau-labo/nouveau-labo.component';
import { PageAccueilPrincipalComponent } from './pages/page-accueil-principal/page-accueil-principal.component';
import { DetailLaboComponent } from './composants/detail-labo/detail-labo.component';
import { PageCongesComponent } from './pages/page-conges/page-conges.component';
import { PageRecrutementComponent } from './pages/page-recrutement/page-recrutement.component';
import { PageMouvementComponent } from './pages/page-mouvement/page-mouvement.component';
import { DetailRecrutemntComponent } from './composants/detail-recrutemnt/detail-recrutemnt.component';
import { NouveauRecrutementComponent } from './composants/nouveau-recrutement/nouveau-recrutement.component';
import { DetailMouvementComponent } from './composants/detail-mouvement/detail-mouvement.component';
import { NouveauMouvementComponent } from './composants/nouveau-mouvement/nouveau-mouvement.component';
import { PageAbsenceComponent } from './pages/page-absence/page-absence.component';
import { PageArticleComponent } from './pages/page-article/page-article.component';
import { PageBonCommandeComponent } from './pages/page-bon-commande/page-bon-commande.component';
import { PageStockComponent } from './pages/page-stock/page-stock.component';
import { PageFournisseurComponent } from './pages/page-fournisseur/page-fournisseur.component';
import { PageOperationComponent } from './pages/page-operation/page-operation.component';
import { PageBilanFinancierComponent } from './pages/page-bilan-financier/page-bilan-financier.component';
import { PageServiceFinanceComponent } from './pages/page-service-finance/page-service-finance.component';
import { AbsenceDetaillComponent } from './detaill/absence-detaill/absence-detaill/absence-detaill.component';
import { DetailAbsenceComponent } from './composants/detail-absence/detail-absence/detail-absence.component';
import { NouveauAbsenceComponent } from './composants/nouveau-absence/nouveau-absence/nouveau-absence.component';
import { DetailArticleComponent } from './composants/detail-article/detail-article/detail-article.component';
import { ArticleDetaillComponent } from './detaill/article-detaill/article-detaill/article-detaill.component';
import { NouveauArticleComponent } from './composants/nouveau-article/nouveau-article.component';
import { FournisseurDetaillComponent } from './detaill/fournisseur-detaill/fournisseur-detaill.component';
import { DetailFournisseurComponent } from './composants/detail-fournisseur/detail-fournisseur.component';
import { NouveauFournisseurComponent } from './composants/nouveau-fournisseur/nouveau-fournissseur.component';
import { DetailBonCommandeComponent } from './composants/detail-bon-commande/detail-bon-commande.component';
import { BonCommandeDetaillComponent } from './detaill/bon-commande-detaill/bon-commande-detaill.component';
import { NouveauBonCommandeComponent } from './composants/nouveau-bon-commande/nouveau-bon-commande.component';
import { DetailStockComponent } from './composants/detail-stock/detail-stock.component';
import { StockDetaillComponent } from './detaill/stock-detaill/stock-detaill.component';
import { NouveauStockComponent } from './composants/nouveau-stock/nouveau-stock.component';






@NgModule({
  declarations: [
    AppComponent,
    PageLoginComponent,
    PageInscriptionComponent,
    PageAccueilComponent,
    PageStatistiquesComponent,
    MenuComponent,
    HeaderComponent,
    DetailUtilisateurComponent,
    PageAnalyseComponent,
    DetailAnalyseComponent,
    PaginationComponent,
    BouttonActionComponent,
    NouvelAnalyseComponent,
    DetailPatientComponent,
    PagePatientComponent,
    PageBiologisteComponent,
    DetailBiologisteComponent,
    NouveauPatientComponent,
    NouveauBiologisteComponent,
    DetailPreleveurComponent,
    PagePreleveurComponent,
    NouveauPreleveurComponent,
    DetailReservationComponent,
    PageReservationComponent,
    NouveauReservationComponent,
    NouveauDepartementComponent,
    PageDepartementComponent,
    PageTypeAnalyseComponent,
    NouveauTypeAnalyseComponent,
    NouveauFactureComponent,
    PageFactureComponent,
    DetailFactureComponent,
    DetailResultatComponent,
    NouveauResultatComponent,
    PageResultatComponent,
    DetaillComponent,
    PatientDetaillComponent,
    BiologisteDetaillComponent,
    PreleveurDetaillComponent,
    AnalyseDetaillComponent,
    FactureDetaillComponent,
    ResultatDetaillComponent,
    ReservationDetaillComponent,
    ExportePatientComponent,
    ExporteReservationComponent,
    ExporteAnalyseComponent,
    ExporteFactureComponent,
    ExporteResultatComponent,
    PdfResultatComponent,
    PageEmployeesComponent,
    DetailEmployeComponent,
    NouveauEmployeComponent,
    PageLaboComponent,
    NouveauLaboComponent,
    PageAccueilPrincipalComponent,
    DetailLaboComponent,
    PageCongesComponent,
    PageRecrutementComponent,
    PageMouvementComponent,
    DetailRecrutemntComponent,
    NouveauRecrutementComponent,
    DetailMouvementComponent,
    NouveauMouvementComponent,
    PageAbsenceComponent,
    PageArticleComponent,
    PageBonCommandeComponent,
    PageStockComponent,
    PageFournisseurComponent,
    PageOperationComponent,
    PageBilanFinancierComponent,
    PageServiceFinanceComponent,
    AbsenceDetaillComponent,
    DetailAbsenceComponent,
    NouveauAbsenceComponent,
    DetailArticleComponent,
    ArticleDetaillComponent,
    NouveauArticleComponent,
    FournisseurDetaillComponent,
    DetailFournisseurComponent,
    NouveauFournisseurComponent,
    DetailBonCommandeComponent,
    BonCommandeDetaillComponent,
    NouveauBonCommandeComponent,
    DetailStockComponent,
    StockDetaillComponent,
    NouveauStockComponent,
    





  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule



  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
