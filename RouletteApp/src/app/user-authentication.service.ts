import { Injectable } from '@angular/core';
import {UserDataService} from './user-data.service';

export class User {
  constructor(
    public uid: string) { }
}

@Injectable()
export class UserAuthenticationService {

  constructor(private service: UserDataService) { }

  login(uid) {
    this.service.postUserData(uid)
      .subscribe( (data) => {
        if ( data.access === 'true') {
          console.log('correct');
          // return true;
        } else {
          // return false;
        }
      });
  }
}
