
export class Role {
    role_id: number;
    role_name: string;


    //params can have default values (optional?, we don't have to provided)
    constructor(role_name: string = 'customer', user_id?: number){
        this.role_id = user_id;
        this.role_name = role_name;
    }
}