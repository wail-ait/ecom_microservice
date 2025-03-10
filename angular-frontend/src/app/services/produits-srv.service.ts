import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Produit} from "../../../Moduls/Produit.model";

@Injectable({
  providedIn: 'root'
})
export class ProduitsSrv {

  constructor(private http:HttpClient) { }

  //method to get all the products
  getAllProducts(){
    return this.http.get<Array<Produit>>("http://192.168.99.100:8888/PRODUIT-SERVICE/produits");
  }

  //method to update a specific product
  putProduit(id:number,produit:any){
    return this.http.put<Produit>(`http://192.168.99.100:8888/PRODUIT-SERVICE/produits/${id}`,produit);
  }

  //method to add new produit
  postProduit(produit:any){
    return this.http.post("http://192.168.99.100:8888/PRODUIT-SERVICE/produits",produit);
  }

  //method to delete an existing product
  deleteProduit(id:number){
    return this.http.delete(`http://192.168.99.100:8888/PRODUIT-SERVICE/produits/${id}`)
  }
}
