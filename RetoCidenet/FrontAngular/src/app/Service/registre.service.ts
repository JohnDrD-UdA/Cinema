import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { IRequestReg } from '../shares/Models/IRequestReg';
import { IResponseReg } from '../shares/Models/IResponseReg';


type EntityResposeReg= HttpResponse<IResponseReg>;
@Injectable({
  providedIn: 'root'
})

export class RegistreService {

  constructor(private http: HttpClient) { }

  reg(resquest?:IRequestReg):Observable<EntityResposeReg>{
    
    return this.http.post<IResponseReg>('http://localhost:8080/customer/crearCustomer',resquest,{observe:'response'})
    .pipe(map((res:EntityResposeReg)=> this.convertDateFromServerLogin(res)));

  }
  protected convertDateFromServerLogin(res: EntityResposeReg): EntityResposeReg {
    return res;
  }

}
