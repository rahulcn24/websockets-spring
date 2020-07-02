import { TestBed } from '@angular/core/testing';

import { ChatSockjsService } from './chat-sockjs.service';

describe('ChatSockjsService', () => {
  let service: ChatSockjsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChatSockjsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
