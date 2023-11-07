import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from 'src/app/services/register.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Constants } from 'src/app/shared/Constants';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})
export class RegisterComponent implements OnInit {

  registerUser: any;
  responseMessage: any;

  constructor(private router: Router,
    private formBuilder: FormBuilder,
    private registerService: RegisterService
  ) { }

  ngOnInit(): void {

    this.registerUser = this.formBuilder.group({
      gmail: new FormControl('',[Validators.required,Validators.email]),
      firstName: new FormControl('',[Validators.required,Validators.pattern(Constants.nameRegex),Validators.minLength(2)]),
      lastName: new FormControl('',[Validators.required,Validators.pattern(Constants.nameRegex),Validators.minLength(2)]),
      password: new FormControl('',[Validators.required,Validators.minLength(6)]),
      repassword: new FormControl('',[Validators.required,Validators.minLength(6)])

  })
}


  getControl(name : any) : AbstractControl | null{
    return this.registerUser.get(name);
  }

  handleregister() {

    console.log(this.registerUser)

    var formData = this.registerUser.value;

    const data = {
      gmail: formData.gmail,
      firstName: formData.firstName,
      lastName: formData.lastName,
      password: formData.password,
      repassword: formData.repassword

    }

    const tokn = {
      gmail: formData.gmail,
      password: formData.password
    }

    
    if (formData.password != formData.repassword) {
      this.responseMessage = "Password Should be Same";
    }
    else {

      this.registerService.addUser(data).subscribe((response: any) => {

        if (response.message == "Username Already Exist") {
          this.responseMessage = response.message;
        }
        else {
          
          this.registerService.generateToken(tokn).subscribe((respons: any) => {
            this.registerService.SetToken(respons.token)
            window.location.href = "/";
            localStorage.setItem("user", formData.gmail);
          }, (error) => {
            console.log(error)
            if (error.error?.message) {
              this.responseMessage = error.error?.message;
            }
            else {
              this.responseMessage = "Something went wrong to generate Token";
            }
          })
        }
        // this.router.navigate(['operation']);
      }, (error) => {
        if (error.error?.message) {
          this.responseMessage = error.error?.message;
        }
        else {
          this.responseMessage = "Something Went Wrong! Please Try again later";
        }

      })


    }

  }


  navigateToLogin(){
    this.router.navigate(['login']);
  }

}