import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-quick-links',
  templateUrl: './quick-links.component.html',
  styleUrls: ['./quick-links.component.scss']
})
export class QuickLinksComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  // lend: boolean = false;
  // //borrow: boolean = false;
  // request: Request[] = [];
  

  // ifLend() { 
  //   this.lend = false;
  //   console.log(this.lend); 
  // }
  // ifBorrow() { 
  //   this.lend = true; 
  //   console.log(this.lend); 
  // }
@Output() featureSelected = new EventEmitter<string>();
  onSelect(feature){
    this.featureSelected.emit(feature);
    console.log(feature);
  }


}
