import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { IRequestAulth } from '../shares/Models/IResquestAulth';
import { IResposeAulth } from '../shares/Models/IResponseAulth';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { IResponseReg } from '../shares/Models/IResponseReg';

type EntityResposeLogIn= HttpResponse<IResposeAulth>;
type EntityResponseReg=HttpResponse<IResponseReg>;

@Injectable({
  providedIn: 'root'
})
export class LogInServiceService {

  constructor(private http:HttpClient) { }


  logIn(resquest?:IRequestAulth):Observable<EntityResposeLogIn>{
    
    return this.http.post<IResposeAulth>('http://localhost:8080/security/autentication',resquest,{observe:'response'})
    .pipe(map((res:EntityResposeLogIn)=> this.convertDateFromServerLogin(res)));

  }
  protected convertDateFromServerLogin(res: EntityResposeLogIn): EntityResposeLogIn {
    return res;
  }
  createUser(resquest?:IRequestAulth):Observable<EntityResponseReg>{
    
    return this.http.post<IResposeAulth>('http://localhost:8080/user/crearUser',resquest,{observe:'response'})
    .pipe(map((res:EntityResposeLogIn)=> this.convertDateFromServerLogin(res)));

  }
}
