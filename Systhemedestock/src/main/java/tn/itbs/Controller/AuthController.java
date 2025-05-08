package tn.itbs.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itbs.Models.Utilisateur;
import tn.itbs.Repository.UtilisateurRepository;
import tn.itbs.Service.JwtService;
import tn.itbs.dto.AuthRequest;
import tn.itbs.dto.AuthResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Utilisateur user) {
        if (utilisateurRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email déjà utilisé");
        }

        user.setMotDePasse(passwordEncoder.encode(user.getMotDePasse()));
        utilisateurRepository.save(user);
        return ResponseEntity.ok("Utilisateur enregistré avec succès !");
    }
   


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            // Authentification
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getMotDePasse()
                )
            );

            // Récupérer l'utilisateur
            Utilisateur user = utilisateurRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

            // Générer le token
            String jwtToken = jwtService.generateToken(user);

            // Retourner le token
            return ResponseEntity.ok(new AuthResponse(jwtToken));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Email ou mot de passe invalide !");
        }
    }
    
    
    @GetMapping("/api/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Bienvenue Hadir !");
    }
}
