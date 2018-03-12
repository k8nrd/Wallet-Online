import { Component, HostListener } from '@angular/core';
import { AppService } from './Services/auth-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private auth: AppService){}

  @HostListener('window:beforeunload', ['$event'])
  public handleBeforeUnload(event) {
    this.auth.logout();
  }
}
