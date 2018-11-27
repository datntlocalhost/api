import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { MethodParamModel } from 'src/shared/model/method-param.model';
import { isNullOrUndefined } from 'util';
import { Constants } from 'src/shared/common/constants';
import { ValidationRequestModel } from 'src/shared/model/request/validation-request.model';

@Injectable({ providedIn: 'root' })
export class ComfService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  loadClassModel(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/validator`, {
      observe: 'response'
    });
  }

  checkValidation(className: string, methodId: string, params: any[]): Observable<any> {

    const body: ValidationRequestModel = new ValidationRequestModel();
    body.className = className;
    body.methodId = methodId;
    body.parameters = params;

    return this.http.post<any>(
      `${this.apiUrl}/validator`,
      body, {
        observe: 'response'
    });
  }

  matchParameters(input: any[], params: MethodParamModel[]): any[] {
    const array: any[] = new Array();

    if (isNullOrUndefined(input) || isNullOrUndefined(params)) {
      return null;
    }

    for (let i = 0; i < input.length; i++) {
      const value = this.castParameter(input[i], params[i].type);
      if (value !== undefined) {
        array.push(value);
      } else {
        return null;
      }
    }

    return array;
  }

  castParameter(data: any, type: string) {
    if (isNullOrUndefined(data) || isNullOrUndefined(type)) {
      return undefined;
    }

    switch (type) {
      case 'int':
      case 'Integer':
      case 'long':
      case 'Long':
      case 'float':
      case 'Float':
      case 'double':
      case 'Double':
        return this.stringToNumber(data);
      case 'boolean':
      case 'Boolean':
        return this.stringToBoolean(data);
      case 'String':
        return this.stringToNull(data);
      default:
        return undefined;
    }
  }

  stringToBoolean(str: string) {
    let result = null;

    if (isNullOrUndefined(str)) {
      return result;
    }

    if (str.trim() === Constants.TRUE) {
      result = true;
    } else if (str.trim() === Constants.FALSE) {
      result = false;
    }
    return result;
  }

  stringToNumber(str: string) {
    const result = null;

    if (isNullOrUndefined(str)) {
      return result;
    }

    if (isNaN(+(str.trim()))) {
      return result;
    }

    return +(str.trim());
  }

  stringToNull(str: string) {
    return str === Constants.NULL ? null : str;
  }
}
