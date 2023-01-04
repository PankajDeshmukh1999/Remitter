import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RemitterServiceService } from './remitter-service.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { RemitterRegistrationComponent } from './remitter-registration/remitter-registration.component';
import { BeneficiaryRegistrationComponent } from './beneficiary-registration/beneficiary-registration.component';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { ReportsComponent } from './reports/reports.component';
import { LogoutComponent } from './logout/logout.component';
import { SearchBeneficiaryComponent } from './search-beneficiary/search-beneficiary.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateBeneficiaryComponent } from './update-beneficiary/update-beneficiary.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    RemitterRegistrationComponent,
    BeneficiaryRegistrationComponent,
    FundTransferComponent,
    ReportsComponent,
    LogoutComponent,
    SearchBeneficiaryComponent,
    CreateUserComponent,
    UpdateBeneficiaryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [RemitterServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
