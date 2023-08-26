package real.world;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootTest
@WebAppConfiguration
class WorldApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void givenPythonScript_whenPythonProcessInvoked_thenSuccess() throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("python", resolveFilePath("hello.py"));
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        int exitCode = process.waitFor();

        var br = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    private String resolveFilePath(String path){
        File file = new File(path);
        return file.getAbsolutePath();
    }
}
