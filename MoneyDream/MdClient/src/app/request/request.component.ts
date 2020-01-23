import { Component, OnInit, Input } from '@angular/core';
import { Transaction } from '../../model/transactionModel';


@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.scss']
})
export class RequestComponent implements OnInit {

  constructor() { }
   
  ngOnInit() {
  }
  
  transactions: Transaction[]=[];

  borrowTransaction: Transaction[] = [];

  onItemAdded(transaction: Transaction){

    this.transactions.push(transaction);

  }
  // onBorrowRequest(transaction: Transaction){
  //   this.transactions.push(transaction);
  // }
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

  // toggle: boolean = true;

  // onToggle(event: string) {
  //   console.log("i am here");
  //   console.log(event);
  //   if (event === 'lend Money') { 
  //     console.log(this.lend);
  //     this.toggle = true;
  //   }
  //   else {
  //     console.log(this.borrow);
  //     this.toggle = false;
  // }
  // }
  request = 'lend';
  @Input() feature: string;

}
