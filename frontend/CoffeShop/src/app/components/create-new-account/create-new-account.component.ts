import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';

@Component({
  selector: 'app-create-new-account',
  templateUrl: './create-new-account.component.html',
  styleUrls: ['./create-new-account.component.css']
})
export class CreateNewAccountComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

    username: string;
    password: string;
    firstName: string;
    lastName: string;
    street: string;
    city: string;
    zipCode: number;
    roleName: string;

    newUser: User;

  createNewAccount(
    username: string,
    password: string,
    firstName: string,
    lastName: string,
    street: string,
    city: string,
    zipCode: number,
    roleName: string
  ){
    this.newUser.username = username;
    this.newUser.password = password;
    this.newUser.firstName = firstName;
    this.newUser.lastName = lastName;
    this.newUser.userAddress.street = street;
    this.newUser.userAddress.city = city;
    this.newUser.userAddress.zipCode = zipCode;
    this.newUser.userRole.roleName = roleName;

  }
  
}
