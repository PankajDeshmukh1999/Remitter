import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RemitterServiceService } from '../remitter-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  private Service: RemitterServiceService;
  constructor(Service1: RemitterServiceService, private router: Router) {
    this.Service = Service1;
  }
  ngOnInit(): void {
  }

  logout(){
    localStorage.removeItem('default')
  }

}
