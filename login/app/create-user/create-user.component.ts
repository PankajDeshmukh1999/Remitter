import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RemitterServiceService } from '../remitter-service.service';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent {

  loginUser = new FormGroup({
    username: new FormControl("", [Validators.required]),
    password: new FormControl("", [Validators.required])
  })

  private Service: RemitterServiceService;
  responses: any
  constructor(Service1: RemitterServiceService, private router: Router) {
    this.Service = Service1;
  }

  CreateUserDetails(){
    this.Service.createUser(this.loginUser.value).subscribe(res=>{
      this.responses=res
      console.log(res)
      alert("User registerd")
      this.router.navigate([""])
    },error=>{
      console.log(error)
      alert("User not registerd")
    })
  }

}
