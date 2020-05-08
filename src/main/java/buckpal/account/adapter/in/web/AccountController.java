package buckpal.account.adapter.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AccountController {

    @RequestMapping(path = "/send-money", method = RequestMethod.PUT)
    public void sendMoney() {

    }

    @GetMapping
    public String helloGradle() {
        return "Hello Gradle!";
    }
}
