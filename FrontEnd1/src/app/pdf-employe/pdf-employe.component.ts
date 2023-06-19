import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import pdfFonts from 'pdfmake/build/vfs_fonts';
import pdfMake from 'pdfmake/build/pdfmake';
import { EmployeDTO, LaboDTO } from 'src/gs-api/src/models';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeService } from '../services/employe/employe.service';
import { LaboService } from '../services/labo/labo.service';


pdfMake.vfs = pdfFonts.pdfMake.vfs;
@Component({
  selector: 'app-pdf-employe',
  templateUrl: './pdf-employe.component.html',
  styleUrls: ['./pdf-employe.component.css']
})
export class PdfEmployeComponent implements OnInit {


  employeDto: EmployeDTO = {};
  laboDt: LaboDTO = {};
  
  constructor(private router: Router,
              private employeservice: EmployeService,
              private laboservice: LaboService,
              private activatedRouter: ActivatedRoute,

             ) { }

  ngOnInit(): void {

    const idLabo = this.activatedRouter.snapshot.params.idLabo;
    if (idLabo) {
      this.laboservice.findLbaoById(idLabo)
      .subscribe(labo => {
        this.laboDt = labo;
      });
    }
    const id_employe = this.activatedRouter.snapshot.params.idEmploye;
    if (id_employe) {
       this.employeservice.findEmployetById(id_employe)
       .subscribe(employe => {
         this.employeDto = employe;
         this.laboDt = this.employeDto.labo;
         console.log(this.employeDto.labo);
        

       });
     }

    }
  // tslint:disable-next-line:typedef
   generatePdf(action = 'open') {
        const documentDefinition = this.getDocumentDefinition();
        switch (action) {
          case 'open': pdfMake.createPdf(documentDefinition).open(); break;
          case 'print': pdfMake.createPdf(documentDefinition).print(); break;
          case 'download': pdfMake.createPdf(documentDefinition).download(); break;
          default: pdfMake.createPdf(documentDefinition).open(); break;
        }
      }


