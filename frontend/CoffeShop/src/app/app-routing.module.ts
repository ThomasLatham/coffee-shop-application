import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateNewAccountComponent } from './components/create-new-account/create-new-account.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [

  { path: 'login', component: LoginComponent },
  { path: 'login/createNewAccount', component: CreateNewAccountComponent },
  { path: 'ordermanagement', component: OrderManagementComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
