import { Component, OnInit, Input, Injectable, AfterViewInit, ElementRef, ViewChild, Output, EventEmitter, ViewContainerRef, ComponentFactoryResolver, IterableDiffers } from '@angular/core';
import { Reg } from '../../model/regModel'
import { UserService } from '../../service/search.service';
import { DomService } from '../../service/componentcreator.service';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})

export class SearchComponent {
  // @ViewChild("searchResultRef",{read: ViewContainerRef}) 
  // searchResultRef:ViewContainerRef;

  @Input() feature: string;
  @Output() searchString: EventEmitter<any> = new EventEmitter<any>();

  
  iterableDiffer;
  users: Reg[];
  @Output() searchEvent: EventEmitter<any> = new EventEmitter<any>();
  // ngAfterViewInit():void{
  //   this.searchResultRef.nativeElement.upda
  // }

  ngDoCheck() {
    let changes = this.iterableDiffer.diff(this.users);
    if (changes) {
        console.log('Changes detected!');
    }
}

  constructor(
    private userService: UserService,
    private createComponent: DomService,
    private _iterableDiffers: IterableDiffers
  ){
    this.iterableDiffer = this._iterableDiffers.find([]).create(null);
  }
  // pages =['abc','bca','pqr'];

  // onOptionSelected(event){
  //  console.log(event); //option value will be sent as event
  // }


  getUsers(search :string){
    if(search.length > 2){
    this.userService.getUsers(search)
    .then(
      data => {
        this.users = data;
        this.searchEvent.emit();
        console.log("User" + this.users);
      // this.searchString.emit(this.users.firstName);
      //this.createComponent.appendComponentToBody(SearcResultsComponent,this.users);
      //this.searchResultRef.createComponent(this.childComponent);
      
      },
      reason => {
        console.log(reason);
  });
}
}
}