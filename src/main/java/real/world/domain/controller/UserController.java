package real.world.domain.controller;

import jakarta.validation.Valid;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import real.world.domain.service.UserService;
import real.world.domain.dto.request.RegisterRequest;
import real.world.domain.dto.response.RegisterResponse;

import java.io.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users")
    public ResponseEntity<RegisterResponse> register(
        @RequestBody @Valid RegisterRequest registerRequest) {
        final RegisterResponse response = userService.register(registerRequest);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/test2")
    public ResponseEntity<String> test2() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping("/api/test")
    public ResponseEntity<String> test() throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("python3", resolveFilePath("hello.py"));
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        int exitCode = process.waitFor();

        InputStream input = process.getInputStream();
        FileOutputStream output = new FileOutputStream("out.txt");
        IOUtils.copy(input, output);

        return ResponseEntity.ok("hello");
    }

    private String resolveFilePath(String path){
        File file = new File(path);
        return file.getAbsolutePath();
    }

}
