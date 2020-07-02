import { Component } from '@angular/core';
import { ChatService } from './chat-service.service';
import { ChatSockjsService } from './chat-sockjs.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'socketui';
  message: string
  constructor(private chatService: ChatService, private chatSockjsService: ChatSockjsService) { }
  sendMessage() {
    this.chatService.sendMessage(this.message);
    this.chatSockjsService.sendMessage(this.message);
    this.message = '';
  }

  unsubscribe() {
    this.chatSockjsService.unsubscribe();
  }
}
