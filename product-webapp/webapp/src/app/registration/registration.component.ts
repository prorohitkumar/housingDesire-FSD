import { Component, OnInit } from '@angular/core';
import { User } from './user';
import { UserRegistrationService } from './../service/user-registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  user:User =new User();

  constructor(private registerService: UserRegistrationService) { }

  ngOnInit(): void {
  }

  userRegister(){
    console.log(this.user);
    this.registerService.registerUser(this.user).subscribe(data=>{
     alert("Successfully User is register?")
    },error=>alert("Sorry User not register"));
  }
  // userRegister1(){
  //   console.log(this.user);
  //   this.registerService.registerUser1(this.user).subscribe(data=>{
  //    alert("Successfully User is register?")
  //   },error=>alert("Sorry User not register"));
  // }
}
