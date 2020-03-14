package dev.yoghurt1131.GatewayProxy.bean;

import dev.yoghurt1131.GatewayProxy.httpclient.ClientHttpRequestFactoryBuilder;
import dev.yoghurt1131.GatewayProxy.httpclient.ProxyClientHttpRequestFactoryBuilder;
import org.apache.http.HttpHost;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Value("${app.proxy.host}")
    private String proxyHost;

    @Value("${app.proxy.port}")
    private int proxyPort;

    @Bean
    ClientHttpRequestFactoryBuilder clientHttpRequestFactoryBuilder() {
        return new ProxyClientHttpRequestFactoryBuilder(new HttpHost(proxyHost, proxyPort));
    }

    @Bean
    RestTemplateBuilder restTemplateBuilder(ClientHttpRequestFactoryBuilder clientHttpRequestFactoryBuilder) {
        return new RestTemplateBuilder().requestFactory(() -> clientHttpRequestFactoryBuilder.build());
    }
}
