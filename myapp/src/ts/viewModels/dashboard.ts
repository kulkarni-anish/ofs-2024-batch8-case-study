/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import "oj-c/input-text";
import "ojs/ojknockout";
import "oj-c/input-number";
import "ojs/ojformlayout";
import "oj-c/input-password";

class DashboardViewModel {
  firstName: ko.Observable<string> | ko.Observable<any>;
  salary : ko.Observable<number> | ko.Observable<any>;
  valueNoClearIcon: ko.Observable<string>;
    valueClearIconNever: ko.Observable<string>;
    valueClearIconAlways: ko.Observable<string>;
    valueClearIconAlwaysRequired: ko.Observable<string>;
    valueClearIconConditional: ko.Observable<string>;
    rawValueClearIconConditional: ko.Observable<string>;
  
  constructor() {
    this.firstName = ko.observable(null);
    this.salary = ko.observable(null);
    this.valueNoClearIcon = ko.observable("");
      this.valueClearIconNever = ko.observable("");
      this.valueClearIconAlways = ko.observable("");
      this.valueClearIconAlwaysRequired = ko.observable("");
      this.valueClearIconConditional = ko.observable("");
      this.rawValueClearIconConditional = ko.observable("");

  }
}

export = DashboardViewModel;