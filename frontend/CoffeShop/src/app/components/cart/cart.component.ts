import { Component, OnInit } from '@angular/core';
import { ItemCategory } from 'src/app/models/ItemCategory';
import { MenuItem } from "src/app/models/MenuItem";
import { MenuItemIngredient } from "src/app/models/MenuItemIngredient";
import { Orders } from 'src/app/models/Orders';
import { CartService } from 'src/app/services/cart.service';
import { OrderStatuses } from 'src/app/models/OrderStatuses';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private itemService : CartService) { }

  cart : CartService;
  item: Object;
  items: Object;
  id: number;
  ngOnInit(){
    this.cart.GetItem(this.id)
    .subscribe(data =>{
        this.item = data;
    }
);


    this.cart.GetIngredient(this.id)
         .subscribe(data =>{
               this.items = data;
} 
);


    this.cart.Getorder(this.id)
        .subscribe(data =>{
            this.items = data;
} 
);

this.cart.Getuser(this.id)
.subscribe(data =>{
    this.items = data;
} 
);

this.cart.Getstatus(this.id)
.subscribe(data =>{
    this.items = data;
} 
);
  
this.cart.GetItems()
.subscribe(data =>{
      this.items = data;
} 
);

this.cart.GetIngredients()
.subscribe(data =>{
      this.items = data;
} 
);


this.cart.DeleteItem(this.id)
.subscribe(data =>{
      this.items = data;
} 
);


this.cart.DeleteIngedient(this.id)
.subscribe(data =>{
      this.items = data;
} 
);


this.cart.DeleteOrder(this.id)
.subscribe(data =>{
      this.items = data;
} 
);




this.cart.AddQuantity(this.id)
.subscribe(data =>{
      this.items = data;
} 
);


this.cart.RemoveQuantity(this.id)
.subscribe(data =>{
      this.items = data;
} 
);

  }

  ItemList: Array<any> = [
    
  ]


  

  cartItem: MenuItem[] = [];
  // orderItem: Order_items;
  totalamount: number;


//   get Total(){
//     let total = 0;
//     for (var i = 0; i < this.cartItem.length; i++) {
//         if (this.cartItem[i].itemPrice) {
//           total += this.cartItem[i].itemPrice * this.orderItem.item_count;
//             this.totalamount = total;
//         }
//     }
//     return total;
// }

}
