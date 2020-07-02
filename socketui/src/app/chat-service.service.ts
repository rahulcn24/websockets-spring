import * as io from 'socket.io-client';
import { Injectable } from '@angular/core';

export class ChatService {
  private url = 'http://localhost:3033';
  private socket;

  constructor() {
    //this.socket = io(this.url);
  }

  public sendMessage(message) {
    //this.socket.emit('joined', message);
  }
}