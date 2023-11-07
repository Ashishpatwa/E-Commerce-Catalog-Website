import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ProductComponent } from './components/product/product.component';
import { AuthGuardService } from './services/auth.guard';
// import { SearchpageComponent } from './searchpage/searchpage.component';
import { ErrorPageComponent } from './components/error-page/error-page.component';


const routes: Routes = [
  {
    path:"",
    component:HomeComponent,
    pathMatch:'full'
  },

  {
    path:"login",
    component: LoginComponent,
    pathMatch:'full'
  },

  {
    path:"register",
    component: RegisterComponent,
    pathMatch: 'full'
  },
  {
    path: "product",
    component: ProductComponent,
    pathMatch: 'full',
    canActivate: [AuthGuardService]
  },
  // {
  //   path: "search",
  //   component: RegisterComponent,
  //   pathMatch: 'full'
  // },
  {
    path:"**",
    component: ErrorPageComponent,
    pathMatch:'full'
  },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
