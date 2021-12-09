import { NONE_TYPE } from '@angular/compiler';
import { ChangeDetectorRef, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { waitForAsync } from '@angular/core/testing';
import { CheckboxControlValueAccessor } from '@angular/forms';
import { MovieServiceService } from 'src/app/Service/movie-service.service';
import { Movie } from 'src/app/shares/Models/Movie';

@Component({
  selector: 'app-billboard',
  templateUrl: './billboard.component.html',
  styleUrls: ['./billboard.component.scss']
})

export class BillboardComponent implements OnInit {

  constructor(private movieServ:MovieServiceService) {
  }




  movies :Movie[] |undefined=[]
  arrayready:boolean =false
  breakpoint=0
  
  ngOnInit() {
    console.log("Entro")
    this.movieServ.getAllMovies().subscribe( {next: movies=>this.movies=movies})
    console.log(this.movies)
    this.arrayready=true
    this.breakpoint = (window.innerWidth <= 400) ? 1 : 3;
    
}

onResize(event:any) {
  this.breakpoint = (event.target.innerWidth <= 400) ? 1 : 3;
}

}



