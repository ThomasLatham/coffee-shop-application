import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { User } from '../../models/User';
import { UserAddress } from '../../models/UserAddress';
import { CreateNewAccountService } from '../../services/create-new-account.service';
import { LoginService } from '../../services/login.service';
import { loginHttpService } from '../../services/login-http.service';
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
    private customValidator: CustomvalidationService,
    private createAccountHttp: CreateNewAccountService,
    private loginHttp: loginHttpService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.createAccountHttp.getAllUsernames().subscribe(
      (response) => {
        this.customValidator.UsernameList = response;
      }
    )
    this.registerForm = this.fb.group({
      firstName : ['', Validators.required],
      lastName : ['', Validators.required],
      phoneNumber: ['', [Validators.required, Validators.pattern('[0-9]{3}[-]?[0-9]{3}[-]?[0-9]{4}$')]],
      email: ['', [Validators.required, Validators.email]],
      street : ['', Validators.required],
      city : ['', Validators.required],
      zipCode : ['', [Validators.required, Validators.pattern('[0-9]{5}')]],
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
  
  newAccount: User = new User();
  newAddress: UserAddress = new UserAddress();

  loginAccount: User;

  showErrorMessage: boolean = false;



  login() {
    if(this.username && this.password){
        this.loginAccount= new User(this.username, this.password);
        this.loginHttp.loginValidation(this.username, this.password).subscribe(
          (response) =>{
            if(response.status === 200){
              this.loginServ.login(response.body);
              this.goLandingPage();
            }else if (response.status === 204){
              alert("The username or password you entered does not match the records in our database. Please try again!")
            }else{
              alert("Something goes wrong! Please ask technology development for help!\n Email: abc@abc.com")
            }          
          }
        )
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

  goLandingPage(){
    this.router.navigate(['/landingpage']);
  }

  onSubmit() {
    this.submitted = true;
    this.newAccount.email = this.registerForm.controls.email.value;
    this.newAccount.firstName = this.registerForm.controls.firstName.value;
    this.newAccount.lastName = this.registerForm.controls.lastName.value;
    this.newAccount.password = this.registerForm.controls.password.value;
    this.newAccount.phoneNumber = this.registerForm.controls.phoneNumber.value;
    this.newAccount.username = this.registerForm.controls.username.value;
    this.newAddress.street = this.registerForm.controls.street.value;
    this.newAddress.city = this.registerForm.controls.city.value;
    this.newAddress.zipCode = this.registerForm.controls.zipCode.value;

    if (this.registerForm.valid) {
      this.createAccountHttp.addUser(this.newAccount).subscribe(
        (userResponse) => {
          if(userResponse.status === 201){
            this.newAddress.user = userResponse.body;
            this.createAccountHttp.addUserAddress(this.newAddress).subscribe(
              (addressResponse) => {
                if(addressResponse.status === 201){
                  this.loginServ.login(addressResponse.body);
                  this.goLandingPage();
                }else{
                  alert("Something goes wrong! Please ask technology development for help!\n Email: abc@abc.com")
                }    
              }
            );
          }else{
            alert("Something goes wrong! Please ask technology development for help!\n Email: abc@abc.com")
          }    
        }
      );
      this.registerForm.reset();
    }else{
      alert('Could not submit the Form!!!\n Check the values for all required fields.');
    }
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
