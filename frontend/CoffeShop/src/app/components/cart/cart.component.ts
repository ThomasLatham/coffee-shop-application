import { Component, OnInit } from '@angular/core';
import { ItemCategory } from 'src/app/models/ItemCategory';
import { ItemCategoryHttpService } from 'src/app/services/item-category-http.service'
import { MenuItem } from "src/app/models/MenuItem";
import { MenuItemHttpService } from 'src/app/services/menu-item-http.service'
import { MenuItemIngredient } from "src/app/models/MenuItemIngredient";
import { MenuItemIngredientHttpService } from 'src/app/services/menu-item-ingredient-http.service'
import { LoginService } from '../../services/login.service';
import { loginHttpService } from '../../services/login-http.service';
import { User } from '../../models/User';

import { IngredientOrderItem } from "src/app/models/IngredientOrderItem";
import { OrderItem } from 'src/app/models/OrderItem';
import { CartService } from 'src/app/services/cart.service';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private ciHttp: ItemCategoryHttpService, private ioiHttp: MenuItemHttpService,private miiHttp: MenuItemIngredientHttpService) { }


  
  ngOnInit(){
    this.addCartItem(); 
    this.removeIoi();  
    this.getTotal();
  }

  
  
  orderItem: OrderItem;
  Total: number;
  User: User;
  itemCategories: Array<ItemCategory> = [];
  menuItems: Array<MenuItem> = [];
  menuItemIngredients: Array<MenuItemIngredient> = [];
  newIoiArray: Array<IngredientOrderItem>
  ioiArray: Array<IngredientOrderItem>
  cart: Array<Array<IngredientOrderItem>> = [];



  addCartItem() {

    this.ciHttp.GetAllItemCategories()
    .subscribe(data =>{
        this.newIoiArray;
        this.cart;
        this.menuItemIngredients;
        this.ioiArray;

    }
);
  }


  removeIoi() {
    this.ioiHttp.GetAllMenuItems()
         .subscribe(data =>{
          this.newIoiArray;
          this.cart;
          this.menuItemIngredients;
          this.ioiArray;
} 
);
  }

  

 
  getTotal(){
    let total = 0;
    for (var i = 0; i < this.menuItems.length; i++) {
        if (this.menuItems[i].itemPrice) {
          total += this.menuItems[i].itemPrice * this.orderItem.itemCount;
            this.Total = total;
            
        }
    }
    return total;
}

// checkLogin(){
//   return this.loginServ.currentUser;
// }

}
