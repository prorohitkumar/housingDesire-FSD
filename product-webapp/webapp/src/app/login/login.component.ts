import { Router } from '@angular/router';
import { CustomerAuthService } from '../_services/customer-auth.service';
import { CustomerService } from '../_services/customer.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private userService: CustomerService,
    private userAuthService: CustomerAuthService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  login(loginForm: NgForm) {
    this.userService.login(loginForm.value).subscribe(
      (response:any) => {
        this.userAuthService.setRoles(response.user.role);
        this.userAuthService.setToken(response.jwtToken);

        const role = response.user.role[0].roleName;
        if (role === 'Designer') {
          this.router.navigate(['/viewdesignerprofile']);
        } else{
          this.router.navigate(['/listofdesigns']);
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
