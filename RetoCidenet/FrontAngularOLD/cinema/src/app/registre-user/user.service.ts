import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }
  private heads:HttpHeaders=new HttpHeaders({'Content-Type':'application/json'})
  public crearCliente(usuario:any): Observable<string>{
    return this.http.post<string>('http://localhost:8080/user/create',usuario, {headers: this.heads})
  }
  }
