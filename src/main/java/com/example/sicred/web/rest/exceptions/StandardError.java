package com.example.sicred.web.rest.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable {

    private static final long serialVersionUID = -3383892883020678349L;

    private Long timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
