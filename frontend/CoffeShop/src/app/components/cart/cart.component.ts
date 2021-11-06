import { Component, OnInit } from '@angular/core';
import { ItemCategory } from 'src/app/models/ItemCategory';
import { MenuItem } from "src/app/models/MenuItem";
import { IngredientOrderItem } from "src/app/models/IngredientOrderItem";
import { OrderItem } from 'src/app/models/OrderItem';
import { CartService } from 'src/app/services/cart.service';
import { OrderStatus } from 'src/app/models/OrderStatus';

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
  orderItem: OrderItem;
  totalamount: number;


  get Total(){
    let total = 0;
    for (var i = 0; i < this.cartItem.length; i++) {
        if (this.cartItem[i].itemPrice) {
          total += this.cartItem[i].itemPrice * this.orderItem.itemCount;
            this.totalamount = total;
        }
    }
    return total;
}

}
