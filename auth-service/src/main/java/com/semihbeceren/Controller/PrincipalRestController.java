package com.semihbeceren.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Semih Beceren on 11/23/2016.
 */
@RestController
public class PrincipalRestController {

    @RequestMapping("/user")
    Principal principal (Principal principal) {
        return principal;
    }

}
