import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { MethodParamModel } from 'src/shared/model/method-param.model';
import { isNullOrUndefined } from 'util';
import { Constants } from 'src/shared/common/constants';
import { ValidationRequestModel } from 'src/shared/model/request/validation-request.model';
import { LocalStorageService } from 'ngx-store';
import { MethodModel } from 'src/shared/model/method.model';

@Injectable({ providedIn: 'root' })
export class ComfService {
  private apiUrl = 'http://10.1.10.160:8080/comf-api/api';

  constructor(
    private http: HttpClient,
    private $localStorage: LocalStorageService
  ) {}

  loadClassModel(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/validator`, {
      observe: 'response'
    });
  }

  checkValidation(
    className: string,
    methodId: string,
    params: any[]
  ): Observable<any> {
    const body: ValidationRequestModel = new ValidationRequestModel();
    body.className = className;
    body.methodId = methodId;
    body.parameters = params;

    return this.http.post<any>(`${this.apiUrl}/validator`, body, {
      observe: 'response'
    });
  }

  storeLocal(key: string, value: any) {
    this.$localStorage.set(key, value);
  }

  searchMethod(methodName: string) {
    const methods: MethodModel[] = new Array();
    const storedValues: MethodModel[] = this.$localStorage.get('methods');

    if (!isNullOrUndefined(storedValues) && storedValues.length > 0) {
      storedValues.forEach(value => {
        if (value.name === methodName) {
          methods.push(value);
        }
      });
    }
    return methods;
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
        return this.stringToNumber(data, false);
      case 'int[]':
      case 'Integer[]':
      case 'long[]':
      case 'Long[]':
      case 'float[]':
      case 'Float[]':
      case 'double[]':
      case 'Double[]':
        return this.stringToNumber(data, true);
      case 'boolean':
      case 'Boolean':
        return this.stringToBoolean(data, false);
      case 'boolean[]':
      case 'Boolean[]':
        return this.stringToBoolean(data, true);
      case 'String':
        return this.stringToNull(data, false);
      case 'String[]':
        return this.stringToNull(data, true);
      default:
        return undefined;
    }
  }

  stringToBoolean(str: string, isArray: boolean) {
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

  stringToNumber(str: string, isArray: boolean) {
    const result = null;

    if (isNullOrUndefined(str)) {
      return result;
    }

    if (isNaN(+str.trim())) {
      return result;
    }

    return +str.trim();
  }

  stringToNull(str: string, isArray: boolean) {
    if (isArray) {
      const params: any[] = new Array();
      const strs = str.split(Constants.REGEX_PARAM);

      strs.forEach(value => {
        params.push(value === 'null' ? null : value);
      });

      return params;
    }

    return str === Constants.STR_NULL ? null : str;
  }
}
