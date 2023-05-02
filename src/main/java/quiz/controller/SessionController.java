package quiz.controller;

import org.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SessionController {
    @GetMapping("/session/{sessionId}/check")
    public String checkSession(@PathVariable String sessionId) {
        boolean isAuthenticated = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        HashMap<String, Boolean> map = new HashMap<>();
        if (isAuthenticated) {
            map.put("result", true);
        } else {
            map.put("result", false);
        }
        return new JSONObject(map).toString();
    }
}
