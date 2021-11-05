import { Ingredient } from "./Ingredient";
import { MenuItem } from "./menuItem";

export class MenuItemIngredient {
    menuItemIngredientID: number;
    item: MenuItem;
    ingredient: Ingredient;



  constructor(menuItemIngredientID: number, item: MenuItem, ingredient: Ingredient) {
    this.menuItemIngredientID = menuItemIngredientID
    this.item = item
    this.ingredient = ingredient
  }
  

}