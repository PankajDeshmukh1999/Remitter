import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RemitterServiceService } from '../remitter-service.service';

@Component({
  selector: 'app-beneficiary-registration',
  templateUrl: './beneficiary-registration.component.html',
  styleUrls: ['./beneficiary-registration.component.css']
})
export class BeneficiaryRegistrationComponent implements OnInit {

  private Service: RemitterServiceService;
  responses: any
  constructor(Service1: RemitterServiceService, private router: Router) {
    this.Service = Service1;
  }

  ngOnInit(): void {

  }

  beneficiaryForm = new FormGroup({
    name: new FormControl("",[(Validators.required)]),
    accountNumber: new FormControl("",[(Validators.required)]),
    transferLimit: new FormControl("",[(Validators.required)]),
    ifscCode: new FormControl("",[(Validators.required)]),
    email: new FormControl("",[(Validators.required),(Validators.email)]),
    address: new FormControl("",[(Validators.required)]),
    accountStatus: new FormControl("",[(Validators.required)])
  })

  beneficiary() {
    this.Service.beneficiaryRegistration(this.beneficiaryForm.value).subscribe(res => {
      this.responses = res;
      console.log(res);
      alert("Beneficiary Registration successfull");
      this.router.navigate(["/home"]);
    },
      error => {
        console.log(error)
        alert("Registration faild......")
      }
    );

   
    

  }

}
