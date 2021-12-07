import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule}  from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { RegistreRoutingModule } from './registre-routing.module';
import { RegistreComponent } from './registre.component';
import { ReactiveFormsModule , FormsModule} from '@angular/forms';



@NgModule({
  declarations: [
    RegistreComponent
  ],
  imports: [
    CommonModule,
    RegistreRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatIconModule,

  ]
})
export class RegistreModule { }
