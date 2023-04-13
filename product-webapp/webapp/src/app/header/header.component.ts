import { CustomerService } from './../_services/customer.service';
import { CustomerAuthService } from './../_services/customer-auth.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(
    private userAuthService: CustomerAuthService,
    private router: Router,
    public userService: CustomerService
  ) {}

  ngOnInit(): void {}

  public isLoggIn() {
    return this.userAuthService.isLoggedIn();
  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigate(['/home']);
  }

}
