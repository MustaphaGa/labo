import { Component, OnInit } from '@angular/core';
import { Menu} from '../menu';
import {Router}from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
public menuProperties: Array<Menu> = [
  {
  id: '1',
  titre: 'Tableau de bord' ,
icon: 'fas fa-chart-line',
url: '',
sousMenu : [
  {
    id: '11',
    titre: 'Vue d\'ensemble',
    icon: 'fas fa-chart-pie',
    url: ''
  },
  {
    id: '12',
    titre: 'Statistique',
    icon: 'far fa-chart-bar',
    url: 'statistiques',
  }
]


},
{
  id: '24',
  titre: 'Analyses',
  icon: 'fas fa-diagnoses',
  url: '',
  sousMenu : [
    {
      id: '25',
      titre: ' Analyse Medical',
      icon: 'fas fa-plus',
      url: 'analyses'
    },
    {
      id: '29',
      titre: ' Facture',
      icon: 'fas fa-file-invoice',
      url: 'facture'
    },
    {
      id: '30',
      titre: ' Detail Resultat',
      icon: 'fas fa-poll-h',
      url: 'detailresultat'
    }

  ]
},
{
  id: '23',
  titre: 'Patients',
  icon: ' fas fa-users',
  url: '',
  sousMenu : [
    {
      id: '21',
      titre: 'Patients',
      icon: 'fas fa-users',
      url: 'patients'
    },
    {
      id: '28',
      titre: 'Reservation',
      icon: 'fas fa-cauldron',
      url: 'reservation'
    }
  ]
},
{
  id: '2-',
  titre: 'Preleveur',
  icon: 'fas fa-user-nurse',
  url: '',
  sousMenu : [
    {
      id: '27',
      titre: 'Preleveurs',
      icon: 'fas fa-user-nurse',
      url: 'preleveurs'
    }
  ]
},
{
  id: '25',
  titre: 'Biologistes',
  icon: ' fas fa-user-md',
  url: '',
  sousMenu : [
    {
      id: '21',
      titre: 'Biologistes',
      icon: 'fas fa-user-md',
      url: 'biologiste'
    }
  ]
},
  {
    id: '26',
    titre: 'RH',
    icon: ' fas fa-users-cog',
    url: '',
    sousMenu : [
      {
        id: '20',
        titre: 'Employees',
        icon: 'fas fa-users-cog',
        url: 'employees'
      },
      {
        id: '21',
        titre: 'Absence',
        icon: '',
        url: 'absence'
      },
      {
        id: '22',
        titre: 'Conges',
        icon: '',
        url: 'conges'
      },
      {
        id: '23',
        titre: 'Recrutement',
        icon: '',
        url: 'recrutement'
      },
      {
        id: '24',
        titre: 'Mouvement',
        icon: '',
        url: 'mouvement'
      },


    ]
  },
  {
    id: '40',
    titre: 'Gestion Stock',
    icon: 'fa fa-cubes',
    url: '',
    sousMenu : [
      {
        id: '41',
        titre: 'Article',
        icon: '',
        url: 'article'
      },
      {
        id: '41',
        titre: 'Fournisseur',
        icon: '',
        url: 'fournisseur'
      },
      {
        id: '42',
       titre: 'BonCommande',
        icon: '',
        url: 'bonCmd'
      },
      {
        id: '43',
        titre: 'Stock',
        icon: '',
        url: 'stock'
      },

    ]
  },
  {
    id: '50',
    titre: 'Finance',
    icon: 'fa fa-coins',
    url: '',
    sousMenu : [
      {
        id: '51',
        titre: 'Operation',
        icon: '',
        url: 'operation'
      },
      {
        id: '52',
        titre: 'Bilan Financier',
        icon: '',
        url: 'bilanFinance'
      },
      {
        id: '53',
        titre: 'Compte',
        icon: '',
        url: 'compte'
      },
    ]
  },
{
  id: '20',
  titre: 'Parametre',
  icon: 'fas fa-cogs',
  url: '',
  sousMenu : [
    {
      id: '16',
      titre: 'Labo',
      icon: '',
      url: 'labo'
    },
    {
      id: '17',
      titre: 'Type Analyse',
      icon: '',
      url: 'TypeAnalyse'
    },
    {
      id: '18',
      titre: 'Departement',
      icon: '',
      url: 'departement'
    },

  ]
}
];
  constructor(private router: Router ) { }

  ngOnInit(): void {
  }
  navigate(url?: string): void{
this.router.navigate([url]);
  }

}
