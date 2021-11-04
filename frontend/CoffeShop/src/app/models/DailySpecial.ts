import { MenuItem } from "./menuItem";
import { Shop } from "./Shop";

export class DailySpecial {
    dailySpecialID: number;
    shop: Shop;
    dayOfWeek: number;
    menuItem: MenuItem;
}