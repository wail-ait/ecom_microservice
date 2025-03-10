import {Component, OnInit} from '@angular/core';
import {CommonModule, NgForOf, NgIf} from "@angular/common";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule, NgForm, ReactiveFormsModule,isFormControl,isFormGroup} from "@angular/forms";
import {Vente} from "../../../Moduls/Vente.model";
import {Acheteur} from "../../../Moduls/Acheteur.model";
import {Produit} from "../../../Moduls/Produit.model";
import {ProduitComponent} from "../produit/produit.component";
import {VentesSrv} from "../services/ventes-srv.service"
import {ProduitsSrv} from "../services/produits-srv.service"
import {AcheteursSrv} from "../services/acheteursSrv.service"

@Component({
  selector: 'app-vente',
  standalone: true,
  imports: [CommonModule, HttpClientModule, FormsModule, ReactiveFormsModule, ProduitComponent],
  templateUrl: './vente.component.html',
  styleUrls: ['./vente.component.css'],
  providers: [VentesSrv,ProduitsSrv,AcheteursSrv]
})

export class VenteComponent implements OnInit{
  ventes : any;
  vente:any;
  produits:Array<Produit>=[];
  acheteurs:Array<Acheteur>=[];
  test={id_Acheteur : 0 ,id_Produit : 0 ,quantite : 0 ,mois : 0 ,annee : 0}
  constructor(private http:HttpClient, private ventesSrv:VentesSrv, private produitsSrv:ProduitsSrv, private acheteursSrv:AcheteursSrv) {
  }

  ngOnInit() {
      this.getVentes();
      this.getAcheteurs();
      this.getProducts();
  }

  /************************Methods will help to check if the product or the Acheteur Exist before adding a new vente********************/
  //to get all the acheteurs
  getAcheteurs(){
    this.acheteursSrv.getAllAcheteurs().subscribe({
      next:data => {
        this.acheteurs=data;}
      ,error:err => {console.log(err)}
    });
  }

  //to get all the products
  getProducts(){
    this.produitsSrv.getAllProducts().subscribe({
      next:data =>{
        this.produits=data}
      ,error:err => {console.log(err)}
    });
  }

  //method to get all the vente
  getVentes(){
    this.ventesSrv.getAllVentes()
      .subscribe({
        next: data => {
          this.ventes = data;},
        error:err=>{console.error(err);}
        });
  }

  //method to update a vente
  updateVente(upd:NgForm){
    let value=upd.value;

    if (value.quantite === undefined || !value.quantite)
      value.quantite=this.vente.quantite;
    if (value.mois === undefined || !value.mois)
      value.mois=this.vente.mois;
    if (value.annee === undefined || !value.annee)
      value.annee=this.vente.annee;

    let vnt = {
      quantite:value.quantite,
      mois:value.mois,
      annee:value.annee,
    };

    this.ventesSrv.putVente(this.vente.id_Vente,vnt)
      .subscribe({
        next:() =>{
          alert("vente successfuly updated");
          location.reload();
        }
        ,error:err => {console.error(err);}
      });
  }

  //method to recuper vente
  recupereVente(vente:Vente){
    this.vente=vente;
  }

  //method to delete a vente
  deleteVente(){
    this.ventesSrv.deleteVente(this.vente.id_Vente)
      .subscribe(
        () =>{
          alert("vente deleted succeessfully");
          location.reload();
        }
        ,error=>{
          console.error(error);
        }
      );
  }

  //method to confirme deletion
  confirmDelete(vente : Vente){
    this.vente=vente;
    const confirmation =confirm("are you sure you wanna delete this vente");
    if (confirmation)
      this.deleteVente();

  }

  //method to add new vente
  addVente(add : NgForm){
    //to force the user to fill all the inputs
    if (add.invalid) {
      alert("Please fill in all the required inputs");
      return;
    }

    let value = add.value;
    /*console.log(value);
    let check=false;
    for (let p of this.produits){
      if (p.idProduit===value.id_Produit)
        check=true;
    }
    for (let a of this.acheteurs){
      if (a.id_Acheteur===value.id_Acheteur)
        check=true;
    }*/

    //if(check){
      alert("new vente added successfully");
      let vnt = {
        id_Acheteur: value.id_Acheteur,
        id_Produit: value.id_Produit,
        quantite: value.quantite,
        mois: value.mois,
        annee: value.annee,
      };

      this.ventesSrv.postVente(vnt)
        .subscribe({
          next:value=>{
            location.reload();
          }
          ,error:err => {console.error(err)}
        });
   /*}else {
      alert("acheteur or product doesn't exists");
    }*/
  }

}