  // tslint:disable-next-line:typedef
      getDocumentDefinition() {
         // sessionStorage.setItem('detailResultatDT', JSON.stringify(this.detailResultatDT));
        // sessionStorage.setItem('patientDt', JSON.stringify(this.patientDt));
         return {

           content: [
           

             {
              image: 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAO4AAADUCAMAAACs0e/bAAAAxlBMVEX///8edLS0wMwARHAAO2vy9/sfdrUAPWxSc5EAOWoAa7AAaa8AP20AQm8QcLIANmhxoMrs8PMNSHMAZq7P19/4+vuUprjm6/B4kKfX3uW6xtFZeZaKnrKmtcQfT3cpVXtshZ+AlqzH0NnX5PDn7/be5OlFaYq4xNA7YYS90uZjf5p7kqkAL2Sgr7+susiGnLCAqtBil8bP3u2wyeE/hLyRtNVQjcEAYax7ps1bk8SqxN7G2OmZutlHib4vfrkAJV8AGlsAKGGjOncsAAANUklEQVR4nO2bDXuaPBfHIy8FlJcSCQgoIMpLfcG2q127drvvff8v9ZwEtbZ17XZvyh6a37VLBVI4f5KcnJNkCHE4HA6Hw+FwOBwOh8PhcDgcDofD4XA4HA6Hw+FwOBwOh8PhcP4Al/3zSdM2nI5Jv2P2rj6M4Mu+2emY3fsPIli+vu1RwZ+vm7bkFHzqreXJedfs9C6aNuUU3Jhm9246vex9a9qSU3Dd7UBD7l9N5A/Rlq+g21LBvfOmLTkF016npvshKnddV27HvG/aklNAzjaV2/sQo+6n7keqXBiFarn9D1G519vKvWrakpOwGYU63Q9RuXL/Q1XudhTqTZu25BSQumrN7ocIqNgoZJq35/cfonLpKNS7JNPrD+Gn6CjUvZje9Lvd3rppW07AlWmuJ13mrbrtd82QC/V2UVX7ZzLWpnm1S/9aP/ISs2OuLzZBZKfT9pkbGIXM9cNO7k3T9hwZ2mtv5K1c865pe44Ly4V607vuxwgjWS5k3pJbNhHZ/dS0PcdlWtcqjLdfbvpm61fEtrlQ92vTlpwEc+uRzdumTTkBX3YDUNvjR/lyLddrnCCVOeVW5weXPboCJq9Ba/fLN6b3oWmbjshjnw4851Py5ewWTeo+3LRNx+TipmfWuxPkTSfutro5o4dbJvgrbcSsOZt20yYdk8l0ct+lgqebVROz1dV7079G06tetw9yCct4z5o26YhMPp+hb+fT6Zp5ZBY899q8uHv38NDrb0efR7P1rRndmrtYmU1otDuUvO49TcVNWOc1mzTnOJBdCn/x+Wlq6prJ7Tdi0VE57+82Pj48TV7UcnvNmHREIKM3e7evXHA9GdltwqKjMjHpCljv5kVCwDxzG+dd5Uea8Zndb89WDOpJq1ZOREIWxFKCb08zcaRuy21dM/n0jS6Cdc0vpD5+ZHJNuVmrjsHk5pFqvPjaY4LXVGLtqMw2Lt9fga9iGh9u6xo+v7zvtnbjzaSeQL+kQ+71PR1te/1+t7WO6ny7k5cFG59M03ycksklddakadv+PNs9VB2z07+n0zYd+eH+6/lkYrZyak4+q/cldL48Pp5BbEXkyx7UcP/ioaXJ3wWboroDP7Wm/fdTvXLf4s2f1/dd83Zt0o1jU3m7b7vNC9mT8/7t413X7F9fbpeJWhtRMaZ3nx/ky6/yblGsjenBKx73FsXa6JlfcLZT2/5NRhBHPlUuOOeWJQiT9fkLbvbUdsxbOHPXmu0ZaxpPPKfzDHaq+60dseRuJ+A7tGQhcPKTcs12bEuZdM9+is5tO1yW/LM0bSiHw+FwOBwOh8PhcDjPyZz9IxLQU9neGc97Ubg6fJ+UzlcFf9q634HY9N9znIWwXyJOEPKtvTfgYf/pwF8UCInJoXuP/oEUf5a/+fhfs/a3URdotniht5L25XraACFX2pO70vbkuhJUX4wP2Z1IMrLF8I2n0xInpRqjYv7inPBcrvRS7lDal6tTudG+3OUAjRL4HmggFx+QK4cpSQr69OQvmJ79XbmqjkIFvSE3WyztxfAPW/3zvGjM/1WuvfFgBA5oI/2hXPpA9kw5e3X+yNhBlQvPTwlK4aUOkFJrfl6uoaTP7vNjuVtKac+n29ly9l9V/Cwp1kWxHiv8hH66KRLE3NAphj5/U66zeiZXw9HO84yEH8l1alchq/ARYXE3ps106bCD/4OQWJwnBpNLImqAsKBy1YSRR/gtubYyf96YU1qUkS5ey/WYX7KNWlO4oKd8rG6uutJqiJNjagUcZYUKqZarU8OW0CALadsoywjsOyC37nKy9lS79ZWltQkqBHrP53IJxvTL0+tXkmvsq9CW9eW4hNecHEXkE6mYq2WUq5Qohg96kG9OqGEchaqK9+RSL4SGeHM9KuEPxILKVdWnewDsFrG+LzfDUX2lLsJuTf8i2jwqLuPo6HI1LGIsMupvLO5ObH7R6nAXtdzQYXK3f0E/tID1wc2Zza+6hAVylW1rzXC8d2nvqbtjbBzbVXmV8D7gf/yqHjhE6sSHhrt3lYYLTweD5d4leDek2sbMHo4OPaxYrYrdQfpDQxuBRKVN/MMh46bEDy6lgyTChy95h08flY2VQvn2SO8qOMaK++v3t7HBXLIdC+8VPQHBv6nzLxiy1N5511WpxCw0EP7Ngn9+ofHZI9rqkbf4QbJ4UjI181Tn/XJPOKrtq9n75TgczpFwlvs9UFi+kXCPntyMgA/39GBJfObAgtHhy03/x/zlotg7ysU37Imf5p0q67BXHkh2xVIeLB16H4NF095tpGzyP0cmHlIjLy2YScRxIJwingxm246PPNkuc3gXsuMQuhsfLhG/vrQlLeyxWMsVRJbeyB7cl9S3tyGgmEuZTd+n58Efssdk268TTePUcrNYsrBqyGEUW5aypImwZYkVcqRIQ65hWWo0nEVRjCrRsqIUVQsnUOIYEiLLiusa8+AWehnZbNpWjUPaToZ6aWkxaMslywitbKxksU6QY8180ZJGyFYlS4L3spKs6DTRVS23FF1nDul5iFXfyTXH0+MiLRXHN2IhUMq0KPEwjcvA0cqgiAxP0JxULNNASZygrGeqcnGZuRizzuBLq5QGXy7O06GxQqq4clxsgFzPVQqoZH9mpGGOVDzyXd2F5DMol6eT69DUFR4OtWszY10F6igTk0wboRDDi/chMy5VlBgezZLdAuRKAsqjURGM2aRNptFGPKjlDsSRE0U06HQgr0hsieY6A4XKtfUERSUa6GMHZYYaFEUZyzg+lQ9jcgOW4ruirMb0nDYYsBngOM+0CuXsnMXkqjSRt8VBAHIh9cORZFm6Rj12KlFfPDKo2XYUGQoWAyaXYDVj1wSNNmY0w5VSITI3lNAXIwv6jIV8VVJOE0wzub6WwM8caleEWg0Ud0QnzVJj7IOUhJ5L69qd01oXlFFRyw2xj2DkYRJZZpuz2l0aSTVaiuFWLmHXZgqTm4pxREiRotBwRJVQ3+cVXha9NYf3B+WKpVpmoTJzcwxyMV6NsWGTSJyvsOj5FrgrnZ7DIDdHnoZXcyMiguWkVgDNOh6O9TohHCiqm4tMbsw+VeioGpWbo0RX3dCAvqtl9OoQnIU2LEUYt0JXXQy9RbkyVieRW8VlCb41wVa4iuWZ6upaTgeYma6FGfIjaGNpaYnL0kVqSJMJSZnZSIicNKKdPtf02abbjbGlDmM4cCI2HxXE7jKC2i/hz1Z4kbuRN6T+N6TTj1lpxdBQ3MiKwaWNsBaedkFhl5hvf+xn6uRQwbeLvbr/9kdGR56nE+TF5bYxWPxSpvn/ju+/X4bz1/OjabpGsdM0BU/pzXaJEUlfpy2j2ftRD0nZAIyclDXXAG+XULKUVLNX9yRpE6260HRJcpG/2MWs9vfxq1Jj6f0IPpMUumhrGwrVObbG2wUy97s3tF5ps5Xkv9r8GwT6uKJhgU2bnkw/bW24/YnY7g0kwxH7CTEQ+0cTQGpxLWhT0sMRDTcrHNHXtd3P4vlkqWX1BpBNeQLfhNis9jePkU+V9gcQ6c8VL7OWEFpIVlwxuWSgWBjGfxJKi3ImoRWkBlVk6WNFsK2ELn5lNPqwVA/JOc0UmdxYB415jkHuXLREOh+daBbOdc+F1pGWCyuHNp1CjpnECQG5JFEWeElX4iz1ND09EHMVUnEqt9THo9IKCMgNpUGVS0ukGoNKxQbItQOpHA1FUbAlJtfzpbJaxhhSXgg/mVxxXs4hzBwZY5Qoc2GgLeE7SccQjLoKlI9HrqjbmRZBtIWZXNUYFzNLIJLqKgdne44gN47E0oNML4UujOQoh9rN2EptXPosAiqpXJlF/yNlI1fzBmKRZUspALmb/N4YuxFairayknU1yzLI7CSaG0DHdxU7MaCYU3ljmmX4BpWb6bMs88tcVtT0RHtwAnithTH3tGrElqln2JbcgK7rQaBLUzUa/FO5EZ2pyqxaLjTOPNItS1FcEiq10/GMeaal+Qxpq8ygmZ2BWY6PAovKzTeLwDOdftLGPE9FTBNAEQlYi08Ta9G+a4uJt6ldArUrDX2N1W7ss1rO69qlWxEESEutGX0DXiIGvu+kXuZBn/eZ3AFkyDp0hhVkg5mfpams0Xc0V3a1m6X2HJJAaPjb2vV9GL8yuTj6WvZGrqEOYqXKrBE02qGQawWxhpC8jQsV5EPnCkIsbvqu4GIsoBJDLmt4jlIKVazJqjaa6XSYykCuC1VFLOi7+jyYw4A00MNiDoVp39XjailqNu3DMBZs+u4wSCTX+R6OjNPsPArECEMO5lPPrOpaBF8gV54ZWu2ZDasMdTQGQUusGaoooBRrogpVFMSaFKfIjzWDjdlUbgYSqVyUiBZ0T3C9ohUNJG8InpmVh2YgRJo2o405oY+xRGhAA13KT9N5iW1vx1RoYxnbLiKzn/ApjwTPI2Vcj4tyZvsa5L+yb9dboOqNocTfDJr079jATf/e3pyFcRdtN15uNpIS+IYy9WP8/StNM7DiQbS3rSz9/jcsWB6PKizDvT26tvB3VAOHw+FwOBwOh8PhcDgcDofD4XA4HA6Hw+FwOBxOA/wP5HQzFD/6RwAAAAAASUVORK5CYII=',
              width: 100,
              alignment: 'right',

             },
             {

              text: 'Laboratoire d\'analyses Médicales ',
              bold: true,
              fontSize: 20,
              width: 100,
              alignment: 'center',
              margin: [0, 0, 0, 20]

             },

              {
                columns: [
                    [{
                     // text: 'name :' +this.detailResultatDT.description,
                     // style: 'name'
                    },

                   {text: [
                   {text: 'Fiche Employe '+ '\n', alignment: 'center' ,fontSize: 14,italics: true,bold: true,  color: 'blue'},
                       // tslint:disable-next-line:max-line-length
                  ],

                  },

                  {
                    style: 'tableExample',
                    margin: [0, 50],
                    table: {
                      widths: [300, '*'],
                    
                     
                     
                      body: [
                      
                       ['Designation', 'Valeur'],
                       
                       
                       [
                         {text: [
                          {text: 'NOM\n',fontSize: 14,italics: true},
                             ],},
                                
                         {text: [
                           {text: this.employeDto.nom + ' \n' , fontSize: 14, italics: true,  color: 'blue' },
                           ], },
                         ],
                         [
                          {text: [
                            {text: 'PRENOM \n', fontSize: 14,italics: true },
                          ],},                   
                          {text: [
                            {text: this.employeDto.prenom + '  \n' ,  fontSize: 14, italics: true,  color: 'blue'},
                            ], },
                           ],
                          [
                            {text: [
                              {text: 'C.I.N\n', fontSize: 14,italics: true },
                            ],},                                   
                            {text: [
                              {text: this.employeDto.cin + '  \n',  fontSize: 14, italics: true,  color: 'blue'},
                            ], },   
                            ],
                            [
                              {text: [
                                {text: 'ADRESSE \n',fontSize: 14,italics: true },
                              ],},                                     
                              {text: [
                                {text: this.employeDto.adresse + ' \n', fontSize: 14, italics: true,  color: 'blue'},
                              ], },     
                              ],
                              [
                                {text: [
                                  {text: 'EMAIL \n', fontSize: 14,italics: true , },
                                ],},                                       
                                {text: [
                                  {text: this.employeDto.email + ' \n', fontSize: 14, italics: true,  color: 'blue'},
                                ], },       
                                ],
                                [
                                  {text: [
                                    {text: 'TELEPHONE \n', fontSize: 14,italics: true , },
                                  ],},                                         
                                  {text: [
                                    {text: this.employeDto.telephone + ' \n', fontSize: 14, italics: true,  color: 'blue'},
                                  ], },        
                                  ],
                                  [
                                    {text: [
                                      {text: 'SALAIRE \n', fontSize: 14,italics: true , },
                                    ],},                                           
                                    {text: [
                                      {text: this.employeDto.salaire + ' Dhs\n', fontSize: 14, italics: true,  color: 'blue'},
                                    ], },           
                                    ],
                                    [
                                      {text: [
                                        {text: 'DATE D\'Embauche \n', fontSize: 14,italics: true , },
                                      ],},                                             
                                      {text: [
                                        {text: moment(this.employeDto.date_embauchDate).format('DD/MM/YYYY') + '\n',  fontSize: 14, italics: true,  color: 'blue'}
                                      ], },             
                                      ],

                     ]
                   }
                 },

                 {
                  text: '*************************************************'+'\n'+
                  'Documents valider et vérifier par nos Services pour plus d\'informations contacter nous.'+'\n',
                   
                  margin: [0, 240,0,0],
                   alignment: 'center',
                 },
                 
                 {
                  text: 'Telephone: 0537333435'+'\n',
                  margin: [0, 0,0,0],
                  
                   alignment: 'center',
                 },
                 {
                  text: 'Email: LaboBaa@gmail.com'+'\n',
                  margin: [0, 0,0,0],
                  
                   alignment: 'center',
                 },
                 {
                  text: 'SiteWeb: WWW.LaboBaa.ma'+'\n',
                  margin: [0, 0,0,0],
                  
                   alignment: 'center',
                 },
                 



                 ],

                ]

              },
             ],


           };
         }



        }



