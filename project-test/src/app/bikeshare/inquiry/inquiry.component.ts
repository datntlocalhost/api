import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { BikeShareService } from '../bikeshare.service';
import { isNullOrUndefined } from 'util';


@Component({
    selector: 'app-inquiry',
    templateUrl: './inquiry.component.html'
})
export class InquiryComponent {

    msgTitle = '';
    msgContent = '';
    msgLastNameHira = '';
    msgFirstNameHira = '';
    msgLastNameKata = '';
    msgFirstNameKata = '';
    msgEmail = '';


    inquiryForm = new FormGroup({
        title: new FormControl(''),
        content: new FormControl(''),
        lastNameHira: new FormControl(''),
        firstNameHira: new FormControl(''),
        lastNameKata: new FormControl(''),
        firstNameKata: new FormControl(''),
        email: new FormControl(''),
    });

    constructor(
        private service: BikeShareService
    ) {}

    onSubmit() {
        this.clearMsg();
        this.service.inquiryService(this.inquiryForm.value)
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
                            if (key === 'content') {
                                this.msgContent += element + '<br>';
                            } else if (key === 'lastNameHira') {
                                this.msgLastNameHira += element + '<br>';
                            } else if (key === 'firstNameHira') {
                                this.msgFirstNameHira += element + '<br>';
                            } else if (key === 'lastNameKata') {
                                this.msgLastNameKata += element + '<br>';
                            } else if (key === 'firstNameKata') {
                                this.msgFirstNameKata += element + '<br>';
                            } else if (key === 'email') {
                                this.msgEmail += element + '<br>';
                            }
                        });
                    }
                }
            }
        );
    }

    clearMsg() {
        this.msgTitle = '';
        this.msgContent = '';
        this.msgLastNameHira = '';
        this.msgFirstNameHira = '';
        this.msgLastNameKata = '';
        this.msgFirstNameKata = '';
        this.msgEmail = '';
    }
}
