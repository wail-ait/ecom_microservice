import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";
import {Acheteur} from "../../../Moduls/Acheteur.model";
import {Vente} from '../../../Moduls/Vente.model';
import {FormsModule, NgForm} from "@angular/forms";
import {AcheteursSrv} from "../services/acheteursSrv.service"
import {VentesSrv} from "../services/ventes-srv.service"
//import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-acheteur',
  standalone: true,
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './acheteur.component.html',
  styleUrls: ['./acheteur.component.css'],
  providers: [AcheteursSrv,VentesSrv]
})

export class AcheteurComponent implements OnInit{

  ach: Acheteur = { id_Acheteur: 0, nom: '', ville: '' };
  acheteurs:any;
  vente :Array<Vente>=[];
  test={nom:"",ville:""};

  //constructeur
  constructor(private http : HttpClient, private acheteursSrv:AcheteursSrv,private ventesSrv:VentesSrv) {
  }

  ngOnInit() {
    this.getAcheteurs();
    this.getAllVentes();
  }

  //method to show the acheteurs
  getAcheteurs(){
    this.acheteursSrv.getAllAcheteurs().subscribe({
      next:value => {
        this.acheteurs=value},error:err => {console.log(err)}
    });
  }

  //this method will help in the deleting process
  getAllVentes(){
    this.ventesSrv.getAllVentes()
      .subscribe({
        next: data => {
          this.vente = data;},
        error:err=>{console.error(err);}
      });
  }

  //method to update an acheteur
  updateAcheteur(upd:NgForm){
    alert("Updated seccessfull")
    let valeur = upd.value;
    if (valeur.nom=="") {
      valeur.nom = this.ach.nom;
    }
    if (valeur.ville=="") {
      valeur.ville = this.ach.ville;
    }
    let achet = {nom:valeur.nom, ville:valeur.ville};
    this.acheteursSrv.putAcheteur(this.ach.id_Acheteur,achet)
      .subscribe({next:(response) => {
          console.log("Update successful:", response);
          location.reload();}
        ,error:err => {console.log(err)}})
  }

  //methode to get the acheteur we want to update
  recupereAch(acheteur:Acheteur){
    this.ach=acheteur;
  }

  //method to delete an Acheteur
  deleteAcheteur() {
    this.acheteursSrv.deleteAcheteur(this.ach.id_Acheteur)
      .subscribe(
        () => {
          console.log("Acheteur Deleted Seccessfuly");
          location.reload();
        },
        error => {
          console.error("Error deleting Acheteur", error);
        }
      );
  }


  //method to confirm the suppression
  confirmDelete(achteur:Acheteur) {
    this.ach=achteur;

    let check=true;
    for (let v of this.vente){
      if (achteur.id_Acheteur===v.acheteur.id_Acheteur)
        check=false;
    }

    if (check){
      const confirmation = confirm('Are you sure you want to delete?');
      if (confirmation) {
        this.deleteAcheteur();
      }
    }else {
      alert("delete failed .  this acheteur already has a vente");
    }
  }

  //method to add new acheteurs
  addAcheteur(add:NgForm){
      //to force the user to fill all the inputs
    if (add.invalid) {
      alert("Please fill in all the required inputs");
      return;
    }

    alert("new Acheteur added successfully");
    let value=add.value;
    let ach={nom:value.nom,ville:value.ville};
    this.acheteursSrv.postAcheteur(ach)
      .subscribe({
        next:value => {
          location.reload();
        }
        ,error:err => {console.error(err)}
      })
  }

}
