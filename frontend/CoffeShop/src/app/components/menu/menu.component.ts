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

  //this is a test comment for testing the branch/merge system

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
