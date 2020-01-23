import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { User } from './../model/userModel';
import { Router, ActivatedRoute } from '@angular/router';
import { Transaction } from '../model/transactionModel';
const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };
@Injectable()
export class TransactionBorrowerSerivce {
    lenderListURL = 'http://localhost:3000/lenderList';
    borrowerListURL = 'http://localhost:3000/borrowerList';
    transactionURL ='http://localhost:3000/createTransaction';
    getUserByIdURL = 'http://localhost:3000/getUserById';
    getTransactionHistoryURL = 'http://localhost:3000/getTransactionsHistory';
    getUserDetailsByNameURL =  'http://localhost:3000/login';
    constructor(private http: HttpClient) {
    }
    getLendersList(search:String) {
        // tslint:disable-next-line:prefer-const
        // let sp = new SearchProductByName(search);
        // console.log("A "+search)
        // let promise = new Promise((resolve, reject) => {
        //   this.http
        //   .get(this.borrowerURL,httpOptions)
        //   .subscribe(data => {
        //     resolve(data);
        //     console.log("fr "+JSON.stringify(data))
        //   },
        //   error => {
        //     alert("No results found!");
        //   });
        // });
        // return promise;

        return new Promise((resolve, reject) => {

      });
    }

    getBorrowerHistory(user_id: string) : Promise<any>{

      let promise = new Promise((resolve, reject) => {
          this.http
          .post<Array<Transaction>>(this.getTransactionHistoryURL,{user_id : user_id})
          .subscribe(data => {
            resolve(data);
          },
          error => {
            reject(error);
            alert("Error while creating a borrow request");
          });
        });
        return promise;
    }


    sendBorrowerTransaction(transaction: Transaction) : Promise<any>{

        let promise = new Promise((resolve, reject) => {
            this.http
            .post(this.transactionURL,{borrower_id : transaction.borrower_id,lender_id :transaction.lender_id,amount : transaction.amount,status : transaction.status,transactionDate : transaction.transactionDate},httpOptions)
            .subscribe(data => {
              resolve(data);
            },
            error => {
              reject(error);
              alert("Error while creating a borrow request");
            });
          });
          return promise;
    }

    sendLenderTransaction(transaction: Transaction) : Promise<any>{

      let promise = new Promise((resolve, reject) => {
          this.http
          .post(this.transactionURL,{borrower_id : transaction.borrower_id,lender_id :transaction.lender_id,amount : transaction.amount,status : transaction.status,transactionDate : transaction.transactionDate},httpOptions)
          .subscribe(data => {
            resolve(data);
          },
          error => {
            reject(error);
            alert("Error while creating a borrow request");
          });
        });
        return promise;
  }


    findExistingUser(user_id: string) : Promise<any>{

      let promise = new Promise((resolve, reject) => {
          this.http
          .post(this.getUserByIdURL,{id : user_id})
          .subscribe(data => {
            resolve(data);
          },
          error => {
            reject(error);
            alert("lender not found");
          });
        });
        return promise;


  }

  getUserDetailsByName(userName: string) : Promise<any>{

    let promise = new Promise((resolve, reject) => {
        this.http
        .post<User>(this.getUserDetailsByNameURL,{userName : userName})
        .subscribe(data => {
          console.log(JSON.stringify(data));
          resolve(data);
        },
        error => {
          reject(error);
          alert("lender not found");
        });
      });

      return promise;


}

}

