import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ReactiveFormsModule , FormsModule} from '@angular/forms';
import { RegistreService } from 'src/app/Service/registre.service';
import { IRequestReg } from 'src/app/shares/Models/IRequestReg';
import { IRequestAulth } from 'src/app/shares/Models/IResquestAulth';
import { LogInServiceService } from 'src/app/Service/log-in-service.service';

@Component({
  selector: 'app-registre',
  templateUrl: './registre.component.html',
  styleUrls: ['./registre.component.scss']
})
export class RegistreComponent implements OnInit {

  constructor(private fb: FormBuilder, private regService:RegistreService,private lgService:LogInServiceService, private router:Router) { }
  CineTest='cidenetlogo.png';
  hide=true;
  hide2=true;
  registreForm=this.fb.group({
    mail: [null,[Validators.required, Validators.pattern("^[a-z0-9A-Z._%+-]+@[a-z0-9A-Z.-]+\\.[a-z]{2,4}$")]],
    contrasena: [null,[Validators.required, Validators.minLength(7), customCheck(/(?=.*[0-9]{1})$/),customCheck(/(?=.*[a-z]{1})$/),customCheck(/(?=.*[A-Z]{1})$/)  ]],
    Ccontrasena:[null,Validators.required],
    Doc:[null,[Validators.required,Validators.minLength(5)]],
    lastnames:[null,Validators.required],
    names:[null,Validators.required],
    DocType: [null,Validators.required]


  }, {validator: this.checkPasswords('contrasena','Ccontrasena')});
  ngOnInit(): void {
}

  registrar(){
    console.log("Ingreso")
    if(this.registreForm.get(['contrasena'])!.value===this.registreForm.get(['Ccontrasena'])!.value){
    const REGDATA: IRequestReg={
      userName: this.registreForm.get(['mail'])!.value,
      nombres: this.registreForm.get(['names'])!.value,
     apellidos: this.registreForm.get(['lastnames'])!.value,
     document: this.registreForm.get(['Doc'])!.value,
     docType: this.registreForm.get(['DocType'])!.value,
     Admin: false
    }
    const USERDAT: IRequestAulth={
      userName: this.registreForm.get(['mail'])!.value,
      password: this.registreForm.get(['contrasena'])!.value
    }
    this.regService.reg(REGDATA).subscribe(response=>{
      if(response.status===200){
        console.log("Exito!")
        this.router.navigate(['home'])


      }
      else{console.log("Error"+response.body?.status)}
        
    })
    this.lgService.createUser(USERDAT).subscribe(response=>{
      if(response.status===200){
        console.log("Exito!")

      }
      else{console.log("Error"+response.body?.status)}
        
    })}
    else{console.log("Las contraseñas no coinciden")}
  }
  checkPasswords(passwordKey: string, passwordConfirmationKey: string) {
    return (group: FormGroup) => {
      let passwordInput = group.controls[passwordKey],
          passwordConfirmationInput = group.controls[passwordConfirmationKey];
      if (passwordInput.value !== passwordConfirmationInput.value) {
        return passwordConfirmationInput.setErrors({notEquivalent: true})
      }
      else {
          return passwordConfirmationInput.setErrors(null);
      }
    }
  }
}

export function customCheck(nameRe: RegExp): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const forbidden = nameRe.test(control.value);
    return forbidden ? {forbiddenName: {value: control.value}} : null;
  };
}