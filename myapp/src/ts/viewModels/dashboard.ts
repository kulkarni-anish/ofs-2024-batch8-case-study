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
import 'oj-c/button';

class DashboardViewModel {
  firstName: ko.Observable<string> | ko.Observable<any>;
  salary : ko.Observable<number> | ko.Observable<any>;
  city: ko.Observable<string> | ko.Observable<any>;
  email : ko.Observable<string> | ko.Observable<any>;
  valueNoClearIcon: ko.Observable<string>;
    valueClearIconNever: ko.Observable<string>;
    valueClearIconAlways: ko.Observable<string>;
    valueClearIconAlwaysRequired: ko.Observable<string>;
    valueClearIconConditional: ko.Observable<string>;
    rawValueClearIconConditional: ko.Observable<string>;
  
  constructor() {
    this.firstName = ko.observable(null);
    this.salary = ko.observable(null);
    this.city = ko.observable(null);
    this.email = ko.observable(null);
    this.valueNoClearIcon = ko.observable("");
    this.valueClearIconNever = ko.observable("");
    this.valueClearIconAlways = ko.observable("");
    this.valueClearIconAlwaysRequired = ko.observable("");
    this.valueClearIconConditional = ko.observable("");
    this.rawValueClearIconConditional = ko.observable("");
  }

  public handleClick = async (event:Event) =>{
    let element =(event.currentTarget as HTMLElement).tagName;

    alert("Button clicked is : "+ element);
    alert("Name= "+this.firstName()+", salary= "+this.salary());

    let id = parseInt(this.salary());

    let URL = "https://jsonplaceholder.typicode.com/users/"+id;

    let res = await fetch(URL);
    let jsonData = await res.json();
    console.log(jsonData);
    this.firstName(jsonData['name']);
    this.city(jsonData['address']['city']);
    this.email(jsonData['email']);
  }
}

export = DashboardViewModel;