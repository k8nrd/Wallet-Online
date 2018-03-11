import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  private email: string;
  private password: string;
  private repassword: string;
  private serverError: boolean;
  constructor() { }

  ngOnInit() {
  }

}
