import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ApiModule, BASE_PATH } from 'fizzbuzz-client';
import { HttpClientModule } from '@angular/common/http';
import { NgbAlertModule, NgbModule, NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FizzBuzzComponent } from './fizz-buzz/fizz-buzz.component';
import { FizzBuzzInputComponent } from './fizz-buzz-input/fizz-buzz-input.component';
import { FizzBuzzOutputComponent } from './fizz-buzz-output/fizz-buzz-output.component';

@NgModule({
    declarations: [
        AppComponent,
        FizzBuzzComponent,
        FizzBuzzInputComponent,
        FizzBuzzOutputComponent
    ],
    imports: [
        BrowserModule,
        ApiModule,
        HttpClientModule,
        NgbModule,
        NgbPaginationModule,
        NgbAlertModule,
        FontAwesomeModule,
        ReactiveFormsModule
    ],
    providers: [{
        provide: BASE_PATH, useValue: 'http://localhost:8080'
    }],
    bootstrap: [AppComponent]
})
export class AppModule {
}
