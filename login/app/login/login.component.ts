import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { RemitterServiceService } from '../remitter-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  loginUser = new FormGroup({
    username: new FormControl("", [Validators.required]),
    password: new FormControl("", [Validators.required])
  })
  private Service: RemitterServiceService;
  responses: any
  constructor(Service1: RemitterServiceService, private router: Router) {
    this.Service = Service1;
  }

  ngOnInit(): void {

  }

  lg() {
    this.Service.login(this.loginUser.value).subscribe(res => {
      this.responses = res;
      alert("login successfull")
      console.log(res)
      this.router.navigate(["/home"]); 
    },
      error => {
        console.log(error)
        alert("login faild..")
      }
    );
  }
  
}
