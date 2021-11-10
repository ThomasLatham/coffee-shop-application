import { Injectable } from '@angular/core';
import { IngredientOrderItem } from "src/app/models/IngredientOrderItem";


@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor() { }


  cart: Array<Array<IngredientOrderItem>> = [];

  addCartItem(newIoiArray: Array<IngredientOrderItem>) {

    let alreadyInCart: boolean = false;

    for (let existingIoiArray of this.cart) {

      if (newIoiArray[0].orderItem.menuItem.itemID == existingIoiArray[0].orderItem.menuItem.itemID 
        && !existingIoiArray[0].ingredient && !newIoiArray[0].ingredient  //if the new cart item and old cart item both don't have extra ingredients and have the same menu item
        ||
        newIoiArray[0].orderItem.menuItem.itemID == existingIoiArray[0].orderItem.menuItem.itemID
        && existingIoiArray[0].ingredient && newIoiArray[0].ingredient
        && newIoiArray[0].ingredient.ingredientID == existingIoiArray[0].ingredient.ingredientID
        && newIoiArray[0].ingredientCount == existingIoiArray[0].ingredientCount) { //if the new cart item and old cart item both have extra ingredients and have the same menu item and the same number and type of ingredients

        for (let ioi of existingIoiArray) {

          ioi.orderItem.itemCount ++;
          alreadyInCart = true;
        }
      }
    }
    if (!alreadyInCart) {

      this.cart.push(newIoiArray);
    }

    console.log(this.cart);
  }

  removeIoi(ioiArray: Array<IngredientOrderItem>) {

    const index = this.cart.indexOf(ioiArray);
    if (index > -1) {
      this.cart.splice(index, 1);
}

  }

}
