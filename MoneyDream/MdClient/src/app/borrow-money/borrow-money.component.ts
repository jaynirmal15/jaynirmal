import { Component, OnInit, Input, Output, EventEmitter, ViewChild, ElementRef } from '@angular/core';
import { TransactionBorrowerSerivce } from '../../service/transactionborrower.service'
import { Transaction } from '../../model/transactionModel';

@Component({
  selector: 'app-borrow-money',
  templateUrl: './borrow-money.component.html',
  styleUrls: ['./borrow-money.component.scss']
})
export class BorrowMoneyComponent implements OnInit {

  lenderName: string = '';
  amt: number = undefined;
  lenderID :any;
  @ViewChild('amount') amountInput: ElementRef;
  //transaction: Transaction;
  @Output() requestBorrow = new EventEmitter<Transaction>();
  constructor(private transactionBorrowerService: TransactionBorrowerSerivce) {
    this.transactionBorrowerService = transactionBorrowerService;
  }
  @Input() borrowers;

  ngOnInit() {
    let borrower: String = "";
    this.transactionBorrowerService.getLendersList(borrower).then( /*product assignment*/
      borrow => {
        console.log(borrow);
        this.borrowers = borrow;

        // searchFound = true;
      }
    );
  }
  createRequest() {

    let userID = JSON.parse(localStorage.getItem("userLogin")).user_id;

    if (this.lenderName == '' || this.amt == 0) {
      alert("Please select lenderName/amount");
    }
    else {
      this.transactionBorrowerService.getUserDetailsByName(this.lenderName).then(
        data => {

          this.lenderID = data;
          console.log(this.lenderID.user_id);

          const newTransaction = new Transaction(userID, this.lenderID.user_id, this.amt, "REQUESTED", new Date);
          this.requestBorrow.emit(newTransaction);
          console.log(newTransaction);

          this.transactionBorrowerService.sendBorrowerTransaction(newTransaction).then(
            send => {
              alert("Product added successfully");
            }
          );
        }
      )
    }
  }

  @Input() feature: string;

}
