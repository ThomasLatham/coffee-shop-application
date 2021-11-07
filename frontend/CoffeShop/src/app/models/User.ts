import { Role } from '../models/Role';

export class User {
    userID: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    email: string;
    phoneNumber: string;
    userRole: Role;


    //params can have default values (optional?, we don't have to provided)
    constructor(username?: string, password?: string, phoneNumber?: string, email?: string, firstName?: string, lastName?: string, userRole?: Role, userID?: number){
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
    }
}