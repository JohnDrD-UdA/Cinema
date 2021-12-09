import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Cinema Cidenet';
  getUrl()
  { return "url('assets/Img/pexels-tima-miroshnichenko-7991178.jpg')"
  }
}

