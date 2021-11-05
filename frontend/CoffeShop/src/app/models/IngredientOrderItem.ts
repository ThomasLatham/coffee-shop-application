import { Ingredient } from "./Ingredient";
import { OrderItem } from "./OrderItem";

export class IngredientOrderItem {
    orderItem: OrderItem;
    ingredient: Ingredient;
    ingredientCount: number;


  constructor(orderItem: OrderItem, ingredient: Ingredient, ingredientCount: number) {
    this.orderItem = orderItem
    this.ingredient = ingredient
    this.ingredientCount = ingredientCount
  }

}