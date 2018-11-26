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
import { ValidationRequestModel } from 'src/shared/model/request/validation-request.model';

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

  constructor(private comfService: ComfService) {}

  ngOnInit() {
    this.banner = 'baner';
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
    const methodName: string = event.target.innerText;
    this.banner = Constants.BLANK;
    this.line = Constants.BLANK;
    this.terminal = true;
    if (!isNullOrUndefined(this.terminalInput)) {
      this.terminalInput.nativeElement.focus();
    }
    if (!isNullOrUndefined(methodName)) {
      this.classInfo = null;
      this.methods.forEach(value => {
        if (value.name === methodName) {
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

  presskey(event) {
    if (!isNullOrUndefined(event) && !isNullOrUndefined(event.code)) {
      if (event.key === Constants.KEY_ENTER) {
        const input: string = this.terminalInput.nativeElement.value;
        this.line = Constants.BLANK;
        if (!isNullOrUndefined(input)) {
          const array: string[] = input.split(Constants.SYMBOL_COMMA);
          let statement: string =
            this.methodInfo.name + Constants.SYMBOL_OPEN_BRACKET;
          for (let i = 0; i < array.length; i++) {
            if (i === array.length - 1) {
              statement += array[i];
            } else {
              statement += array[i] + Constants.SYMBOL_COMMA;
            }
          }
          statement += Constants.SYMBOL_CLOSE_BRACKET;
          if (array.length === this.methodInfo.params.length) {
            const params: any[] = this.comfService.matchParameters(array, this.methodInfo.params);
            if (!isNullOrUndefined(params)) {
              const body: ValidationRequestModel = new ValidationRequestModel();
              body.className = this.methodInfo.class;
              body.methodId = this.methodInfo.id;
              body.parameters = params;
              this.comfService.checkValidation(body).subscribe(
                response => {
                  const value: ResponseModel = response.body;
                  if (!isNullOrUndefined(value)) {
                    if (!isNullOrUndefined(value.result)) {
                      this.line = this.generateMessage(statement, value.result, true);
                    }
                  }
                },
                error => {
                  const value: ResponseModel = error.error;
                  if (!isNullOrUndefined(value)) {
                    if (!isNullOrUndefined(value.error)) {
                      this.line = this.generateMessage(statement, value.error, false);
                    }
                  }
                }
              );
            } else {
              this.line = this.generateMessage(statement, 'Parameter not matches.', false);
            }
          } else {
            this.line = this.generateMessage(statement, 'Parameter not matches.', false);
          }
          this.terminalInput.nativeElement.value = Constants.BLANK;
        }
      }
    }
  }

  generateMessage(statement: string, result: string, type: boolean) {
    let msg: string = statement + Constants.ELEMENT_NEWLINE + Constants.SYMBOL_ENTER;
    if (type) {
      msg += Constants.RESULT;
    } else {
      msg += Constants.ERROR;
    }
    return msg += result;
  }
}
