/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import 'ojs/ojknockout';
import 'oj-c/message-toast';
import 'oj-c/button';
import * as ko from "knockout";
import * as Bootstrap from "ojs/ojbootstrap";
import MutableArrayDataProvider = require("@oracle/oraclejet/ojmutablearraydataprovider");
class IncidentsViewModel {
  button2Text: string;
  clickedButton: ko.Observable<string>;
  activatedButton: ko.Observable<string>;
  // messages: MutableArrayDataProvider<string, Record<string, any>>;

  constructor() {
    this.button2Text = "Button 2";
    this.clickedButton = ko.observable("(None clicked yet)");
    this.activatedButton = ko.observable("(None activated yet)");

    // const initialData = [
    //   {
    //     id: 'error1',
    //     severity: 'error',
    //     summary: 'Error message summary',
    //     detail: 'Error message detail.'
    //   },
    //   {
    //     id: 'warning1',
    //     severity: 'warning',
    //     summary: 'Warning message summary',
    //     detail: 'Warning message detail.'
    //   },
    //   {
    //     id: 'confirmation1',
    //     severity: 'confirmation',
    //     summary: 'Confirmation message summary',
    //     detail: 'Confirmation message detail'
    //   },
    //   {
    //     id: 'info1',
    //     severity: 'info',
    //     summary: 'Info message summary with no detail'
    //   },
    //   {
    //     id: 'none1',
    //     severity: 'none',
    //     summary: 'Message summary with no severity and detail'
    //   },
    //   {
    //     id: 'long1',
    //     severity: 'error',
    //     summary:
    //       'Error message with really long summary text to show how the text wraps up when it overflows. ',
    //     detail:
    //       'Error message with really long detail text to show how the text wraps up when it overflows. '
    //   }
    // ];
    // this.messages = new MutableArrayDataProvider(initialData, {
    //   keyAttributes: 'id'
    // });

  }
  public buttonClick = (event: Event) => {
    this.clickedButton((event.currentTarget as HTMLElement).id);
    return true;
  };
  // readonly closeMessage = (event: CustomEvent) => {
  //   let data = this.messages.data.slice();
  //   const closeMessageKey = event.detail.key;

  //   data = data.filter((message) => (message as any).id !== closeMessageKey);
  //   this.messages.data = data;
  // };
  public buttonAction = (event: Event) => {
    this.activatedButton((event.currentTarget as HTMLElement).id);
    return true;
  };
// --------------------------------------------------------------------//
  public handleClick = (event:Event) =>{
    let element =(event.currentTarget as HTMLElement).tagName;

    alert("Button clicked is : "+ element);
  }
//=====================================================================//
}

export = IncidentsViewModel;
