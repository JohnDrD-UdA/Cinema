import { HttpErrorResponse, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor{
  
  constructor(private router:Router) { }
 
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token:string|null=localStorage.getItem('Token');

    let request=req;
    if(token){
      request=req.clone({
        headers: new HttpHeaders({
          'Content-Type':  'application/json',
          'Authorization': token
        })
      });

    }
    //alert("Entro al intercepto")
    return next.handle(request).pipe(
      catchError((err:HttpErrorResponse)=>{
        if(err.status===401){this.router.navigateByUrl('/LogIn');}
        //alert("redirecciona")
        return throwError(err);
      }
      
      )
    );
  }
}
