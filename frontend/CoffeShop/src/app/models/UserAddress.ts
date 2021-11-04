import { User } from "./User";


export class UserAddress {

    addressID: number;
    user: User;
    street: string;
    city: string;
    zipCode: number;


  constructor(
    addressID: number, 
    user: User, 
    street: string, 
    city: string, 
    zipCode: number
) {
    this.addressID = addressID
    this.user = user
    this.street = street
    this.city = city
    this.zipCode = zipCode
  }

    
}