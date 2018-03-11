import { Component, OnInit } from '@angular/core';
import { AppService } from '../../Services/auth-service';

@Component({
  selector: 'app-start-page',
  templateUrl: './start-page.component.html',
  styleUrls: ['./start-page.component.css']
})
export class StartPageComponent implements OnInit {

  private email: string;
  private password: string;
  constructor(private authService: AppService) { }

  ngOnInit() {
  }

  onLogin(){
    this.authService.obtainAccessToken("wizzzy","siema");
 }

}
