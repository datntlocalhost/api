import {
  Component,
  OnInit,
  ViewChild,
  AfterViewInit,
  ElementRef
} from '@angular/core';
import { ComfService } from './comf/comf.service';
import { ClassModel } from 'src/shared/model/class.model';
import { isNullOrUndefined } from 'util';
import { MethodModel } from 'src/shared/model/method.model';
import { ResponseModel } from 'src/shared/model/response/response.model';
import { Constants } from 'src/shared/common/constants';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {
  title = 'comf-web';

  @ViewChild('terminalInput') terminalInput: ElementRef;

  banner: string;

  class: ClassModel[] = new Array();
  methods: MethodModel[] = new Array();

  classInfo: ClassModel;
  methodInfo: MethodModel;

  terminal = false;

  line;

  index;

  input: any[];

  constructor(
    private comfService: ComfService
  ) {}

  ngOnInit() {
    this.banner = 'baner';
    this.index = 0;
    this.input = new Array();
    this.callApi();
  }

  ngAfterViewInit() {
    if (!isNullOrUndefined(this.terminalInput)) {
      this.terminalInput.nativeElement.focus();
    }
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
    }
  }

  onClickClass(event) {
    const className: string = event.target.innerText;
    this.banner = Constants.BLANK;
    this.line = Constants.BLANK;
    this.terminal = false;
    if (!isNullOrUndefined(className)) {
      this.methodInfo = null;
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

  onClickMethod(event) {
    const methodId: string = event.target.id;
    this.banner = Constants.BLANK;
    this.line = Constants.BLANK;
    this.terminal = true;
    if (!isNullOrUndefined(this.terminalInput)) {
      this.terminalInput.nativeElement.focus();
    }
    if (!isNullOrUndefined(methodId)) {
      this.classInfo = null;
      this.methods.forEach(value => {
        if (value.id === methodId) {
          this.methodInfo = value;
          return;
        }
      });
    }
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

  // generateStatement(params: string[]) {

  //   if (isNullOrUndefined(params)) {
  //     return Constants.BLANK;
  //   }

  //   let statement = Constants.STR_STATEMENT_FORMAT.replace('%s', this.methodInfo.name);
  //   let paramString = Constants.BLANK;

  //   for (let i = 0; i < params.length; i++) {
  //     if (i === params.length - 1) {
  //       paramString += (this.methodInfo.params[i].type === 'String' && params[i] !== 'null' ?
  //       Constants.SYMBOL_DOUBLE_QUOTE + params[i] + Constants.SYMBOL_DOUBLE_QUOTE :
  //       params[i]);
  //     } else {
  //       paramString += (this.methodInfo.params[i].type === 'String' && params[i] !== 'null' ?
  //       Constants.SYMBOL_DOUBLE_QUOTE + params[i] + Constants.SYMBOL_DOUBLE_QUOTE + Constants.SYMBOL_COMMA :
  //       params[i] + Constants.SYMBOL_COMMA);
  //     }
  //   }

  //   statement = statement.replace('%p', paramString);
  //   return statement;
  // }

  // generateMessage(statement: string, result: string, type: boolean) {
  //   let msg: string = statement + Constants.ELEMENT_NEWLINE + Constants.SYMBOL_ENTER;
  //   if (type) {
  //     msg += Constants.RESULT;
  //   } else {
  //     msg += Constants.ERROR;
  //   }
  //   return msg += result;
  // }
}
