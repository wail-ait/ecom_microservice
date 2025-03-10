import {Component, OnInit,Input} from '@angular/core';
import {CommonModule} from "@angular/common";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Produit} from '../../../Moduls/Produit.model';
import {Vente} from '../../../Moduls/Vente.model';
import {VentesSrv} from "../services/ventes-srv.service"
import {FormsModule, NgForm, ReactiveFormsModule} from "@angular/forms";
import {ProduitsSrv} from "../services/produits-srv.service"
import {Router} from "@angular/router";


@Component({
  selector: 'app-produit',
  standalone: true,
  imports: [CommonModule, HttpClientModule, FormsModule,],
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
  providers: [ProduitsSrv,VentesSrv]
})
export class ProduitComponent implements OnInit{
  prod: Produit={idProduit: 0,marque: '',description: '',prix: 0,quantite: 0};
  produits : any;
  vente :Array<Vente>=[];
  test={marque:'',description:'',prix: 0,quantite: 0};
  constructor(private router: Router, private http:HttpClient, private produitsSrv:ProduitsSrv, private ventesSrv:VentesSrv) {
  }
  ngOnInit() {
    this.getProducts();
    this.getAllVentes();
  }

  //method to get all the products
  getProducts(){
    this.produitsSrv.getAllProducts().subscribe({
      next:value =>{
        this.produits=value}
      ,error:err => {console.log(err)}
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

  //method to update a product
  updateProduct(upd:NgForm){
    let value=upd.value;
    if (value.marque==""){
      value.marque=this.prod.marque;}
    if (value.description==""){
      value.description=this.prod.description;}
    if (value.prix === undefined || !value.prix){
      value.prix=this.prod.prix;}
    if (value.quantite === undefined || !value.quantite){
      value.quantite=this.prod.quantite;}
    let prd = {
      marque:value.marque,
      description:value.description,
      prix:value.prix,
      quantite:value.quantite
    };
    this.produitsSrv.putProduit(this.prod.idProduit,prd)
      .subscribe({
        next:(response) => {
          console.log("Update successful:", response);
          location.reload();}
        ,error:err => {console.log(err)}})
  }

  //method to recupere product
  recupereProd(produit:Produit){
    this.prod=produit;
  }

  //method to delete products
  deleteProduit(){
    this.produitsSrv.deleteProduit(this.prod.idProduit)
      .subscribe(
        ()=>{
          alert("Product Deleted seccessufly");
          location.reload();
        }
        ,error => {
          console.error("Error Deleting Product",error);
        }
      );
  }

  //method to confirme suppression
  confirmDelete(produit: Produit) {
    this.prod = produit;
    let check=true;
    for (let v of this.vente){
      if (produit.idProduit===v.produit.idProduit)
        check=false;
    }
    if (check) {
      const confirmation = confirm("Are You Sure Wanna Delete The Product");
      if (confirmation) {
        this.deleteProduit();
      }
    }else{
      alert("delete failed .  this product already has a vente")
    }
  }

  //method to add new product
  addProduit(add:NgForm){
    //to force the user to fill all the inputs
    if (add.invalid) {
      alert("Please fill in all the required inputs");
      return;
    }

    alert("new product added successfully");
    let value=add.value;
    let prd={marque:value.marque,description:value.description,prix:value.prix,quantite:value.quantite};
    this.produitsSrv.postProduit(prd)
      .subscribe({
        next:value=>{
          location.reload();
        }
        ,error:err => {console.error(err);}
        })
  }

}
