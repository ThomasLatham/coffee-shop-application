
export class Role {
    roleID: number;
    roleName: string;


    //params can have default values (optional?, we don't have to provided)
    constructor(roleName: string = 'customer', roleID?: number){
        this.roleID = roleID;
        this.roleName = roleName;
    }
}