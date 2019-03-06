package com.zalego.io.thymeleafexample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED,
reason = "Wrong email or password!!!")
public class UnAuthorizedAccess extends RuntimeException{
}
