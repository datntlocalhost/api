package jp.com.run.controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FileController {

    @PostMapping("image")
    public ResponseEntity<?> resizeImage(MultipartFile img, @RequestHeader(value = "Percentage") String test) throws IOException {
        if (img != null) {
            System.out.println(img.getContentType());
        }

        if (test != null) {
            System.out.println(test);
        }
        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType("application/octet-stream"))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + img.getName() + "\"")
            .body(img.getInputStream());
    }
}
