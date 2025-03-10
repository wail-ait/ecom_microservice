import {Acheteur} from "./Acheteur.model";
import {Produit} from "./Produit.model";

export interface Vente{
id_Vente : number;
id_Acheteur : number;
id_Produit : number;
quantite : number;
mois : number;
annee : number;
acheteur : Acheteur;
produit : Produit;
}
