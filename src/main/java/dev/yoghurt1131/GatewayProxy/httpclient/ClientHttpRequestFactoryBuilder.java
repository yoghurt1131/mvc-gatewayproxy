package dev.yoghurt1131.GatewayProxy.httpclient;

import org.springframework.http.client.ClientHttpRequestFactory;

public interface ClientHttpRequestFactoryBuilder {

    ClientHttpRequestFactory build();
}
