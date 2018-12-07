import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({providedIn: 'root'})
export class BikeShareService {

    private apiUrl = 'http://10.1.10.160:9090/api';

    constructor(
        private http: HttpClient
    ) {}

    registerService(body: any) {
        return this.http.post<any>(`${this.apiUrl}/register`,
        body,
        {observe: 'response'});
    }

    inquiryService(body: any) {
        return this.http.post<any>(`${this.apiUrl}/inquiry`,
        body,
        {observe: 'response'});
    }
}
