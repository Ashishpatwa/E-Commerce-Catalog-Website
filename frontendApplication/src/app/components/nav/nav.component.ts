import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { SearchService } from 'src/app/services/search.service';
import { DataSharingService } from 'src/app/services/data-sharing.service';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.sass']
})
export class NavComponent implements OnInit {
  constructor(
    private router: Router,
    private loginService: LoginService,
    private searchService: SearchService,
    private dataSharingService: DataSharingService) { }

  public loggedIn = false;
  dropdownVisible = false;
  responseMessage: any;
  getAllProducts: any;
  item: any;
  searchResults: any = false;
  filter: any;
  search: any;
  value: any;
  islogin: any = false;
  NoProductFound: any = false;
  user = localStorage.getItem("user");


  toggleDropdown() {
    this.dropdownVisible = !this.dropdownVisible;
  }

  updateSelectedName() {
    // Perform any additional actions here if needed
  }
  


  ngOnInit(): void {
    this.loggedIn = this.loginService.isLoggedIn();
  }

  login() {
    this.router.navigate(['login'])
  }

  logout() {
    this.loginService.logout();
    location.reload();
  }

  navigateToHome(){
    this.router.navigate(['home'])
    location.reload();
  }

}
