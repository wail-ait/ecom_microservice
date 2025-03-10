import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Acheteur} from "../../../Moduls/Acheteur.model";

@Injectable({
  providedIn: 'root'
})
export class AcheteursSrv {

  constructor(private http:HttpClient) { }

  //methode to get all acheteurs
  getAllAcheteurs(){
    return this.http.get<Array<Acheteur>>('http://192.168.99.100:8888/ACHETEUR-SERVICE/acheteurs');
  }

  //method to get acheteur byId
  getAcheteurById(id:number){
    return this.http.get('http://192.168.99.100:8888/ACHETEUR-SERVICE/acheteurs/${id}')
  }

  //method to update the attributs of an acheteur
  putAcheteur(id:number,acheteur:any){
    return this.http.put<Acheteur>(`http://192.168.99.100:8888/ACHETEUR-SERVICE/acheteurs/${id}`,acheteur);
  }

  //methode to add new acheteur
  postAcheteur(acheteur:any){
    return this.http.post<Acheteur>('http://192.168.99.100:8888/ACHETEUR-SERVICE/acheteurs',acheteur);
  }

  //method to delete an acheteur by his id
  deleteAcheteur(id:number){
    return this.http.delete(`http://192.168.99.100:8888/ACHETEUR-SERVICE/acheteurs/${id}`);
  }
}
