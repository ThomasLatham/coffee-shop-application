import { Injectable } from '@angular/core';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() { }

  currentUser: User;

  login(user: User){
      this.currentUser = user;
  }

  logout(){
    this.currentUser = null;
  }
}
