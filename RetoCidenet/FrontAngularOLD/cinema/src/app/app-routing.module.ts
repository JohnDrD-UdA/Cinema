import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegistreUserComponent} from './registre-user/registre-user.component'

const routes: Routes = [
  {path:'registre',component:RegistreUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
