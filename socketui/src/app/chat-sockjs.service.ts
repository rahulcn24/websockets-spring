import { Injectable } from '@angular/core';
import { Stomp } from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class ChatSockjsService {
  public stompCLient;
  private username;
  private subscription;

  constructor() {
    console.log("Inside ChatSockjsService")
    this.stompCLient = Stomp.over(new SockJS('http://localhost:8080/chat'))
    this.stompCLient.connect({}, () => {
      console.log("Connected")
      this.stompCLient.subscribe("/topic/messages", function (message) {
        const data = JSON.parse(message.body)
        console.log(data);
      });
    });
  }

  public sendMessage(username) {
    this.username = username;
    this.subscription = this.stompCLient.subscribe("/topic/messages/" + username, function (message) {
      const data = JSON.parse(message.body)
      console.log(data);
    });
    /*this.stompCLient.send("/app/chat/rahul",{},JSON.stringify({
      message:"Hello",
      fromLogin:"browser"
    }));*/
  }

  public unsubscribe() {
    this.subscription.unsubscribe();
    console.log("unsubscribed");
  }
}
