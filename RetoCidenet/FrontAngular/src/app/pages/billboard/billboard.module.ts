import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BillboardRoutingModule } from './billboard-routing.module';
import { BillboardComponent } from './billboard.component';


@NgModule({
  declarations: [
    BillboardComponent
  ],
  imports: [
    CommonModule,
    BillboardRoutingModule
  ]
})
export class BillboardModule { }
