import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {UserDataService} from '../user-data.service';
import {Router} from '@angular/router';
import {UserAuthenticationService} from '../user-authentication.service';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {
  constructor(private service: UserDataService, private router: Router,
              private auth_service: UserAuthenticationService) { }

   emp: any = 1;

  ngOnInit() {
    this.emp = 1;
    const uid = localStorage.getItem('uid');
    console.log(uid);
    if ( !(uid === null || !uid || uid === '' || uid === ' ') ) {
      this.router.navigateByUrl('/home');
    }
    }

  login(uid: string) {

    uid = uid.trim();

    this.service.postUserData(uid)
      .subscribe( (data) => {
        if ( data.access === 'true') {
          console.log('success');
          localStorage.setItem('uid', uid);
          this.router.navigateByUrl('/home');
        } else {
          this.emp = 0 ;
          console.log('Failed to log-in');
        }
      });
  }

}
