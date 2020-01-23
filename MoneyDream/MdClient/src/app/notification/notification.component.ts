import { Component, OnInit, Input } from '@angular/core';
import { Transaction } from '../../model/transactionModel';
import {TransactionBorrowerSerivce} from '../../service/transactionborrower.service'

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.scss']
})
export class NotificationComponent implements OnInit {

  @Input() feature: string;
  //@Input() tran: Transaction[];
  tranc: Transaction[] = [];

  constructor(private transactionBorrowerService : TransactionBorrowerSerivce) {
    this.transactionBorrowerService = transactionBorrowerService;
   }

  ngOnInit() {
    console.log("user_id" + JSON.parse(localStorage.getItem('userLogin')).user_id );
    this.transactionBorrowerService.getBorrowerHistory(JSON.parse(localStorage.getItem('userLogin')).user_id).then
    (
      data => {

        this.tranc = (data);

        for(let transaction of this.tranc){

          let lender = transaction.lender_id;
          let borrower = transaction.borrower_id;
          //console.log(lender);
          console.log(borrower);
          console.log(this.tranc);
          this.transactionBorrowerService.findExistingUser(lender).then(
            data=>{
              transaction.lender_id = data.firstName + " " + data.lastName;
            }
          );
          this.transactionBorrowerService.findExistingUser(borrower).then(
            data=>{
              transaction.borrower_id = data.firstName + " " + data.lastName;
              //console.log(transaction);
              this.tranc.push(transaction);
              console.log(data.firstName);
              //console.log(this.tranc);
            }
          );

        }

      }
    )

  }

}
