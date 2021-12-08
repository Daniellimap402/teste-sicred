package com.example.sicred.service.feign;

import com.example.sicred.service.feign.dto.StatusDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user", url = "https://user-info.herokuapp.com/users/")
public interface UserClient {

    @GetMapping({"{cpf}"})
    StatusDto verificarCpfValido(@PathVariable String cpf);

}
