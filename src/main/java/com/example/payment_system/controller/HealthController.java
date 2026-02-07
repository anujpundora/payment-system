package com.example.payment_system.controller;

import com.example.payment_system.dto.HealthResponse;
import com.example.payment_system.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {

@GetMapping("/health")
    public ResponseEntity<HealthResponse> healthCheck(){
    boolean hasError=false;
    HealthResponse errorBody= new HealthResponse("Failed","Transaction failed");
    if(hasError){
        return ResponseEntity.badRequest().body(errorBody);
    }
    HealthResponse succeful = new HealthResponse("Success","Transaction Successful");
        return ResponseEntity.ok().body(succeful);
}


}
