import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BannerComponent } from './shares/banner/banner.component';
import { FooterInfoComponent } from './shares/footer-info/footer-info.component';
import { MaterialModule } from './material.module';
import { MovieIconModule } from './shares/movie-icon/movie-icon.module';

@NgModule({
  declarations: [
    AppComponent,
    BannerComponent,
    FooterInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    MovieIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
