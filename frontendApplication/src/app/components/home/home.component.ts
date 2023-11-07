import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { SearchService } from 'src/app/services/search.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit{

  getAllProducts:any;
  responseMessage:any;
  item:any;
  islogin:any = false;
  filter: any;
  search: any;
  value: any;
  NoProductFound:any = false;

  

  selectedName: any;
  dropdownVisible = false;

  constructor(private userService: UserService,
    private loginService: LoginService,
    private searchService: SearchService,
    private router: Router){

  }

  ngOnInit(): void {
    this.selectedName = 'filter';
    this.islogin = this.loginService.isLoggedIn();
    this.userService.getUser().subscribe((response:any)=>{

      this.getAllProducts = response;
      console.log(this.getAllProducts);

    },(error)=>{
      if(error.error?.message){
        this.responseMessage = error.error?.message;
      }
      else{
        this.responseMessage = "Something went wrong! Please try again later.";
      }
    })
  }


  getProductDetail(productId:any){
    var item = this.getAllProducts[productId];
   
    localStorage.setItem('productCode',item.productCode)
    localStorage.setItem('name',item.name)
    localStorage.setItem('brand',item.brand)
    localStorage.setItem('details',item.details)
    localStorage.setItem('price',item.price)
    localStorage.setItem('availability',item.availability)
    localStorage.setItem('image',item.image)

    this.router.navigate(['product'])
  }

  // type cast in TypeScript

  handleSearch(event: any) {
    const value = (event.target as HTMLInputElement).value;

    if (value != null || value != " ") {
      this.value = value;
      this.filter = this.selectedName;
      if (this.filter === "Brand") {
        this.searchService.searchByBrand(this.value).subscribe((response: any) => {
         
          this.getAllProducts = response;
          if(this.getAllProducts.length == 0  || this.getAllProducts == null)
            this.NoProductFound = true;
          else
            this.NoProductFound = false;
        
        }, (error) => {
          if (error.error?.message) {
     
            this.responseMessage = error.error?.message;
          }
          else {
         
            this.responseMessage = "Something went wrong! please try again later";
          }

        })
      }
      else if (this.filter === "Price") {
        this.searchService.searchByPrice(this.value).subscribe((response: any) => {
     
          this.getAllProducts = response;
          if(this.getAllProducts.length == 0  || this.getAllProducts == null)
            this.NoProductFound = true;
          else
            this.NoProductFound = false;
         
        }, (error) => {
          if (error.error?.message) {
           
            this.responseMessage = error.error?.message;
          }
          else {
         
            this.responseMessage = "Something went wrong! please try again later";
          }

        })
      }
      else if (this.filter === "Name") {
        this.searchService.searchByName(this.value).subscribe((response: any) => {
        
          this.getAllProducts = response;
          if(this.getAllProducts.length == 0  || this.getAllProducts == null)
            this.NoProductFound = true;
          else
            this.NoProductFound = false;
         
        }, (error) => {
          if (error.error?.message) {
        
            this.responseMessage = error.error?.message;
          }
          else {
          
            this.responseMessage = "Something went wrong! please try again later";
          }

        })
      }
      else if (this.filter === "Code") {
        this.searchService.searchByCode(this.value).subscribe((response: any) => {
        
          this.getAllProducts = response;
          if(this.getAllProducts.length == 0  || this.getAllProducts == null)
            this.NoProductFound = true;
          else
            this.NoProductFound = false;
         
        }, (error) => {
          if (error.error?.message) {
        
            this.responseMessage = error.error?.message;
          }
          else {
        
            this.responseMessage = "Something went wrong! please try again later";
          }

        })
      }
      else {
        this.searchService.searchByAll(this.value).subscribe((response: any) => {
       
          this.getAllProducts = response;
          if(this.getAllProducts.length == 0  || this.getAllProducts == null)
            this.NoProductFound = true;
          else
            this.NoProductFound = false;
         
          localStorage.setItem("searchData", this.getAllProducts);
          // this.router.navigate(['operation']);
        }, (error) => {
          if (error.error?.message) {
         
            this.responseMessage = error.error?.message;
          }
          else {
          
            this.responseMessage = "Something went wrong! please try again later";
          }

        })
      }

      
      
      
      
      this.router.navigate(['/']);
      location.reload;

    }


   

  }


  navigateToHome(){
    this.router.navigate(['/']);
    location.reload;
  }



}
