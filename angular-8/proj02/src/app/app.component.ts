import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private userName: string=null;
  
  
  public greetUser():void{
    this.userName="Mr."+this.userName;
    alert("Welcome "+this.userName);
  }
}
