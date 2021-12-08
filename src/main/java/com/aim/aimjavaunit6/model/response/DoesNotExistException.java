package com.aim.aimjavaunit6.model.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class DoesNotExistException extends RuntimeException
{
  
  public DoesNotExistException(String message)
  {
    super(message);
  }

}
