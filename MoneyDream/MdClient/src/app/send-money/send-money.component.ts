import {TransactionBorrowerSerivce} from '../../service/transactionborrower.service'
import {GetWalletService} from '../../service/getWallet.service'
import { Component, OnInit,ViewChild,ElementRef,Output,EventEmitter, Input} from '@angular/core';
import { Transaction } from '../../model/transactionModel';
import {AddMoneyToWallet} from '../../service/addMoneyToWallet.service';

@Component({
  selector: 'app-send-money',
  templateUrl: './send-money.component.html',
  styleUrls: ['./send-money.component.scss']
})
export class SendMoneyComponent implements OnInit {

  
  name: string;
  amount: number;
  @Output() requestBorrow = new EventEmitter<Transaction>();
  constructor(private transactionBorrowerService: TransactionBorrowerSerivce,
     private addMoneyToWallet: AddMoneyToWallet,private getWallet: GetWalletService) {
    this.transactionBorrowerService = transactionBorrowerService;
    this.addMoneyToWallet = addMoneyToWallet;
    this.getWallet = getWallet;
  }
  //@Output() requestEvent = new EventEmitter<Transaction>();
  ngOnInit() {
    
  }

  addRequest(){
    
  let userID = JSON.parse(localStorage.getItem("userLogin")).userName;
  
    if (this.name == '' ||  this.amount == 0) {
      alert("Please select lenderName/amount");
    }
    else {
      const newTransaction = new Transaction(this.name,userID,this.amount,"COMPLETED",new Date);
   
      this.requestBorrow.emit(newTransaction);
      console.log(this.name,this.amount);
    if(this.transactionBorrowerService.findExistingUser(newTransaction.borrower_id))
    {
       this.transactionBorrowerService.sendLenderTransaction(newTransaction);
       //this.getWallet.getWallet()


    }
      
     
    }
  }

  @Input() feature: string;
}
