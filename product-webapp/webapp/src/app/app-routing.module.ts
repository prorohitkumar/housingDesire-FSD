import { UploadDesignComponent } from './upload-design/upload-design.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PaymentComponent } from './payment/payment.component';
import { RegistrationComponent } from './registration/registration.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { LoginComponent } from './login/login.component';
import { CustomerComponent } from './customer/customer.component';
import { AuthGuard } from './_auth/auth.guard';
import { DesignerComponent } from './designer/designer.component';
import { ListofdesignsComponent } from './listofdesigns/listofdesigns.component';
import { Listofdesigns1Component } from './listofdesigns1/listofdesigns1.component';

import { HomeComponent } from './home/home.component';
import { ReviewComponent } from './review/review.component';
import { UCProfileComponent } from './ucprofile/ucprofile.component';
import { UpadateDpComponent } from './upadate-dp/upadate-dp.component';
import { DesignDetailsComponent } from './design-details/design-details.component';
import { ViewdesignerprofileComponent } from './viewdesignerprofile/viewdesignerprofile.component';
import { UprofileComponent } from './uprofile/uprofile.component';


const routes: Routes = [
  {path:"",redirectTo:"home",pathMatch:"full"},
  { path: 'home', component: HomeComponent },
  { path: 'designer', component: DesignerComponent, canActivate:[AuthGuard], data:{roles:['Designer']} },
  { path: 'customer', component: CustomerComponent ,  canActivate:[AuthGuard], data:{roles:['Customer']} },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'forbidden', component: ForbiddenComponent },
  { path: 'listofdesigns', component: ListofdesignsComponent },
  { path: 'listofdesigns1', component: Listofdesigns1Component },
  { path: 'review', component: ReviewComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'updatecustomer/:id', component: UCProfileComponent },
  { path: 'update1/:id', component: UpadateDpComponent },
  { path: 'designdetails', component: DesignDetailsComponent },
  { path: 'viewdesignerprofile', component: ViewdesignerprofileComponent },
  { path: 'viewcustomerprofile', component: UprofileComponent},
  { path: 'upload-design', component: UploadDesignComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
