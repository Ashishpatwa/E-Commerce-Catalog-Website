import { Component } from '@angular/core';
import { AbstractControl, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Constants } from 'src/app/shared/Constants';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginUser: any;
  responseMessage: any;



  constructor(private router: Router,
    private formBuilder: FormBuilder,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {

    this.loginUser = this.formBuilder.group({
      gmail: new FormControl('',[Validators.required,Validators.email]),
      password: new FormControl('',[Validators.required,Validators.minLength(6)])

    })

  }

  getControl(name : any) : AbstractControl | null{
    return this.loginUser.get(name);
  }

  handleLogin() {

    var formData = this.loginUser.value;

    const data = {
      gmail: formData.gmail,
      password: formData.password
    }

    

      this.loginService.doLogin(data).subscribe((response: any) => {
        console.log(response.token)
        localStorage.setItem("user", formData.gmail);
        this.loginService.loginUser(response.token)
        window.location.href = "/";
        // this.router.navigate(['operation']);
      }, (error) => {
        if (error.error?.message) {
          this.responseMessage = error.error?.message;
        }
        else {
          this.responseMessage = "Wrong Credentials";
        }

      })
    

  }

  navigateToRegister(){
    this.router.navigate(['register']);
  }

}
