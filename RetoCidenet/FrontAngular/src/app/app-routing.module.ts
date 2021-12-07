import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
{path:'', redirectTo:'home',pathMatch:'full'},
  { path: 'home', loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule) }, 
{ path: 'NotFound', loadChildren: () => import('./pages/not-found/not-found.module').then(m => m.NotFoundModule) }, 
{ path: 'LogIn', loadChildren: () => import('./pages/log-in/log-in.module').then(m => m.LogInModule) }, 
{ path: 'registre', loadChildren: () => import('./pages/registre/registre.module').then(m => m.RegistreModule) },
{ path: 'movieicon', loadChildren: () => import('./shares/movie-icon/movie-icon.module').then(m => m.MovieIconModule) },
{ path: 'billboard', loadChildren: () => import('./pages/billboard/billboard.module').then(m => m.BillboardModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
