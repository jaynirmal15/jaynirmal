import { Injectable } from "@angular/core";
import { Observable } from "rxjs/observable";
import { Reg } from "../model/regModel";
import { HttpClient } from "@angular/common/http";
import { IfObservable } from "rxjs/observable/IfObservable";
import { promise } from "protractor";

@Injectable()
export class UserService {

    searchURL: string = 'http://localhost:3000/searchUsers' ;
    
    constructor(private http: HttpClient) { 
    }

    getUsers(searchCriteria:string) : Promise<any>{
        let promise = new Promise((resolve, reject) => {
            this.http.post<any>(this.searchURL,{searchParam:searchCriteria})
            .subscribe(data => {
      
              console.log("Search results"+JSON.stringify(data));
            //   if(data){
            //     this.router.navigate(['/dashboard']),
            //       localStorage.setItem('userLogin',JSON.stringify(data));
            //     resolve(data);
            //   }else{
            //     //this.router.navigate(['/']);
            //     reject('Invalid Username and Password!');
            //   }
      
            },
            error => {
              //this.router.navigate(['/']),
              reject(error);
            });  
        });
        return promise;
    }
         
}