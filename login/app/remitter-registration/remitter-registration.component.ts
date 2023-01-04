import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RemitterServiceService } from '../remitter-service.service';

@Component({
  selector: 'app-remitter-registration',
  templateUrl: './remitter-registration.component.html',
  styleUrls: ['./remitter-registration.component.css']
})
export class RemitterRegistrationComponent implements OnInit{

  private Service: RemitterServiceService;
  responses: any
  constructor(Service1: RemitterServiceService, private router: Router) {
    this.Service = Service1;
  }

  ngOnInit(): void {
    
  }

  remitterForm = new FormGroup({
    firstName:new FormControl("", [Validators.required]),
    lastName:new FormControl("", [Validators.required]),
    accountNumber:new FormControl("", [Validators.required]),
    accountBalance:new FormControl("", [Validators.required]),
    address:new FormControl("", [Validators.required]),
    email:new FormControl("", [Validators.required,Validators.email])
  })

  remiter(){
    this.Service.remitterRegistration(this.remitterForm.value).subscribe(res => {
      this.responses = res;
      alert("Remitter registration registerd successfull")
      console.log(res)
      this.router.navigate(["/home"]);
    },
      error => {
        console.log(error)
        alert("registration faild..")
      }
    );
  }

}

