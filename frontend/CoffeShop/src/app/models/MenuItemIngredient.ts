import { Ingredient } from "./Ingredient";
import { MenuItem } from "./menuItem";

export class MenuItemIngredient {
    item: MenuItem;
    ingredient: Ingredient;


  constructor(item: MenuItem, ingredient: Ingredient) {
    this.item = item
    this.ingredient = ingredient
  }

}