import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Vente} from "../../../Moduls/Vente.model";

@Injectable({
  providedIn: 'root'
})
export class VentesSrv {

  constructor(private http:HttpClient) { }

  //method to get all the ventes
  getAllVentes(){
    return this.http.get<Array<Vente>>("http://192.168.99.100:8888/VENTE-SERVICE/ventes");
  }

  //method to update a specific vente
  putVente(id:number,vente:any){
    return this.http.put(`http://192.168.99.100:8888/VENTE-SERVICE/ventes/${id}`,vente);
  }

  //method to add a new vente
  postVente(vente:any){
    return this.http.post("http://192.168.99.100:8888/VENTE-SERVICE/ventes",vente);
  }

  //method to delete a specific vente
  deleteVente(id:number){
    return this.http.delete(`http://192.168.99.100:8888/VENTE-SERVICE/ventes/${id}`);
  }
}
