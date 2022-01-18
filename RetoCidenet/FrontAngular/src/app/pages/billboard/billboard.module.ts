import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BillboardRoutingModule } from './billboard-routing.module';
import { BillboardComponent } from './billboard.component';
import {  MatCardModule } from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatButtonModule} from '@angular/material/button';
import { BookingDiaglogComponent } from 'src/app/shares/booking-diaglog/booking-diaglog.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonToggleModule} from '@angular/material/button-toggle'
import {MatDialogModule} from '@angular/material/dialog';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';





@NgModule({
  declarations: [
    BillboardComponent,
    BookingDiaglogComponent
    
  ],
  imports: [
    CommonModule,
    BillboardRoutingModule,
    MatCardModule,
    MatGridListModule,
    MatButtonModule,
    MatFormFieldModule,
    MatButtonToggleModule,
    MatDialogModule,
    MatSelectModule,
    ReactiveFormsModule,
    FormsModule

  ]
})
export class BillboardModule { }
