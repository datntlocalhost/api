import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { BikeShareService } from '../../bikeshare/bikeshare.service';
import { isNullOrUndefined } from 'util';

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html'
})
export class RegisterComponent {

    msgEmail = '';
    msgPassword = '';
    msgName = '';

    registerForm = new FormGroup({
        email: new FormControl(''),
        password: new FormControl(''),
        name: new FormControl('')
    });

    constructor(
        private service: BikeShareService
    ) {}

    onSubmit() {
        this.clearMsg();
        this.service.registerService(this.registerForm.value)
        .subscribe(
            response => {
                alert('Success');
            },
            error => {
                const value: any = error.error;
                for (const key in value) {
                    if (!isNullOrUndefined(key)) {
                        const temp: any[] = value[key];
                        temp.forEach(element => {
                            if (key === 'email') {
                                this.msgEmail += (element + '<br>');
                            } else if (key === 'password') {
                                this.msgPassword += (element + '<br>');
                            } else if (key === 'name') {
                                this.msgName += (element + '<br>');
                            }
                        });
                    }
                }
            }
        );
    }

    clearMsg() {
        this.msgEmail = '';
        this.msgPassword = '';
        this.msgName = '';
    }
}
