import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  backGroundPhoto= 'BackgroundPhoto.jpg';

  constructor() { }

  ngOnInit(): void {
  }
  getUrl()
  { return "url('assets/Img/BackgroundPhoto.jpg')"
  }
}
