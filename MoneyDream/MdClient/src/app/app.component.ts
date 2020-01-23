import { Component, Output } from '@angular/core';
import { EventEmitter } from 'protractor';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  featureSelected = 'lend';
  login: boolean = true;

  // onNavigate(feature: string){
  //  this.featureSelected = feature;
  //  } 

  //  @Output() redirectPage = new EventEmitter<any>();
  //     redirect(redirect){
  //       this.redirectPage.emit(redirect);
  //     }

  redirectPage: string;

}
