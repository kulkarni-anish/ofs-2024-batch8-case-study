/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import "ojs/ojknockout";
import "oj-c/button";
import * as ko from "knockout";
import * as Bootstrap from "ojs/ojbootstrap";
class IncidentsViewModel {
  button2Text: string;
  clickedButton: ko.Observable<string>;
  activatedButton: ko.Observable<string>;

  constructor() {
    this.button2Text = "Button 2";
    this.clickedButton = ko.observable("(None clicked yet)");
    this.activatedButton = ko.observable("(None activated yet)");
  }
  public buttonClick = (event: Event) => {
    this.clickedButton((event.currentTarget as HTMLElement).id);
    return true;
  };
  public buttonAction = (event: Event) => {
    this.activatedButton((event.currentTarget as HTMLElement).id);
    return true;
  };
}

export = IncidentsViewModel;
