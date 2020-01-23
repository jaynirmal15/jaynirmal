import { Component, OnInit } from '@angular/core';
import {AddMoneyToWallet} from '../../service/addMoneyToWallet.service';
import {GetWalletService} from '../../service/getWallet.service';
import { Wallet } from '../../model/wallet';

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})

export class WalletComponent implements OnInit {
  wallet : Wallet;
  amount : number ;

  constructor(private addMoneyToWallet : AddMoneyToWallet,private walletService : GetWalletService) { }

  ngOnInit() {
  }

  addMoney(){

    let user = JSON.parse(localStorage.getItem("userLogin")).user_id;
    
    console.log(user);
    this.walletService.getWallet(user)
    .then(
      data=>{
     this.wallet = (data);
     
    console.log(this.wallet);
    this.addMoneyToWallet.addMoney(this.wallet,this.amount);

    // console.log(Number(this.wallet.balance));  
    }     
  , function(err) {
      console.log(err);
    });
    

  }


}
