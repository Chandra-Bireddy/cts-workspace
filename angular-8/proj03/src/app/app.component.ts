import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private firstNumber: number=null;
  private secondNumber: number=null;
  private result:number=null;


  public add():void {
    this.result=this.firstNumber+this.secondNumber;
  }

  public subtract(): void {
    this.result = this.firstNumber-this.secondNumber;
  }
  
  public multiply(): void {
    this.result = this.firstNumber*this.secondNumber;
  }

  public divide(): void{
    this.result=this.firstNumber/this.secondNumber;
  } 
}
