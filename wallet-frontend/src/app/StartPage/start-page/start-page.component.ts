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
  private success = true;
  constructor(private authService: AppService) { }

  ngOnInit() {
  }

  onLogin(){
    this.success = true;
    this.authService.obtainAccessToken(this.email,this.password).subscribe(data => {
      this.authService.saveToken(data);
    }, err => {
      this.success = false;
    })
 }

}
