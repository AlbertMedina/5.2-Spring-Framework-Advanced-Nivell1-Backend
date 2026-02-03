package com.videostore.videostore.web.controller.user;

import com.videostore.videostore.application.command.user.LoginUserCommand;
import com.videostore.videostore.application.command.user.RegisterUserCommand;
import com.videostore.videostore.application.port.in.user.LoginUserUseCase;
import com.videostore.videostore.application.port.in.user.RegisterUserUseCase;
import com.videostore.videostore.application.port.in.user.RemoveUserUseCase;
import com.videostore.videostore.domain.model.user.User;
import com.videostore.videostore.web.controller.user.dto.request.LoginUserRequest;
import com.videostore.videostore.web.controller.user.dto.request.RegisterUserRequest;
import com.videostore.videostore.web.controller.user.dto.response.UserResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUserUseCase loginUserUseCase;
    private final RemoveUserUseCase removeUserUseCase;

    public UserController(
            RegisterUserUseCase registerUserUseCase,
            LoginUserUseCase loginUserUseCase,
            RemoveUserUseCase removeUserUseCase
    ) {
        this.registerUserUseCase = registerUserUseCase;
        this.loginUserUseCase = loginUserUseCase;
        this.removeUserUseCase = removeUserUseCase;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid RegisterUserRequest request) {
        RegisterUserCommand command = new RegisterUserCommand(
                request.name(),
                request.surname(),
                request.username(),
                request.email(),
                request.password()
        );
        User user = registerUserUseCase.execute(command);

        UserResponse response = UserResponse.fromDomain(user);
        return ResponseEntity.status(201).body(response);
    }

    @PostMapping("auth/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody @Valid LoginUserRequest request) {
        LoginUserCommand command = new LoginUserCommand(
                request.loginIdentifier(),
                request.password()
        );
        User user = loginUserUseCase.execute(command);

        UserResponse response = UserResponse.fromDomain(user);
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> removeUser(@PathVariable @Positive Long userId) {
        removeUserUseCase.execute(userId);

        return ResponseEntity.noContent().build();
    }
}
