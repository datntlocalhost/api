import { MethodParamModel } from './method-param.model';
import { MethodReturnModel } from './method.return.model';

export class MethodModel {
    id?: string;
    class?: string;
    name?: string;
    desc?: string;
    params?: MethodParamModel[];
    returns?: MethodReturnModel;
}
