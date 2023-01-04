import { Component, OnInit } from '@angular/core';
import { FormControl, FormControlName, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RemitterServiceService } from '../remitter-service.service';

@Component({
  selector: 'app-fund-transfer',
  templateUrl: './fund-transfer.component.html',
  styleUrls: ['./fund-transfer.component.css']
})
export class FundTransferComponent implements OnInit {

  private Service: RemitterServiceService;
  responses: any
  constructor(Service1: RemitterServiceService, private router: Router) {
    this.Service = Service1;
  }
  ngOnInit(): void {
    
  }

  transactionForm=new  FormGroup({
    remitterAccountNumber:new FormControl("",[(Validators.required)]),
    beneficiaryAaccountNumber:new FormControl("",[(Validators.required)]),
    amount:new FormControl("",[(Validators.required)]),
    narration:new FormControl("",[(Validators.required)])
  })

  fundTransfer(){
    this.Service.transaction(this.transactionForm.value).subscribe(res => {
      this.responses = res;
      console.log(res);
      if(res==null){
        alert("value is null")
      }else{
      alert("Transaction is successfull");
      this.router.navigate(["/home"]);
      }
    },
      error => {
        console.log(error)
        alert("Transaction faild......")
      }
    );

    }
}
