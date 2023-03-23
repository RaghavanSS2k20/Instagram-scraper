package com.example.pw28ca2labtest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("api/vi")
public class APIcontroller {
    @GetMapping
    public String index(){
        return "indexpage";
    }

    @GetMapping("username/{un}")
    public ResponseEntity getUsername(@PathVariable String un) throws URISyntaxException, IOException, InterruptedException{
        String username = un;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://instagram28.p.rapidapi.com/user_info?user_name="+un))
                .header("X-RapidAPI-Key", "d1869f472amsh706c8dbcf4cf939p147e3bjsn048c5e14b83e")
                .header("X-RapidAPI-Host", "instagram28.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response.body());
    }


}
