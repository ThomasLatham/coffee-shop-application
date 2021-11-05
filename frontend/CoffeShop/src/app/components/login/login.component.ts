import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { UserAddress } from '../../models/UserAddress';
import { Role } from '../../models/Role';
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
  
  firstName: string;
  lastName: string;
  street: string;
  city: string;
  zipCode: number;
  roleName: number;

  newAccount: User;
  newAddress: UserAddress;

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

  createAccount(){
    if(this.username && this.password && this.firstName && this.lastName && this.roleName){
      
      newAddress = new Address(this.zipCode,this.city,this.street);
      this.newAccount = new User(this.username, this.password, this.firstName, this.lastName, )
    }
  }

  checkLogin(){
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
