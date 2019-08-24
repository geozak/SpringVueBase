package geozak.springvue.server.service;

import org.springframework.stereotype.Service;

@Service
public class CounterService {

  private int visitCount = 0;

  public int incrementVisitCount() {
    return ++visitCount;
  }
}
