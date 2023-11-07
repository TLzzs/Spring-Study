package com.ludistudy.restapi.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentErrorResponse {

    private int status;

    private String message;

    private long timeStamp;
}
