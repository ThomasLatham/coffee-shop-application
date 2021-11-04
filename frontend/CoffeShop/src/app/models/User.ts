import { Role } from '../models/Role';
export class User {
    user_id: number;
    username: string;
    password: string;
    first_name: string;
    last_name: string;
    user_role: Role;


    //params can have default values (optional?, we don't have to provided)
    constructor(username: string = "", password: string = "", first_name?: string, last_name?: string, roleModel?: Role, user_id?: number){
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_role = roleModel;
    }
}