import { Role } from '../models/Role';
export class User {
    userID: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    
    userRole: Role;


    //params can have default values (optional?, we don't have to provided)
    constructor(username: string = "", password: string = "", first_name?: string, last_name?: string, roleModel?: Role, user_id?: number){
        this.userID = user_id;
        this.username = username;
        this.password = password;
        this.firstName = first_name;
        this.lastName = last_name;
        this.userRole = roleModel;
    }
}