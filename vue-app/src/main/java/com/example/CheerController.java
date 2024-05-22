import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class CheerController {

    @GetMapping("/cheer")
    public List<String> getCheerTexts() {
        return Arrays.asList("Keep going!", "You can do it!", "Believe in yourself!");
    }
}
