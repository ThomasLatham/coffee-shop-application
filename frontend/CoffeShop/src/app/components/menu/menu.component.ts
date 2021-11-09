import { Component, OnInit } from '@angular/core';
import { ItemCategory } from 'src/app/models/ItemCategory';
import { ItemCategoryHttpService } from 'src/app/services/item-category-http.service'
import { MenuItem } from "src/app/models/MenuItem";
import { MenuItemHttpService } from 'src/app/services/menu-item-http.service'
import { MenuItemIngredient } from "src/app/models/MenuItemIngredient";
import { MenuItemIngredientHttpService } from 'src/app/services/menu-item-ingredient-http.service'


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private icHttp: ItemCategoryHttpService, private miHttp: MenuItemHttpService, private miiHttp: MenuItemIngredientHttpService) { }

  ngOnInit(): void {

    this.getAllItemCategories();
    this.getAllMenuItems();
    this.getAllMenuItemIngredients();
  }


  itemCategories: Array<ItemCategory> = [];

  menuItems: Array<MenuItem> = [];

  menuItemIngredients: Array<MenuItemIngredient> = [];

  getAllItemCategories() {
    
    this.icHttp.GetAllItemCategories().subscribe(

      (response) => {
        this.itemCategories = response;
        console.log(this.itemCategories);
      }
    );
  }

  getAllMenuItems() {
    
    this.miHttp.GetAllMenuItems().subscribe(

      (response) => {
        this.menuItems = response;
        console.log(this.menuItems);
      }
    );
  }

  getAllMenuItemIngredients() {
    
    this.miiHttp.GetAllMenuItemIngredients().subscribe(

      (response) => {
        this.menuItemIngredients = response;
        console.log(this.menuItemIngredients);

      }
    );
  }

}
