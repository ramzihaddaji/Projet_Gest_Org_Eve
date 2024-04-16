package com.example.evenmentGst.Controller;

import com.example.evenmentGst.Dto.*;
import com.example.evenmentGst.Service.UtilisateurService;
import com.example.evenmentGst.ServicesImpl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evenements/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    private final UtilisateurService utilisateurService ;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticat")
    public ResponseEntity<AuthenticationResponse> Authenticate(
            @RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }
//    @GetMapping("/user")
//    public ResponseEntity<List<UserResponse>> getAllUsers() {
//        List<UserResponse> users = service.getAllUsers();
//        return ResponseEntity.ok(users);
//    }
@GetMapping("")
public ResponseEntity<List<UserResponse>> getAllUtilisateur(){
    List<UserResponse> utilisateurs = utilisateurService.getAllUtilisateur();
    return ResponseEntity.ok(utilisateurs);
}

}
