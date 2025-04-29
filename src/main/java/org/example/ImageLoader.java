package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;


@RestController
@RequestMapping("/api/img")
@Slf4j
public class ImageLoader {


    @PostMapping("/upload")
    public ResponseEntity<String> saveImage(@RequestParam String s3Link, @RequestParam String imageType) {
        if (imageType == null || imageType.isEmpty()) {
            return ResponseEntity.badRequest().body("Image type must be provided");
        }

//        String fileName = switch (imageType.toLowerCase()) {
//            case LOGO -> NANDU_BUS + PNG_TYPE;
//            case SCANNER -> PAYMENT_SCANNER + PNG_TYPE;
//            default -> EMPTY_STRING;
//        };

        if ("fileName".isEmpty()) {
            return ResponseEntity.status(400).body("Invalid Image type");
        }

        String destinationFile = Paths.get("src", "main", "resources", "images", "fileName").toString();

        try {
            URL url = new URL(s3Link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = connection.getResponseCode();
            String contentType = connection.getContentType();

            log.info("HTTP Response Code: {}", responseCode);
            log.info("Content-Type: {}", contentType);

            if (responseCode == HttpURLConnection.HTTP_OK && contentType.startsWith("image")) {
                try (InputStream in = connection.getInputStream();
                     FileOutputStream out = new FileOutputStream(destinationFile)) {

                    byte[] buffer = new byte[8192];
                    int bytesRead;

                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }

                    log.info("Image saved to: {}", destinationFile);
                    return ResponseEntity.ok("Image saved successfully.");
                }
            } else {
                log.info("Invalid response. Server returned : {}", responseCode);
                return ResponseEntity.status(responseCode).body("Failed to download image.");
            }

        } catch (IOException e) {
            log.info("Error message : {}", e.getMessage());
            return ResponseEntity.internalServerError().body("Exception while saving image.");
        }
    }
}
