import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { CreateNewAccountComponent } from './components/create-new-account/create-new-account.component';
<<<<<<< Updated upstream
import { MenuComponent } from './menu/menu.component';
=======
import { OrderManagementComponent } from './components/order-management/order-management.component';
>>>>>>> Stashed changes

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateNewAccountComponent,
<<<<<<< Updated upstream
    MenuComponent
=======
    OrderManagementComponent
>>>>>>> Stashed changes
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
