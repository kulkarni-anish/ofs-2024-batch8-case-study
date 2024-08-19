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


type LoginDetails = { 
  username: string;
  password: string;
}

class RegistrationViewModel {
    inputUsername: ko.Observable<string> | ko.Observable<any>;
    inputPassword: ko.Observable<string> | ko.Observable<any>;


  constructor() {
    this.inputUsername = ko.observable(null);
    this.inputPassword = ko.observable(null);
  }

  public handleClick = async (event: Event) => {

    let URL = "http://localhost:8080/login";

    const login: LoginDetails = {
      username: this.inputUsername(),
      password: this.inputPassword(),
    };

    console.log(login);
    const requestBody = JSON.stringify(login);
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
        if (addedRow['loggedIn'] === true) {
          console.log("Logged in", addedRow);
          // Save customerId in sessionStorage
          sessionStorage.setItem('customerId', addedRow.customerId);
          // Redirect to dashboard page
          window.location.href = '/?ojr=dashboard';
        }
        else {
            console.log("Incorrect password");
            alert("Incorrect password. Please try again.");
          }
      } else {
        console.error("Error adding row:", response.status, response.statusText);
      }
    } catch (error) {
      console.error("Error adding row:", error);
    }
  };
}

export = RegistrationViewModel;
