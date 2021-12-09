import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movie-icon',
  templateUrl: './movie-icon.component.html',
  styleUrls: ['./movie-icon.component.scss']
})
export class MovieIconComponent implements OnInit {


  constructor() {}
  title="";
 sumary=""
 gendre="";
 lenght="";
 Formats="";
 poster="";


  ngOnInit(): void {
  }
  setSumary(textvar:string){
    this.sumary=textvar
  }
  getSumary(){
  return this.sumary
  }
  setGendre(textvar:string){
    this.gendre=textvar
  }
  getgendre(){
  return this.gendre
  }

  setLenght(textvar:string){
    this.lenght=textvar
  }
  getLenght(){
    return this.lenght
    }

setFormats(textvar:string){
  this.lenght=textvar
}
getFormats(){
  return this.Formats
  }
setposter(textvar:string){
  this.lenght=textvar
  }
getposter(){
  return this.Formats
  }
}