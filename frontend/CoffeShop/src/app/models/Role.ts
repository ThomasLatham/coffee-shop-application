
export class Role {
    roleID: number;
    roleName: string;


    //params can have default values (optional?, we don't have to provided)
    constructor(role_name: string = 'customer', user_id?: number){
        this.roleID = user_id;
        this.roleName = role_name;
    }
}