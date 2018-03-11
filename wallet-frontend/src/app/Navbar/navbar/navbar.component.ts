import { Component, OnInit } from '@angular/core';
import { AppService } from '../../Services/auth-service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private authService: AppService) { }

  ngOnInit() {
  }

  onLogout() {
    this.authService.logout();
  }

}
