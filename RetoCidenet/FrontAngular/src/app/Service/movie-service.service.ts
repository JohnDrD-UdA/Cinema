import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map, tap } from 'rxjs/operators';
import { IResponseListDTO } from '../shares/Models/IResponseList';
import { Movie } from '../shares/Models/Movie';


type EntityResposeReg= HttpResponse<IResponseListDTO>;
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
}
