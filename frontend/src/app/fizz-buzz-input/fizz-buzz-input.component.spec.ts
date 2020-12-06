import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FizzBuzzInputComponent } from './fizz-buzz-input.component';

describe('FizzBuzzInputComponent', () => {
  let component: FizzBuzzInputComponent;
  let fixture: ComponentFixture<FizzBuzzInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FizzBuzzInputComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FizzBuzzInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
