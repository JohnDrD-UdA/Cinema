import { RepositionScrollStrategy } from '@angular/cdk/overlay';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LogInServiceService } from 'src/app/Service/log-in-service.service';
import { IRequestAulth } from 'src/app/shares/Models/IResquestAulth';


@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})
export class LogInComponent implements OnInit {

  constructor(private fb: FormBuilder, private lgService:LogInServiceService, private router:Router) { 
  
  }
  CineTest='cidenetlogo.png';
  loguinForm=this.fb.group({
    mail: [null,[Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
    contrasena: [null,[Validators.required, Validators.minLength(7)]]

  });

  ngOnInit(): void {
  }
  autenticar(){
    console.log("Entro")
    console.log(this.loguinForm.get(['mail'])!.value)
    console.log(this.loguinForm.get(['contrasena'])!.value)
    const LOGDATA:IRequestAulth={ 
      userName: this.loguinForm.get(['mail'])!.value,
      password: this.loguinForm.get(['contrasena'])!.value
    }
    this.lgService.logIn(LOGDATA).subscribe(response=>{
      if(response.status===200){
        console.log("Exito!"+response.body?.token)
        localStorage.setItem('Token',response.body?.token+"")
        this.router.navigate(['home'])

      }
      else{console.log("Error"+response.body?.status)}
        
    })

  }
getUrl(){
  return "url('assets/Img/stockvault-empty-movie-theater-with-red-seats-cinem168512.jpg')"
}
goTo(url:string){
  window.open(url,"_blank",'location=yes,height=1300,width=657,scrollbars=yes,status=yes');
}
}
