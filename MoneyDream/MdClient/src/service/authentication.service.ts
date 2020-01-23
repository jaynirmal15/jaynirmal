import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { User } from './../model/userModel';
import { Router, ActivatedRoute } from '@angular/router';
@Injectable()

export class AuthenticationService {
  loginURL = 'http://localhost:3000/validateUser';
  //regURL ='http://localhost:3000/registration';
  constructor(private http: HttpClient,    private route: ActivatedRoute,
    private router: Router) {
  }

  login(userName: string, password: string): Promise<any> {
    // tslint:disable-next-line:prefer-const
    // let user_1 = user ? user : new User("", ""),
    let promise = new Promise((resolve, reject) => {
      this.http.post<any>(this.loginURL,{ userName: userName, password: password })
      .subscribe(data => {

        console.log("auth service"+data);
        if(data){
          this.router.navigate(['/dashboard']),
            localStorage.setItem('userLogin',JSON.stringify(data));
          resolve(data);
        }else{
          //this.router.navigate(['/']);
          reject('Invalid Username and Password!');
        }

      },
      error => {
        this.router.navigate(['/']),
        reject(error);
      });
    });
    return promise;
  }

  logout(){
    localStorage.removeItem('userLogin');
  }

  // getUsers(){
  //   let promise = new Promise((resolve, reject) => {
  //     this.http.get<Array<User>>(this.loginURL)
  //     .subscribe(data => {
  //       resolve(data);
  //       console.log("all users:"+data);
  //     },
  //     error => {
  //       this.router.navigate(['/']),
  //       reject(error);
  //     });
  //   });
  //   return promise;
  // }



}


