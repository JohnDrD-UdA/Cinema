import { NgModule } from "@angular/core";
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatListModule} from '@angular/material/list';
import {MatSidenavModule} from '@angular/material/sidenav';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule}  from '@angular/material/select';
import { HttpClientModule , HTTP_INTERCEPTORS} from '@angular/common/http'

const myModules=[MatCardModule,MatToolbarModule,MatIconModule,
    MatButtonModule,MatGridListModule,MatListModule,MatSidenavModule,
    MatFormFieldModule,MatInputModule,MatSelectModule,HttpClientModule
    
];
@NgModule({
    imports: [... myModules],
    exports: [... myModules]
})
export class MaterialModule {}