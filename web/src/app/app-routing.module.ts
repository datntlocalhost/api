import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { RegisterComponent } from './comf/register/register.component';
import { InquiryComponent } from './comf/inquiry/inquiry.component';

@NgModule({
    imports: [
        RouterModule.forRoot([
            {
                path: '',
                component: AppComponent
            },
            {
                path: 'register',
                data: {
                    pageTitle: 'ログイン  | CycleTrip'
                },
                component: RegisterComponent
            }
        ],
        { useHash: false},
        )
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {}
