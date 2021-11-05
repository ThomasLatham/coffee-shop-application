import { Component, OnInit } from '@angular/core';
import { Item } from '../../models/menu_items';
import { Ingredient } from '../../models/ingredients';
import { ItemHttpService } from '../../services/items-http.service';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private itemHttp: ItemHttpService) { }

  ngOnInit(): void {

    this.displayAllItems();
    this.displayAllIngredients();
  }

  ItemList: Array<any> = [
    { "id": 1, "item_name": "Black Coffee", "item_price": 2.00, "prep_time": 2, "menu_cat": "drink", "item_pic": true }
  ]


  

  itemList: Item[] = [];
  ingredientList: Ingredient[] = [];
  Item_Count: number;
  totalamount: number;
  title: string;
  price: number;
  available: boolean = true;

  displayAllItems() {
    //This function will need to call our HTTP Service for retrieving all items.
    this.itemHttp.getAllItems().subscribe(
      (response) => {
        console.log(response);
        this.itemList = response;
         console.log(this.itemList);
        
      }
    );
  }



  displayAllIngredients() {
    //This function will need to call our HTTP Service for retrieving all igredients.
    this.itemHttp.getAllIngredients().subscribe(
      (response) => {
        console.log(response);
        this.ingredientList = response;
         console.log(this.ingredientList);
      }
    );
  }




  addQuantity() {
 
    this.itemHttp.getOrderItem.subscribe(
      (response) => {
        console.log(response);
        this.itemList = response;
         console.log(this.order_item.item_count);
         this.order_item.item_count += 1;
      }
    );
  }

  removeQuantity() {
    
    this.itemHttp.getOrderItem.subscribe(
      (response) => {
        console.log(response);
        this.itemList = response;
         console.log(this.order_item.item_count);
         if(this.order_item.item_count == 0){
          this.order_item.item_count == 0;
         } else{
          this.order_item.item_count -= 1;
         }
         
      }
    );
  }

  removeItem() {
    
    this.itemHttp.deleteOrderItem.subscribe(
      (response) => {
        console.log(response);
        
      }
    );
  }



  get Total(){
    let total = 0;
    for (var i = 0; i < this.cartItem.length; i++) {
        if (this.cartItem[i].Price) {
          total += this.cartItem[i].Price * this.cartItem[i].Quantity;
            this.totalamount = total;
        }
    }
    return total;
}

}
