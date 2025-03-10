import { Routes } from '@angular/router';
import {AcheteurComponent} from "./acheteur/acheteur.component";
import {ProduitComponent} from "./produit/produit.component";
import {VenteComponent} from "./vente/vente.component";

export const routes: Routes = [
  {path : "acheteurs" , component : AcheteurComponent},
  {path : "produits" , component : ProduitComponent},
  {path : "ventes" , component : VenteComponent},
];
