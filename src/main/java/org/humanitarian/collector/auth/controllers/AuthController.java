package org.humanitarian.collector.auth.controllers;

import org.humanitarian.collector.auth.controllers.requests.UserRequest;
import org.humanitarian.collector.auth.controllers.responses.JwtResponse;
import org.humanitarian.collector.auth.models.User;
import org.humanitarian.collector.auth.services.UserService;
import org.humanitarian.collector.controllers.responses.BasicEntityMessageResponse;
import org.humanitarian.collector.controllers.responses.HttpStatusResponse;
import org.humanitarian.collector.exceptions.DuplicateUserException;
import org.humanitarian.collector.exceptions.InvalidLoginException;
import org.humanitarian.collector.exceptions.InvalidTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PutMapping(path = "/register", consumes = "application/json", produces = "application/json")
    public BasicEntityMessageResponse<User> register(@RequestBody UserRequest userRequest) throws DuplicateUserException {
        User u = userService.registerNewUser(userRequest.getUsername(), userRequest.getPassword(), userRequest.getRoleNames());

        return new BasicEntityMessageResponse<>(HttpStatus.OK, u);
    }

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public JwtResponse login(@RequestBody UserRequest userRequest) throws InvalidLoginException {
        String token = userService.loginAndGenerateJwtToken(userRequest.getUsername(), userRequest.getPassword());

        return new JwtResponse(token);
    }

    @GetMapping(path = "/whoami", produces = "application/json")
    public BasicEntityMessageResponse<User> whoami(@AuthenticationPrincipal User user) throws InvalidTokenException {
        if (user == null) {
            throw new InvalidTokenException();
        }

        return new BasicEntityMessageResponse<>(HttpStatus.OK, user);
    }
}
