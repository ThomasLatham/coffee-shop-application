import { Component, OnInit } from '@angular/core';
import { ItemCategory } from 'src/app/models/ItemCategory';
import { MenuItem } from "src/app/models/MenuItem";
import { MenuItemIngredient } from "src/app/models/MenuItemIngredient";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  fakeMenuItems = [

  ];

  itemCategories: Array<ItemCategory>;
  //get all these too

  menuItems: Array<MenuItem>;
  //fetch all menuItems

  menuItemIngredients: Array<MenuItemIngredient>
  //fetch all these too

}
