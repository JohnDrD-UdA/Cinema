import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MovieIconRoutingModule } from './movie-icon-routing.module';
import { MovieIconComponent } from './movie-icon.component';
import { MatCardModule } from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';


@NgModule({
  declarations: [
    MovieIconComponent
  ],
  imports: [
    CommonModule,
    MovieIconRoutingModule,
    MatCardModule,
    MatButtonModule
  ]
})
export class MovieIconModule { }
