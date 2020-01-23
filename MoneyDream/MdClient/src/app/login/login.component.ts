import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { FormControl, FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import 'rxjs/add/operator/finally';
import { User } from '../../model/userModel';
import { Wallet } from '../../model/wallet';
import { UserLogin } from '../../model/userLogin';
import { Reg } from '../../model/regModel';
import { AuthenticationService } from '../../service/authentication.service';
import {RegistrationService } from '../../service/register.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  //public user: User[];
  user: User[] = [
    new User('1', '1'),
    new User('2', '1'),
    new User('3', '1'),
    new User('4', '1'),
    new User('5', '1')
  ];
  username: string;
  login = true;

  /***
   * DO Not change or Remove below variables. They are used for Login functionalities
   */
  userForm: FormGroup;
  regForm: FormGroup;

  //Login Form handling variable
  userLogin: User;

  //Registration Form handling variable
  userReg: Reg;
  newUserLogin: UserLogin;
  userWallet: Wallet;

  /***
   * DO Not change or Remove below variables. They are used for Login functionalities
   */


  constructor(private route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder,
              private authService: AuthenticationService, private regService: RegistrationService) {
    this.authService = authService;
    this.regService = regService;
    this.createForm();
    this.createUserRegistrationForm();
  }

  ngOnInit() {
    this.resetLoginForm();
    console.log("Inside On Init");
  }
  // Initialize Login Form
  createForm() {
    this.userForm = this.fb.group({
      username: '',
      password: ''
    });
  }

  // Initialize User Registration Form
  createUserRegistrationForm() {
    this.regForm = this.fb.group({
      firstName: '',
      lastName: '',
      emailAddress: '',
      userName:'',
      npassword:'',
      cpassword:'',
      street: '',
      aptNo: '',
      city: '',
      state: '',
      country:'',
      zipcode: '',
    });
  }
//Submit action handler for Login Form
  onSubmit(){
    this.userLogin = this.prepareSaveUser();
    console.log(this.userLogin);
    if (this.userLogin) {
      this.authService.login(this.userLogin.username,this.userLogin.password).then(
        data => console.log("returned promise:" + JSON.stringify(data)),
        reason => {
          console.log(reason);
          this.resetLoginForm();

        }
        //this.router.navigate([this.returnUrl])
      );
    }
  }


//Submit action handler for registration form
  onSubmit2(){
    this.userReg = this.prepareSaveReg();
    this.newUserLogin = this.prepareSaveLogin();
    this.userWallet = this.prepareSaveWallet();

    //console.log("User Data is:" + this.userReg.address.aptNo +" "+this.userReg.address.country);
    //console.log("Login Data is:" + this.newUserLogin);
    //console.log("Wallet Data is:" + this.userWallet);
    if (this.userReg) {
      this.regService.register(this.userReg).then(
        user => {console.log("returned  user promise:" + JSON.stringify(user));
          console.log("returned user Data"+ user._id);

          if (this.newUserLogin) {
            this.newUserLogin.user_id = user._id;
            this.regService.createnewUserLogin(this.newUserLogin).then(
              login => {
                console.log("returned login promise:" + JSON.stringify(login));
                if (this.userWallet) {
                  this.userWallet.user_id = user._id;
                  this.regService.createNewUserWallet(this.userWallet).then(
                    login => {console.log("returned wallet promise:" + JSON.stringify(login));
                      this.regForm.reset();
                      this.router.navigate(['/']);},
                    reason => {
                      console.log(reason);

                    }
                    //this.router.navigate([this.returnUrl])
                  );
                }},
              reason => {
                console.log(reason);
              }
              //this.router.navigate([this.returnUrl])
            );
          }
        },

        reason => {
          console.log("New User Object Creation Failed"+ reason);
          this.resetLoginForm();

        }
        //this.router.navigate([this.returnUrl])
      );
    }
  }


//populate Data from Login form into User model to send it to server for validation
  prepareSaveUser(): User {
    const formModel = this.userForm.value;
    console.log(formModel);
    console.log("inside prepare model");

    const saveUser: User = {
      username: formModel.username as string,
      password: formModel.password as string
    };
    return saveUser;
  }
//populate Data from Registration form into Reg model to send it to server to create new user record
  prepareSaveReg(): Reg {
    const formModel = this.regForm.value;
    //console.log(formModel);
    //console.log("inside prepare model");
    const saveUser: Reg = {
      firstName: formModel.firstName as string,
      lastName :formModel.lastName as string,
      emailAddress :formModel.emailAddress as string,
      address:{street :formModel.street as string,
        aptNo :formModel.aptNo as string,
        state :formModel.state as string,
        zipcode :formModel.zipcode as string,
        city :formModel.city as string,
        country :formModel.country as string}
    };
    return saveUser;
  }

  //populate Data from Registration form into Login model to send it to server to create new user Login record
  prepareSaveLogin(): UserLogin {
    const formModel = this.regForm.value;
    //console.log(formModel);
    //console.log("inside prepare model");
    const saveUser: UserLogin = {
      userName: formModel.userName as string,
      password: formModel.cpassword as string,
      displayName: '',
      user_id: ''
    };
    return saveUser;
  }

  //populate Data from Registration form into Wallet model to send it to server to create new user Login record
  prepareSaveWallet(): Wallet {
    const formModel = this.regForm.value;
    //console.log(formModel);
    //console.log("inside prepare model");
    const saveWallet: Wallet = {
      balance: 0.0,
      user_id: '',
      lendingInterest: 0.0,
      lendingLimit: 0.0
    };
    return saveWallet;
  }

  resetLoginForm = function(){
    this.userForm.reset({
      username: "",
      password: ""
    });
  }

  //Logic implemented for showing Notifications
  request(){
    for (var i = 0; i < this.user.length; i++) {
      if (this.username == this.user[i].username) {
        this.router.navigate(['dashboard']);
      }
    }
  }


  //Changing Login to Registration and vice versa
  ifLogin() { this.login = true; console.log(this.login); }
  ifRegister() { this.login = false; console.log(this.login); }

}
