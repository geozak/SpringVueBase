package geozak.springvue.server.spasetup;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiNotFoundHandler {

  @RequestMapping("/api/**")
  public ResponseEntity<String> apiCatchAll(HttpServletRequest request) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
}
