import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { FooterInfoComponent } from './shares/footer-info/footer-info.component';
import { MaterialModule } from './material.module';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptorService } from './Service/auth-interceptor.service';


@NgModule({
  declarations: [
    AppComponent,
    FooterInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
 
  ],
  providers: [
    {provide:HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
