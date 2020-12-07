import { Component, Input, OnInit } from '@angular/core';
import { CallableGameDto, FizzBuzzGameControllerService, GameDto } from "fizzbuzz-client";
import { catchError, finalize } from "rxjs/operators";
import { HttpResponse } from "@angular/common/http";

@Component({
  selector: 'app-fizz-buzz',
  templateUrl: './fizz-buzz.component.html',
  styleUrls: ['./fizz-buzz.component.css']
})
export class FizzBuzzComponent implements OnInit {
  private static readonly GENERIC_ERROR_MESSAGE = 'Something gone wrong :( Try later, please!';

  loadingResults = false
  showResult = false
  errorMessage = ''
  inputError = ''

  game: GameDto | null = null

  constructor(private fizzBuzzClient: FizzBuzzGameControllerService) { }

  ngOnInit(): void {
  }

  load(goals: Array<number>) {
    this.loadingResults = true
    this.showResult = true
    this.fizzBuzzClient.roundsUsingGET(goals, "response", false)
        .pipe(
            catchError((err, caught) => {
              this.setGenericError()
              throw err
            }),
            finalize(() => this.loadingResults = false)
        ).subscribe(response => this.handleApiResponse(response))
  }

  private handleApiResponse(response: HttpResponse<GameDto>) {
    if(response.status === 400) {
      this.inputError = "You passed bad value here, check and try again"
      this.showResult = false
    } else if (response.status > 400 || response.body == null) {
      this.setGenericError()
    }

    if (response.status === 200 && response.body != null) {
      this.game = response.body;
    }
  }

  private setGenericError() {
    this.showResult = false
    this.errorMessage = FizzBuzzComponent.GENERIC_ERROR_MESSAGE
  }
}
