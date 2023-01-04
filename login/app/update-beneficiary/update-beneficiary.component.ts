import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RemitterServiceService } from '../remitter-service.service';

@Component({
  selector: 'app-update-beneficiary',
  templateUrl: './update-beneficiary.component.html',
  styleUrls: ['./update-beneficiary.component.css']
})
export class UpdateBeneficiaryComponent implements OnInit{

  response:any;
  constructor(private router: ActivatedRoute, private service:RemitterServiceService,private router1:Router) { }

  beneficiaryForm = new FormGroup({
    name: new FormControl(),
    accountNumber: new FormControl(),
    transferLimit: new FormControl(),
    ifscCode: new FormControl(),
    email: new FormControl(),
    address: new FormControl(),
    accountStatus: new FormControl(),
    amount:new FormControl()
  })


  ngOnInit(): void {
   console.log(this.router.snapshot.params['bid'])
   this.service.getById(this.router.snapshot.params['bid']).subscribe((result:any)=>{
    this.beneficiaryForm = new FormGroup({
      name: new FormControl(result['name']),
      accountNumber: new FormControl(result['accountNumber']),
      transferLimit: new FormControl(result['transferLimit']),
      ifscCode: new FormControl(result['ifscCode']),
      email: new FormControl(result['email']),
      address: new FormControl(result['address']),
      accountStatus: new FormControl(result['accountStatus']),
      amount:new FormControl(result['amount'])
    })
   })
  }

  beneficiary(){
    this.service.updateBeneficiary(this.router.snapshot.params['bid'],this.beneficiaryForm.value).subscribe(result=>{
      console.log(result)
    });
    alert("update Success")
    this.router1.navigate(['/search'])
  }

}
