import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { LoginService } from '../../services/login.service';
import { CreateNewAccountComponent } from '../create-new-account/create-new-account.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginServ: LoginService, private createNewAccount: CreateNewAccountComponent) { }

  ngOnInit(): void {
  }

  username: string;
  password: string;
  target: string = "#accountDiv";
  modalName: string = "model";

  showErrorMessage: boolean = false;


  login() {
    if(this.username && this.password){
        this.loginServ.login(new User(this.username, this.password))
        this.clearText();
        this.showErrorMessage = false;
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
