import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserDataService} from '../user-data.service';
declare let $: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  userDetails: object = {};
  result: object = {'rouletteNumber': -1, 'profit': -1};
  val1: any = 0; val2: any = 0; val3: any = 0; val4: any = 0;
  val5: any = 0; val6: any = 0; val7: any = 0; val8: any = 0;
  constructor(private router: Router, private service: UserDataService) { }

  ngOnInit() {
    const uid = localStorage.getItem('uid');
    console.log(uid);
    if ( uid === null || !uid || uid === '' || uid === ' ') {
      this.router.navigateByUrl('/');
    } else {
      this.service.getUserData(uid)
        .subscribe((data) => {
          this.userDetails = data;
        });
    }
  }

  resetBets() {
    this.val1 = 0; this.val2 = 0; this.val3 = 0; this.val4 = 0;
    this.val5 = 0; this.val6 = 0; this.val7 = 0; this.val8 = 0;
  }

  postBets(num1, num2, num3, num4, num5, num6, num7, num8, id) {
    console.log( 'post bets' + id);
    // console.log( num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8);
    if (parseInt(num1) + parseInt(num2) + parseInt(num3) + parseInt(num4) + parseInt(num5) + parseInt(num6) +
      parseInt(num7) + parseInt(num8) <= this.userDetails['amount']) {
      console.log('AJAX called');

      const xhr = new XMLHttpRequest();
      xhr.open('POST', 'http://localhost:9000/showResult', true);

      const data = new FormData();

      data.append('num1', num1);
      data.append('num2', num2);
      data.append('num3', num3);
      data.append('num4', num4);
      data.append('num5', num5);
      data.append('num6', num6);
      data.append('num7', num7);
      data.append('num8', num8);
      data.append('id', id);

      const self = this;
      xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 ) {
          if (xhr.status === 200) {
            const profit =  JSON.parse(xhr.responseText).profit ;
            self.userDetails['amount'] = self.userDetails['amount'] + profit;
            self.result['rouletteNumber'] = JSON.parse(xhr.responseText).rouletteNumber;
            self.result['profit'] = JSON.parse(xhr.responseText).profit;

            $('#myModal').modal();
            self.resetBets();
          }
        }
      };
      xhr.send(data);

    } else {
      $('#myModal1').modal();
      console.log('please recharge');
    }
  }

  logout() {
    localStorage.removeItem('uid');
    this.router.navigateByUrl('/');
  }

}
