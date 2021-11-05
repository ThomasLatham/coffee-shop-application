import { Role } from '../models/Role';
import { Address } from '../models/Address';

export class User {
    userId: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    userAddress: Address;
    userRole: Role;


    //params can have default values (optional?, we don't have to provided)
    constructor(username: string = "", password: string = "", firstName?: string, lastName?: string, userAddress?: Address, userRole?: Role, userId?: number){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAddress = userAddress;
        this.userRole = userRole;
    }
}