
import { Component, Inject, InjectionToken, Input, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MovieServiceService } from 'src/app/Service/movie-service.service';
import { Booking } from '../Models/Booking';
import { functionM } from '../Models/Function';
import { Movie } from '../Models/Movie';

@Component({
  selector: 'app-booking-diaglog',
  templateUrl: './booking-diaglog.component.html',
  styleUrls: ['./booking-diaglog.component.scss']

})
export class BookingDiaglogComponent implements OnInit {

  constructor(private movieServ:MovieServiceService,private fb: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data:Movie  ) { }

  bookingForm=this.fb.group({
    Funciones_:[null,Validators.required]
  })
  //variables de la pagina
  test=false
  functions: functionM[] =[]
  bookings: Booking[]| undefined=[]
  cols:number=0
  bookingsMade:Booking[]=[]
  movie:Movie=this.data
  
  ngOnInit(): void {
    console.log(typeof this.movie)
    this.movieServ.getMovieFunction(this.data.id).subscribe({next: functions=>this.functions=functions})



  }
  getCost(){
    return this.bookingsMade.length*8500
  }
  getBookings(){
    console.log("entro")
    let fId=this.bookingForm.get(['Funciones_'])!.value
    if(fId!=null){
      this.movieServ.getBookingsFunction(fId).subscribe({next: bookings=>this.bookings=bookings})
      console.log(this.bookings)
      if (this.functions!=[]){this.cols=this.functions[0].hall.cols}
      console.log(this.cols)
      this.test=true
    }
    
  }
  selectChair(booking:Booking){
    console.log(this.bookingsMade.includes(booking))
    if(booking.customer!=null && !this.bookingsMade.includes(booking) ){return}
    console.log(booking)
    booking.customer={
      id:1,
      userName:"John",
      nombres:"David",
     apellidos:"Rodriguez",
     document:"1",
     docType:"CC",
     Admin:false

    }
    if(!this.bookingsMade.includes(booking)){    this.bookingsMade.push(booking)
      console.log(this.bookingsMade)}
      else{
        console.log(this.bookingsMade.indexOf(booking))
        booking.customer=null

        this.bookingsMade.splice(this.bookingsMade.indexOf(booking),1)
        console.log(this.bookingsMade)}

  }
  bookEveryChair(){
    this.movieServ.book(this.bookingsMade).subscribe(response=>{
      if(response.status===200){
        console.log("Exito!")
      }
      else{console.log("Error"+response.body?.status)}})
  }

}

