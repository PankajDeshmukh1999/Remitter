import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router,ActivatedRoute } from '@angular/router';
import { Beneficiary } from '../beneficiary';
import { RemitterServiceService } from '../remitter-service.service';

@Component({
  selector: 'app-search-beneficiary',
  templateUrl: './search-beneficiary.component.html',
  styleUrls: ['./search-beneficiary.component.css']
})
export class SearchBeneficiaryComponent implements OnInit {
  

  response:any;
  constructor(private router: Router, private service:RemitterServiceService) { }

  ngOnInit(): void {
    this.getList()
  }

  beneficiaryForm = new FormGroup({
    Bid:new FormControl(),
    name: new FormControl(),
    accountNumber: new FormControl(),
    transferLimit: new FormControl(),
    ifscCode: new FormControl(),
    email: new FormControl(),
    address: new FormControl(),
    accountStatus: new FormControl()
  })

  bform= new FormGroup({
    accountNumber:new FormControl()
  })

  getList(){
    this.service.getBeneficiary().subscribe(res=>{
      this.response=res;
      console.log(res)
    },
    error=>{
      console.warn(error)
    }
    )
  }

  dropDown(){
    this.service.beneficiaryByAccountNumber(this.beneficiaryForm.value.accountNumber).subscribe(res=>{
      this.response=res;
      // this.beneficiaryForm.controls.accountNumber.setValue(this.response.accountNumber)
      if(res==null){
        alert("Account number not valid")
      }
      console.log(this.response)
    },
    error=>{
      console.warn(error)
    })
  }

  deleteBeneficiary(id:any){
    this.service.deleteBeneficiary(id).subscribe(res=>{
      this.response=res
      if(res==1){
        alert("record deleted")
        console.log(res)
        this.router.navigate(['/search'])
      }else{
        alert("record not found")
      }
    },
    error=>{
      console.warn(error)
    }
    );
  }

}
