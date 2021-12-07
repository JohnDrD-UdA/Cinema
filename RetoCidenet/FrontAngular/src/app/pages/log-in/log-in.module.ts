import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LogInRoutingModule } from './log-in-routing.module';
import { LogInComponent } from './log-in.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule}  from '@angular/material/select';
import { ReactiveFormsModule , FormsModule} from '@angular/forms';



@NgModule({
  declarations: [
    LogInComponent,
  ],
  imports: [
    CommonModule,
    LogInRoutingModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    FormsModule,
    ReactiveFormsModule,

  


  ]
})
export class LogInModule { }
