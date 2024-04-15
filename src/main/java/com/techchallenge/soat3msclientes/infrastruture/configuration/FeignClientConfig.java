package com.techchallenge.soat3msclientes.infrastruture.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.openfeign.EnableFeignClients;


import static com.techchallenge.soat3msclientes.Soat3MsClientesApplication.PACKAGE;

@Configuration
@EnableFeignClients(PACKAGE)
public class FeignClientConfig {
}
