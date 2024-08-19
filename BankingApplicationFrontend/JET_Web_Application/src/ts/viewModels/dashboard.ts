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
import "ojs/ojtable";

import { RESTDataProvider } from "ojs/ojrestdataprovider";


type Account = {
  accountId: number;
  accountIsApproved: boolean;
  accountType: string;
  rateOfInterest: number;
  openingDate: string;
  minBalance: number;
  currentBalance: number;
  overdraftBalance: number;
  maximumOverdraft: number;
  customerId: number;
}
type K = Account["accountId"];

class DashboardViewModel {
  inputAccountId: ko.Observable<number> | ko.Observable<any>;
  inputAccountIsApproved: ko.Observable<boolean> | ko.Observable<any>;
  inputAccountType: ko.Observable<string> | ko.Observable<any>;
  inputRateOfInterest: ko.Observable<number> | ko.Observable<any>;
  inputOpeningDate: ko.Observable<string> | ko.Observable<any>;
  inputMinBalance: ko.Observable<number> | ko.Observable<any>;
  inputCurrentBalance: ko.Observable<number> | ko.Observable<any>;
  inputOverdraftBalance: ko.Observable<number> | ko.Observable<any>;
  inputMaximumOverdraft: ko.Observable<number> | ko.Observable<any>;
  inputCustomerId: ko.Observable<number> | ko.Observable<any>;
  depamount: ko.Observable<number> | ko.Observable<any>;
  withamount: ko.Observable<number> | ko.Observable<any>;



  dataprovider: RESTDataProvider<K, Account>;
    keyAttributes = "id";
    url = "http://localhost:8080/accounts";

  constructor() {
    this.inputAccountId = ko.observable(null);
    this.inputAccountIsApproved = ko.observable(null);
    this.inputAccountType = ko.observable(null);
    this.inputRateOfInterest = ko.observable(null);
    this.inputOpeningDate = ko.observable(null);
    this.inputMinBalance = ko.observable(null);
    this.inputCurrentBalance = ko.observable(null);
    this.inputOverdraftBalance = ko.observable(null);
    this.inputMaximumOverdraft = ko.observable(null);
    this.inputCustomerId = ko.observable(null);
    this.depamount = ko.observable(null);
    this.withamount = ko.observable(null);
    this.dataprovider = new RESTDataProvider({
      keyAttributes: this.keyAttributes,
      url: this.url,

      transforms: {
          fetchFirst: {
              request: async (options) => {
                const url = new URL(options.url);
                const { size, offset } = options.fetchParameters;
                const customerId = sessionStorage.getItem('customerId');
                if (customerId) {
                  url.searchParams.set("customerId", customerId);
                }
                return new Request(url.href);
              },
              response: async ({ body }) => {
                  console.log(body)
                  let res = {'data':body}
                  return res;
              },
          },
      }
    });
    
  }
  public navigateToAccount = async (event: any) => {
    const context: any = event.detail.context;
    const accountId = context.data.accountId;
    console.log(accountId)

    try {
      const response = await fetch("http://localhost:8080/accounts/"+accountId, {
        method: "GET",
        headers: {
          "Content-type": "application/json; charset=UTF-8",
        },
        mode: "cors",
      });

      if (response.ok) {
        const res = await response.json();
        this.inputAccountId(res["accountId"]);
        this.inputAccountIsApproved(res["accountIsApproved"]);
        this.inputAccountType(res["accountType"]);
        this.inputRateOfInterest(res["rateOfInterest"]);
        this.inputOpeningDate(res["openingDate"]);
        this.inputMinBalance(res["minBalance"]);
        this.inputCurrentBalance(res["currentBalance"]);
        this.inputOverdraftBalance(res["overdraftBalance"]);
        this.inputMaximumOverdraft(res["maximumOverdraft"]);
        this.inputCustomerId(res["customerId"]);
        sessionStorage.setItem('accountId', accountId);

      } else {
        console.error("Error getting row:", response.status, response.statusText);
      }
    } catch (error) {
      console.error("Error getting row:", error);
    }
  };


  public deposit = async (event: any) => {
    try {
      const response = await fetch("http://localhost:8080/accounts/deposit", {
        method: "POST",
        headers: {
          "Content-type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify({
          accountId: sessionStorage.getItem("accountId"),
          amount: this.depamount()
        }),
        mode: "cors",
      });
      if (response.ok) {
        console.log("Deposit completed");
        alert("Deposit completed");
        this.dataprovider.refresh();
      } else {
        console.error("Error getting row:", response.status, response.statusText);
      }
    } catch (error) {
      console.error("Error getting row:", error);
    }
  }

  public withdraw = async (event: any) => {
    try {
      const response = await fetch("http://localhost:8080/accounts/withdraw", {
        method: "POST",
        headers: {
          "Content-type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify({
          accountId: sessionStorage.getItem("accountId"),
          amount: this.withamount()
        }),
        mode: "cors",
      });
      if (response.ok) {
        console.log("Withdraw completed");
        alert("Withdraw completed");
        this.dataprovider.refresh();
      } else {
        console.error("Error getting row:", response.status, response.statusText);
      }
    } catch (error) {
      console.error("Error getting row:", error);
    }
  }

  public transactions = async (event: any) => {
    
  }
}

export = DashboardViewModel;
