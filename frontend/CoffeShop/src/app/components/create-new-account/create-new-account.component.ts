import { Component, OnInit } from '@angular/core';
import { CreateNewAccountService } from '../../services/create-new-account.service';

@Component({
  selector: 'app-create-new-account',
  templateUrl: './create-new-account.component.html',
  styleUrls: ['./create-new-account.component.css']
})
export class CreateNewAccountComponent implements OnInit {

  constructor(private createNewAccount: CreateNewAccountService) { }

  ngOnInit(): void {
  }

  
}
