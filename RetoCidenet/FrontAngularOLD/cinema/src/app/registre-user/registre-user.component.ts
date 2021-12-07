import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';

@Component({
  selector: 'app-registre-user',
  templateUrl: './registre-user.component.html',
  styleUrls: ['./registre-user.component.scss']
})
export class RegistreUserComponent implements OnInit {

  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }
  registrar(){
    let body={
      userName:"test2",
      password:"1234"

    }
    let respuestaData
    this.userService.crearCliente(body).subscribe(respuesta =>{respuestaData=respuesta;     console.log(respuestaData)})
  }

}
