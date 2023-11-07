import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ServiceabilityService } from 'src/app/services/serviceability.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.sass']
})
export class ProductComponent implements OnInit{

  constructor(private formBuilder: FormBuilder,
    private serviceabilityService:ServiceabilityService){}

  ngOnInit(): void {
    this.ServiceabilityCheck = this.formBuilder.group({
      Pincode: ['']
  
    })
  }

  

  brand = localStorage.getItem('brand');
  productCode = localStorage.getItem('productCode');
  name = localStorage.getItem('name');
  details = localStorage.getItem('details');
  price = localStorage.getItem('price');
  availability = localStorage.getItem('availability');
  image = localStorage.getItem('image');
  loginUser : any;
  responseMessage: any;
  pincode:any;
  Serviceable:any =false;
  NotServiceable:any = false;
  days: any;
  ServiceabilityCheck:any;




  

  checkPincode(){

    var formData= this.ServiceabilityCheck.value;
    
    this.pincode = formData.Pincode;

    this.serviceabilityService.checkServiceability(this.productCode, this.pincode).subscribe((response:any)=>{
     console.log(response)
      if(response[0]){
      this.Serviceable = true;
      this.NotServiceable = false;
      this.days = response[0].estimateddays;

     }
     else{
      this.NotServiceable = true;
      this.Serviceable = false;
     }
    },(error)=>{
      if(error.error?.message){
        this.responseMessage = error.error?.message;
      }
      else{
        this.responseMessage = "Something went wrong! please try again later";
      }
    
    })

    
    

  }

}
