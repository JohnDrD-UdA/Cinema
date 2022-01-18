
import { ChangeDetectorRef, Component, ElementRef, OnInit, ViewChild,Inject } from '@angular/core';
import { MovieServiceService } from 'src/app/Service/movie-service.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Movie } from 'src/app/shares/Models/Movie';
import { BookingDiaglogComponent } from 'src/app/shares/booking-diaglog/booking-diaglog.component';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthInterceptorService } from 'src/app/Service/auth-interceptor.service';



@Component({
  selector: 'app-billboard',
  templateUrl: './billboard.component.html',
  styleUrls: ['./billboard.component.scss']
})

export class BillboardComponent implements OnInit {

  constructor(private movieServ:MovieServiceService,public dialog:MatDialog,private testServ:AuthInterceptorService) {
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
 reservar(test:Movie){
   console.log(test.id)
   this.openDialog(test)


 }
 openDialog(test2:Movie)
 {
   console.log(test2)
    this.dialog.open(BookingDiaglogComponent,
      {width:'700px',
    height:'75%',
    data: test2
})
 }




}
