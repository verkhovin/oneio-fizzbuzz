import { Component, Input, OnInit } from '@angular/core';
import { GameDto } from "fizzbuzz-client";


@Component({
  selector: 'app-fizz-buzz-output',
  templateUrl: './fizz-buzz-output.component.html',
  styleUrls: ['./fizz-buzz-output.component.css']
})
export class FizzBuzzOutputComponent implements OnInit {

  @Input()
  game: GameDto | null = null


  constructor() { }

  ngOnInit(): void {
  }
}
