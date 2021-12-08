//package com.example.sicred.config;
//
//import com.example.sicred.service.enumeration.VotoAptoEnum;
//import com.example.sicred.service.feign.UserClient;
//import com.example.sicred.service.feign.dto.StatusDto;
//import org.mockito.Mockito;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;
//
//@Configuration
//public class FeignMockConfig {
//
//    @MockBean
//    private UserClient client;
//
//    @PostConstruct
//    public void mock(){
//        Mockito.when(client.verificarCpfValido(Mockito.any())).thenReturn(new StatusDto(VotoAptoEnum.ABLE_TO_VOTE));
//    }
//}
