package geozak.springvue.server.spasetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class SpaHandler {

  @Value("${spa.default-file}")
  private String defaultFileName;

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<String> urlRewriteDefaultPage(HttpServletRequest request) {
    if (!RequestMethod.GET.name().equals(request.getMethod())) {
      return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("body");
    }
    try {
      return ResponseEntity.ok()
          .contentType(MediaType.TEXT_HTML)
          .body(
              StreamUtils.copyToString(
                  new FileInputStream(ResourceUtils.getFile(defaultFileName)),
                  Charset.defaultCharset()));
    } catch (IOException ioe) {
      ioe.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("There was an error completing the action.");
    }
  }
}
