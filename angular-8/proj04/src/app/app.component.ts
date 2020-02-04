import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private message : string = null;
  private version : number = null;
  private topics : string[]=[];

  public constructor(){
    this.message= "Welcome to";
    this.version= 8;
  }
  public addTopic(currentTopic:string):void{
    for(let t of this.topics){
      if(currentTopic==t){
        alert("Cannot insert duplicates");
        return;
      }
        
    }
    if(currentTopic.trim()==""){
      alert("Cannot add empty cell");
      return;
    }
      
    this.topics.push(currentTopic);
  }
  public delete(currentTopic:string):void{
    for(let t of this.topics){
      if(currentTopic==t){
        let el=this.topics.indexOf(currentTopic);
        this.topics.splice(el,1);
        alert("item deleted");
        return;
      }
    }
    alert("item not found");
  }
  public search(currentTopic:string):void{
    for(let t of this.topics){
      if(currentTopic==t){
        let el:number=this.topics.indexOf(currentTopic);
        alert("Item found at index "+(++el));
        return;
      }
    }
      alert("Item not found");
      return;
  }
  public delTopic(i:number):void{
    this.topics.splice(i,1);
  }
}