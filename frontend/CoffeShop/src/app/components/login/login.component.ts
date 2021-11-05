import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginServ: LoginService) { }

  ngOnInit(): void {
  }

  username: string;
  password: string;
  showErrorMessage: boolean = false;
  loginCheck: boolean = false;

  login() {
    if(this.username && this.password){
        this.loginServ.login(new User(this.username, this.password))
        this.clearText();
        this.showErrorMessage = false;
        this.loginCheck = true;
    }else{
      this.clearText();
      this.errorMessage();
    }
    
  }
  checkUser(){
    return this.loginServ.currentUser;
  }

  clearText(){
    this.username = "";
    this.password = "";
  }

  errorMessage(){
    this.showErrorMessage = true;
  }

}
