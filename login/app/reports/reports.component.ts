import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { RemitterServiceService } from '../remitter-service.service';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit{
  private Service: RemitterServiceService;
  responses: any;
  constructor(Service1: RemitterServiceService, private router: Router) {
    this.Service = Service1;
  }

  ngOnInit(): void {
    
  }

  reportForm=new FormGroup({
    transactionId:new FormControl(),
    remitterAccountNumber:new FormControl(),
    beneficiaryAaccountNumber:new FormControl(),
    amount:new FormControl(),
    narration:new FormControl(),
    responceCode:new FormControl(),
    transactionDate:new FormControl()
  })

  dateForm=new FormGroup({
    fromDate:new FormControl(),
    toDate:new FormControl(),
    
  })
  
  getReport(){
    // console.log(this.reportForm.value.transactionDate)
    this.Service.repotsData(this.dateForm.value.fromDate,this.dateForm.value.toDate)
      .subscribe(res=>{
        this.responses=res;
        console.log(res)
        if(res==0){
          alert("no record found")
        }
      },
      error=>{
        console.log(error)
      }
      )
  }
}
