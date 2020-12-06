import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { faHandPointRight } from "@fortawesome/free-solid-svg-icons";
import { FormControl, FormGroup, Validators } from "@angular/forms";

@Component({
    selector: 'app-fizz-buzz-input',
    templateUrl: './fizz-buzz-input.component.html',
    styleUrls: ['./fizz-buzz-input.component.css']
})
export class FizzBuzzInputComponent implements OnInit {
    icon = faHandPointRight

    @Input()
    disabled = false
    @Input()
    errorMessage = ""

    validationMessage = ""

    @Output()
    onSubmit = new EventEmitter<Array<number>>();

    submitted = false
    form = new FormGroup({
        goals: new FormControl('', [Validators.required])
    }, {updateOn: 'submit'});


    constructor() {
    }

    ngOnInit(): void {
    }

    clicked() {
        this.validationMessage = ""
        this.submitted = true
        console.log(this.form)
        if (this.form.valid) {
            try {
                let goals: Array<number> = this.form.value.goals
                    .split(',')
                    .map((s: String) => this.toInt(s));
                console.log(goals)
                this.onSubmit.emit(goals)
            } catch (e) {
                this.form.controls.goals.setErrors({format: true})
            }
        }
    }

    private toInt(s: String) {
        let number = Number(s.trim());
        if (isNaN(number)) throw 'number format'
        if (number < 1) {
            this.validationMessage = 'Zeros and negative numbers is not allowed! Get rid of ' + number + '.'
            throw 'validation'
        }
        return number;
    }
}
