/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import { Item } from "@oracle/oraclejet/ojdataprovider";
import * as AccUtils from "../accUtils";
import 'oj-c/button';
import "ojs/ojtable";

import { RESTDataProvider } from "ojs/ojrestdataprovider";

type D = { id: number; name: string; username: string };
type K = D["id"];

class CustomersViewModel {
    dataprovider: RESTDataProvider<K, D>;
    keyAttributes = "id";
    url = "https://jsonplaceholder.typicode.com/users";


  constructor() {
      this.dataprovider = new RESTDataProvider({
          keyAttributes: this.keyAttributes,
          url: this.url,

          transforms: {
              fetchFirst: {
                  request: async (options) => {
                      const url = new URL(options.url);
                      const { size, offset } = options.fetchParameters;
                      url.searchParams.set("limit", String(size));
                      url.searchParams.set("offset", String(offset));
                      return new Request(url.href);
                  },
                  response: async ({ body }) => {
                      console.log(body)
                      let res = {'data':body}
                      return res;
                  },
              },
          },
      });
      
      console.log(this.dataprovider);
  }
  public handleClick = async (event: Event) => {
    let response = await fetch(this.url);
    let jsonData = await response.json();
    console.log(jsonData);
    this.dataprovider.mutate({
      add: {
        data : jsonData, keys : new Set(jsonData)
      }
    })
  }
}

export = CustomersViewModel;
