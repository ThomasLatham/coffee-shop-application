import { User } from "./User";

export class Address {
    addressId: number;
    user: User;
    street: string;
    city: string;
    zipCode: number;


    //params can have default values (optional?, we don't have to provided)
    constructor(zipCode: number, city: string, street: string, user: User, addressId?: number){
        this.addressId = addressId;
        this.user = user;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}