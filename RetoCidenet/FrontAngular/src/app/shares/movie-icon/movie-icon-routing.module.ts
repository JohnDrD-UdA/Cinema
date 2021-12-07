import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieIconComponent } from './movie-icon.component';

const routes: Routes = [{ path: '', component: MovieIconComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MovieIconRoutingModule { }
