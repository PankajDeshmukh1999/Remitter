import { Injectable ,EventEmitter} from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Beneficiary } from './beneficiary';
@Injectable({
  providedIn: 'root'
})
export class RemitterServiceService {


  private http:HttpClient;

  // bene = new EventEmitter<Beneficiary[]|[]>();
 
   constructor(http1:HttpClient) {
        this.http=http1;
  }

           login=(data:any)=>{
            return this.http.post("http://localhost:8882/login",data)
           }

           remitterRegistration = (data:any) =>{
            return this.http.post("http://localhost:8899/registration/registration",data)
           }

           beneficiaryRegistration=(data:any)=>{
            return this.http.post("http://localhost:9988/Beneficiary/Beneficiary",data)
           }

           beneficiaryByAccountNumber=(accountNumber:number)=>{
            return this.http.get("http://localhost:9988/Beneficiary/accountNumber/"+accountNumber)
           }

           transaction=(data:any)=>{
            return this.http.post("http://localhost:9001/transactions/transaction",data);
           }

           getBeneficiary(){
            return this.http.get("http://localhost:9988/Beneficiary/getList")
           }

           repotsData(data1:any,data2:any){
            return this.http.get("http://localhost:9001/transaction/"+data1+"/"+data2)
           }

           createUser(Data:any){
            return this.http.post("http://localhost:8882/register/user",Data)
           }

           deleteBeneficiary(id:any){
            return this.http.delete("http://localhost:9988//Beneficiary/deleteById/"+id)
           }

          getById(bid:any){
            return this.http.get("http://localhost:9988/Beneficiary/ById/"+bid)
          }

          updateBeneficiary(bid:any,data:any){
            return this.http.put(`${"http://localhost:9988/Beneficiary/updateById"}/${bid}`,data)
          }
}
