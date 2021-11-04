import { Component, OnInit } from '@angular/core';
import { MenuItem } from "../models/MenuItem";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  menuItems: Array<MenuItem>;

}
