import { Component, OnInit } from '@angular/core';
import { AppService } from '../../Services/auth-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  private email: string;
  private password: string;
  private repassword: string;
  private serverError: boolean = false;
  constructor(private authService: AppService, private router:Router) { }

  ngOnInit() {
  }

  onRegister() {
    this.serverError = false;
    this.authService.register({password: this.password, username: this.email}).subscribe(data => {
      this.router.navigate(['/login']);
    }, err => {
      this.serverError = true;
    })
  }

}
