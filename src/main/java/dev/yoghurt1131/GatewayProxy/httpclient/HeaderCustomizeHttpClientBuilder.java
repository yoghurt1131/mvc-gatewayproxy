package dev.yoghurt1131.GatewayProxy.httpclient;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.impl.execchain.MainClientExec;
import org.apache.http.protocol.*;
import sun.net.www.http.HttpClient;

public class HeaderCustomizeHttpClientBuilder extends HttpClientBuilder {

    @Override
    protected ClientExecChain createMainExec(HttpRequestExecutor requestExec, HttpClientConnectionManager connManager,
                                             ConnectionReuseStrategy reuseStrategy, ConnectionKeepAliveStrategy keepAliveStrategy,
                                             HttpProcessor proxyHttpProcessor,
                                             AuthenticationStrategy targetAuthStrategy,
                                             AuthenticationStrategy proxyAuthStrategy,
                                             UserTokenHandler userTokenHandler) {
        HttpProcessor headerCustomizeHttpProcessor = new ImmutableHttpProcessor(
                new RequestTargetHost(),
                (request, context) -> request.addHeader("Name", "Value")
        );

        return super.createMainExec(requestExec, connManager, reuseStrategy,
                keepAliveStrategy, proxyHttpProcessor,
                targetAuthStrategy, proxyAuthStrategy, userTokenHandler);
    }
}