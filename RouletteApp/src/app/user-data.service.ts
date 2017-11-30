import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';


import 'rxjs/add/operator/map';


const BASE_URL = 'http://localhost:8080/';
// const header = {headers: new Headers( {'Content-Type': 'application/json'})};
@Injectable()
export class UserDataService {

  constructor(private http: Http) { }

  postUserData( uid: string ) {
    // console.log('entered service');
    var data = new FormData();
    data.append('uid', uid);
    // console.log(data.get('uid'));
    return this.http.post(BASE_URL + 'api/getUserByUid', data).map(res => res.json());
  }

  getUserData( uid: string ) {
    // console.log('entered service');
    var data = new FormData();
    data.append('uid', uid);
    // console.log(data.get('uid'));
    return this.http.post(BASE_URL + 'api/userDetailsByUid', data).map(res => res.json());
  }

}
