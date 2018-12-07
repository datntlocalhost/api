import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { RegisterComponent } from './bikeshare/register/register.component';
import { InquiryComponent } from './bikeshare/inquiry/inquiry.component';

@NgModule({
    imports: [
        RouterModule.forRoot([
            {
                path: '',
                component: AppComponent,
                children: [
                    {
                        path: 'register',
                        component: RegisterComponent
                    },
                    {
                        path: 'inquiry',
                        component: InquiryComponent
                    }
                ]
            },
            {
                path: '**',
                component: AppComponent
            }
        ])
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {}
