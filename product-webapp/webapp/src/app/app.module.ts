import { UprofileComponent } from './uprofile/uprofile.component';
import { UCProfileComponent } from './ucprofile/ucprofile.component';
import { ViewdesignerprofileComponent } from './viewdesignerprofile/viewdesignerprofile.component';
import { UpadateDpComponent } from './upadate-dp/upadate-dp.component';
import { HeaderDesignerComponent } from './header-designer/header-designer.component';
import { HeaderCustomerComponent } from './header-customer/header-customer.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UploadDesignComponent } from './upload-design/upload-design.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { DesignDetailsComponent } from './design-details/design-details.component';
import { HomeComponent } from './home/home.component';
import { DesignerComponent } from './designer/designer.component';
import { CustomerComponent } from './customer/customer.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HeaderComponent } from './header/header.component';
import { RegistrationComponent } from './registration/registration.component';
import { ListofdesignsComponent } from './listofdesigns/listofdesigns.component';
import { Listofdesigns1Component } from './listofdesigns1/listofdesigns1.component';
import { ReviewComponent } from './review/review.component';
import { PaymentComponent } from './payment/payment.component';
import { NgModule } from '@angular/core';


@NgModule({
  declarations: [
    AppComponent,
    UploadDesignComponent,
    HeaderCustomerComponent,
    HeaderDesignerComponent,
    DesignDetailsComponent,
    DesignerComponent,
    CustomerComponent,
    LoginComponent,
    ForbiddenComponent,
    HeaderComponent,
    HomeComponent,
    RegistrationComponent,
    ListofdesignsComponent,
    Listofdesigns1Component,
    ReviewComponent,
    PaymentComponent,
    UpadateDpComponent,
    ViewdesignerprofileComponent,
    UCProfileComponent,
    UprofileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,FormsModule, BrowserAnimationsModule,
    HttpClientModule,
    MatButtonModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
