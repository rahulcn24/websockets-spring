import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ChatService } from './chat-service.service';
import { ChatSockjsService } from './chat-sockjs.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [ChatService,ChatSockjsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
