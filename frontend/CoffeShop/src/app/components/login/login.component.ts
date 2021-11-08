import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { User } from '../../models/User';
import { UserAddress } from '../../models/UserAddress';
import { Role } from '../../models/Role';
import { LoginService } from '../../services/login.service';
import { CustomvalidationService } from '../../services/customvalidation.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;

  constructor(
    private loginServ: LoginService,
    private fb: FormBuilder,
    private customValidator: CustomvalidationService
    ) { }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      firstName : ['', Validators.required],
      lastName : ['', Validators.required],
      phoneNumber: ['', [Validators.required, Validators.pattern('(\d{3})[-]?(\d{3})[-]?(\d{4})')]],
      email: ['', [Validators.required, Validators.email]],
      street : ['', Validators.required],
      city : ['', Validators.required],
      zipCode : ['', [Validators.required, Validators.pattern('(\d{5})')]],
      username: ['', [Validators.required], this.customValidator.userNameValidator.bind(this.customValidator)],
      password: ['', Validators.compose([Validators.required, this.customValidator.passwordValidator()])],
      confirmPassword: ['', [Validators.required]],
    },
      {
        validator: this.customValidator.MatchPassword('password', 'confirmPassword'),
      }
    );
  }



  username: string;
  password: string;
  
  // firstName: string;
  // lastName: string;
  // street: string;
  // city: string;
  zipCodeFormat: boolean;
  // roleName: number;

  newAccount: User = new User();
  newAddress: UserAddress = new UserAddress();

  showErrorMessage: boolean = false;


  login() {
    if(this.username && this.password){
        this.loginServ.login(new User(this.username, this.password))
        this.clearText();
        this.showErrorMessage = false;
    }else{
      this.clearText();
      this.errorMessage();
    }
    
  }

  get registerFormControl() {
    return this.registerForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.valid) {
      alert('Form Submitted succesfully!!!\n Check the values in browser console.');
      console.table(this.registerForm.value);
    }
    // else{

      // console.log(this.registerForm.get('fb.firstName') +'invalid')
      // console.log(this.registerForm.get('lastName') +'invalid')
      // console.log(this.registerForm.get('phoneNumber') +'invalid')
      // console.log(this.registerForm.get('email') +'invalid')
      // console.log(this.registerForm.get('street') +'invalid')
      // console.log(this.registerForm.get('city') +'invalid')
      // console.log(this.registerForm.get('zipCode') +'invalid')
      // console.log(this.registerForm.get('username') +'invalid')
      // console.log(this.registerForm.get('password') +'invalid')
      // console.log(this.registerForm.get('confirmPassword') +'invalid')

    // }

  }

  checkLogin(){
    return this.loginServ.currentUser;
  }

  clearText(){
    this.username = "";
    this.password = "";
  }

  errorMessage(){
    this.showErrorMessage = true;
  }
}
