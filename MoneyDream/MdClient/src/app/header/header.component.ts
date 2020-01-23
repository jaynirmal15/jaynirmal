import { Component, OnInit } from '@angular/core';
import { GetWalletService } from '../../service/getWallet.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  amount: number;
  
  
  constructor(private walletService: GetWalletService) { 
    this.walletService = walletService;

  //   let user = JSON.parse(localStorage.getItem("userLogin")).user_id;
  //   console.log(user);
  //   this.walletService.getWallet(user)
  //   .then(
  //     data=>{
  //    var walletDetails = (data);
  //    this.amt = walletDetails.balance;
  //    }     
  // , function(err) {
  //     console.log(err);
  // });
  }
  
  ngOnInit() {    
  }

  balance(){
    
    let userID = JSON.parse(localStorage.getItem("userLogin")).user_id;
    console.log(userID);
    this.walletService.getWallet(userID).then(
      data => {
        var walletDetails = (data);
     this.amount = walletDetails.balance;
  //   console.log("returned promise:" + JSON.stringify(data));

  //   let user = JSON.parse(localStorage.getItem("userLogin")).user_id;
  //   console.log(user);
  //   this.walletService.getWallet(user)
  //   .then(
  //     data=>{
  //    var walletDetails = (data);
  //    this.amount = walletDetails.balance;
  //    }     
  // , function(err) {
  //     console.log(err);
  // });
  
  }
  
    )}

}
  

