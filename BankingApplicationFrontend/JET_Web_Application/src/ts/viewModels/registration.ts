/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as ko from "knockout";
import "oj-c/input-text";
import "ojs/ojknockout";
import "oj-c/input-number";
import "ojs/ojformlayout";
import "oj-c/form-layout";
import "oj-c/input-password";
import 'oj-c/button';


type BankCustomer = { 
  fullName: string;
  addressL1: string;
  addressL2: string;
  addressL3: string;
  city: string;
  state: string;
  zip: number;
  phone: number
}

class RegistrationViewModel {
  inputFullName: ko.Observable<string> | ko.Observable<any>;
  inputAddressL1: ko.Observable<string> | ko.Observable<any>;
  inputAddressL2: ko.Observable<string> | ko.Observable<any>;
  inputAddressL3: ko.Observable<string> | ko.Observable<any>;
  inputCity: ko.Observable<string> | ko.Observable<any>;
  inputState: ko.Observable<string> | ko.Observable<any>;
  inputZip: ko.Observable<number> | ko.Observable<any>;
  inputPhone: ko.Observable<number> | ko.Observable<any>;

  constructor() {
    this.inputFullName = ko.observable(null);
    this.inputAddressL1 = ko.observable(null);
    this.inputAddressL2 = ko.observable(null);
    this.inputAddressL3 = ko.observable(null);
    this.inputCity = ko.observable(null);
    this.inputState = ko.observable(null);
    this.inputZip = ko.observable(null);
    this.inputPhone = ko.observable(null);
  }

  public handleClick = async (event: Event) => {

    let URL = "http://localhost:8080/registration/customer";

    const customer: BankCustomer = {
      fullName: this.inputFullName(),
      addressL1: this.inputAddressL1(),
      addressL2: this.inputAddressL2(),
      addressL3: this.inputAddressL3(),
      city: this.inputCity(),
      state: this.inputState(),
      zip: this.inputZip(),
      phone: this.inputPhone(),
    };

    console.log(customer);
    const requestBody = JSON.stringify(customer);
    console.log(requestBody);

    try {
      const response = await fetch(URL, {
        method: "POST",
        headers: {
          "Content-type": "application/json; charset=UTF-8",
        },
        body: requestBody,
        mode: "cors",
      });

      if (response.ok) {
        const addedRow = await response.json();
        console.log("Added row:", addedRow);
        window.location.href = '?ojr=login'; // redirect to login page

      } else {
        console.error("Error adding row:", response.status, response.statusText);
      }
    } catch (error) {
      console.error("Error adding row:", error);
    }
  };
}

export = RegistrationViewModel;
