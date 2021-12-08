package com.example.sicred.service.feign.dto;

import com.example.sicred.service.enumeration.VotoAptoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {

    private VotoAptoEnum status;

}
