import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map, tap } from 'rxjs/operators';
import { Booking } from '../shares/Models/Booking';
import { functionM } from '../shares/Models/Function';
import { IResponseReg } from '../shares/Models/IResponseReg';
import { Movie } from '../shares/Models/Movie';


type EntityResposeReg= HttpResponse<IResponseReg>;
@Injectable({
  providedIn: 'root'
})
export class MovieServiceService {

  constructor(private http: HttpClient) { }

  getAllMovies(){
    
    return this.http.get<Movie[]>('http://localhost:8080/movie/getAllMovies').pipe(tap(data=>console.log('All: ' +JSON.stringify(data) )))

  }
  protected convertDateFromServerLogin(res: EntityResposeReg): EntityResposeReg {
    return res;
  }
  getMovieFunction(movie:number)
  {  let  url='http://localhost:8080/FunctionM/QueryAllFunctions/'
  url=url+movie
  console.log(url)
    return this.http.get<functionM[]>(url).pipe(tap(data=>console.log('All: ' +JSON.stringify(data))))

  }
  getBookingsFunction(functionM:number)
  {  let  url='http://localhost:8080/Booking/QueryAllAvalible/'
  url=url+functionM
  console.log(url)
    return this.http.get<Booking[]>(url).pipe(tap(data=>console.log("Done")))

  }
  book(request:Booking[]){
    return this.http.post<IResponseReg>('http://localhost:8080/Booking/UpdateBooking',request,{observe:'response'})
    .pipe(map((res:EntityResposeReg)=> this.convertDateFromServerLogin(res)));
  }

}
