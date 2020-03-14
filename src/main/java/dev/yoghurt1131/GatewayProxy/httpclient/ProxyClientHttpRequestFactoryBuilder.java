package dev.yoghurt1131.GatewayProxy.httpclient;

import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

@RequiredArgsConstructor
public class ProxyClientHttpRequestFactoryBuilder implements ClientHttpRequestFactoryBuilder {

    private final HttpHost httpHost;

    @Override
    public ClientHttpRequestFactory build() {
        HttpClientBuilder httpClientBuilder = HeaderCustomizeHttpClientBuilder.create();
        httpClientBuilder.setProxy(httpHost);
        return new HttpComponentsClientHttpRequestFactory(httpClientBuilder.build());
    }
}
