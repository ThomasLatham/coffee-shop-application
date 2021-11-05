
export class Role {
    roleId: number;
    roleName: string;


    //params can have default values (optional?, we don't have to provided)
    constructor(roleName: string = 'customer', roleId?: number){
        this.roleId = roleId;
        this.roleName = roleName;
    }
}