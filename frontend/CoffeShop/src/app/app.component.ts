import { Component } from '@angular/core';
import { LoginService } from './services/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Coffee Shop App';
  coffeeShopName = 'Coffee Shop'
  constructor(private loginServ: LoginService){

  }

  getUser(){
    return this.loginServ.currentUser;
  }

  getUsername(){
    return (this.getUser) ? this.getUser().username : "";
  }

  logout() {
    this.loginServ.logout();
    console.log(this.loginServ.currentUser);
  }
}
