
export class Role {
    roleID: number;
    roleName: string;

    customer: Role = new Role("customer", 1);
    manager: Role = new Role("manager", 2);

    constructor(roleName: string, roleID?: number){
        this.roleID = roleID;
        this.roleName = roleName;
    }

}