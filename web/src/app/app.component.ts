import { Component, OnInit } from '@angular/core';
import { ComfService } from './comf/comf.service';
import { ClassModel } from 'src/shared/model/class.model';
import { isNullOrUndefined } from 'util';
import { MethodModel } from 'src/shared/model/method.model';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MethodParamModel } from 'src/shared/model/method-param.model';
import { Constants } from 'src/shared/common/constants';
import { ResponseModel } from 'src/shared/model/response/response.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'comf-web';

  class: ClassModel[] = new Array();
  methods: MethodModel[] = new Array();

  classInfo: ClassModel;
  methodInfo: MethodModel;

  formInput: FormGroup;

  formSearch: FormGroup = new FormGroup({
    methodName: new FormControl(Constants.BLANK, [])
  });

  resultMessage: string;

  constructor(private comfService: ComfService) {}

  ngOnInit() {
    this.formInput = null;
    this.callApi();
  }

  callApi() {
    this.comfService.loadClassModel().subscribe(
      response => {
        if (!isNullOrUndefined(response.body)) {
          this.setUpData(response.body.result);
        }
      },
      error => {}
    );
  }

  setUpData(data: ClassModel[]) {
    if (!isNullOrUndefined(data) && data.length > 0) {
      this.class = data;
      data.forEach(value1 => {
        this.initMethod(value1);
      });
      this.comfService.storeLocal('methods', this.methods);
    }
  }

  onClickClass(event) {
    this.formInput = null;
    this.resultMessage = null;
    const className: string = event.target.innerText;
    if (!isNullOrUndefined(className)) {
      this.methodInfo = null;
      if (className === 'All') {
        this.methods = new Array();
        this.classInfo = null;
        this.class.forEach(value => {
          this.initMethod(value);
        });
      } else {
        this.class.forEach(value => {
          if (value.name === className) {
            this.classInfo = value;
            this.methods = new Array();
            this.initMethod(this.classInfo);
            return;
          }
        });
      }
    }
  }

  onClickMethod(event) {
    const methodId: string = event.target.id;
    const methodName: string = event.target.innerText;
    this.resultMessage = null;
    if (!isNullOrUndefined(methodId)) {
      this.classInfo = null;
      this.methods.forEach(value => {
        if (value.id === methodId && value.name === methodName) {
          this.methodInfo = value;
          return;
        }
      });
      this.initForm(this.methodInfo);
    }
  }

  onSubmitSearch() {
    const searchValue: string = this.formSearch.controls.methodName.value;
    if (searchValue.trim().length > 0) {
      this.methods = this.comfService.searchMethod(searchValue);
    }
  }

  onSubmitCheck() {
    const paramsInput: any = this.formInput.value;
    const paramsKey: string[] = Object.keys(paramsInput);
    const paramsValue: any[] = new Array();

    paramsKey.forEach(value => {
      paramsValue.push(paramsInput[value]);
    });

    const statement: string = this.generateStatement(paramsValue);

    console.log(statement);

    this.comfService
      .checkValidation(
        this.methodInfo.class,
        this.methodInfo.id,
        this.comfService.matchParameters(paramsValue, this.methodInfo.params)
      )
      .subscribe(
        response => {
          const result: ResponseModel = response.body;
          this.resultMessage = this.generateResultMessage(
            statement,
            result.result,
            true
          );
        },
        error => {
          const result: ResponseModel = error.error;
          this.resultMessage = this.generateResultMessage(
            statement,
            result.error,
            false
          );
        }
      );
  }

  initMethod(clazz: ClassModel) {
    const method: MethodModel[] = clazz.methods;
    if (!isNullOrUndefined(method)) {
      method.forEach(value => {
        value.class = clazz.name;
        this.methods.push(value);
      });
    }
  }

  initForm(method: MethodModel) {
    if (!isNullOrUndefined(method)) {
      const params: MethodParamModel[] = method.params;
      const formControls: any = {};
      params.forEach(value => {
        formControls[value.name] = new FormControl(
          Constants.BLANK,
          Validators.required
        );
      });
      this.formInput = new FormGroup(formControls);
    }
  }

  // pressKeyEvent(event) {
  //   if (!isNullOrUndefined(event) && !isNullOrUndefined(event.code)) {
  //     switch (event.key) {
  //       case Constants.KEY_ENTER:
  //         this.executeEnterKey();
  //         break;
  //       case Constants.KEY_ARROW_UP:
  //         this.executeKeyArrow(true);
  //         break;
  //       case Constants.KEY_ARROW_DOWN:
  //         this.executeKeyArrow(false);
  //         break;
  //       default:
  //         break;
  //     }
  //   }
  // }

  // executeEnterKey() {

  //   this.line = Constants.BLANK;
  //   const input: string = this.terminalInput.nativeElement.value || Constants.BLANK;
  //   const paramStrings = input.split(Constants.SYMBOL_COMMA);
  //   const statement = this.generateStatement(paramStrings);

  //   this.input.push(input);
  //   this.index = this.input.length;

  //   if (paramStrings.length === this.methodInfo.params.length) {

  //     const params: any[] = this.comfService.matchParameters(paramStrings, this.methodInfo.params);

  //     if (!isNullOrUndefined(params)) {
  //       this.comfService.checkValidation(this.methodInfo.class, this.methodInfo.id, params).subscribe(
  //         response => {
  //           const value: ResponseModel = response.body;
  //           if (!isNullOrUndefined(value)) {
  //             if (!isNullOrUndefined(value.result)) {
  //               this.line = this.generateMessage(statement, value.result, true);
  //             }
  //           }
  //         },
  //         error => {
  //           const value: ResponseModel = error.error;
  //           if (!isNullOrUndefined(value)) {
  //             if (!isNullOrUndefined(value.error)) {
  //               this.line = this.generateMessage(statement, value.error, false);
  //             }
  //           }
  //         }
  //       );
  //     } else {
  //       this.line = this.generateMessage(statement, 'Parameter not matches.', false);
  //     }
  //   } else {
  //     this.line = this.generateMessage(statement, 'Parameter not matches.', false);
  //   }
  //   this.terminalInput.nativeElement.value = Constants.BLANK;
  // }

  // executeKeyArrow(direction: boolean) {
  //   this.index = direction ? this.index - 1 : this.index + 1;
  //   if (this.index < 0) {
  //     this.index = this.input.length;
  //   } else if (this.index >= this.input.length) {
  //     this.index = 0;
  //   }
  //   this.terminalInput.nativeElement.value = this.input[this.index] || Constants.BLANK;
  // }

  generateStatement(params: string[]) {
    if (isNullOrUndefined(params)) {
      return Constants.BLANK;
    }

    let statement = Constants.STR_STATEMENT_FORMAT.replace(
      '%s',
      this.methodInfo.name
    );
    let paramString = Constants.BLANK;

    for (let i = 0; i < params.length; i++) {
      if (i === params.length - 1) {
        paramString +=
          this.methodInfo.params[i].type === Constants.TYPE_STRING &&
          params[i] !== Constants.STR_NULL
            ? Constants.SYMBOL_DOUBLE_QUOTE +
              params[i] +
              Constants.SYMBOL_DOUBLE_QUOTE
            : params[i];
      } else {
        paramString +=
          this.methodInfo.params[i].type === Constants.TYPE_STRING &&
          params[i] !== Constants.STR_NULL
            ? Constants.SYMBOL_DOUBLE_QUOTE +
              params[i] +
              Constants.SYMBOL_DOUBLE_QUOTE +
              Constants.SYMBOL_COMMA
            : params[i] + Constants.SYMBOL_COMMA;
      }
    }

    statement = statement.replace('%p', paramString);
    return statement;
  }

  generateResultMessage(statement: string, result: string, type: boolean) {
    let msg: string =
      statement + Constants.ELEMENT_NEWLINE + Constants.SYMBOL_ENTER;
    if (type) {
      msg += Constants.RESULT;
    } else {
      msg += Constants.ERROR;
    }
    return (msg += result);
  }
}
