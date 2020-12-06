import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FizzBuzzOutputComponent } from './fizz-buzz-output.component';

describe('FizzBuzzOutputComponent', () => {
  let component: FizzBuzzOutputComponent;
  let fixture: ComponentFixture<FizzBuzzOutputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FizzBuzzOutputComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FizzBuzzOutputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
