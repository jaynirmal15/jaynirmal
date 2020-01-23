import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  redirectPage: string;

  onNavigate(feature: string){
    console.log(feature);
    this.redirectPage = feature;
    console.log(this.redirectPage);
    } 

}
