package com.evshang.fallback;

import com.evshang.response.FallbackResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class EvshangFallbackProvider implements FallbackProvider {

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return getClientHttpResponse(cause);
    }

    @Override
    public String getRoute() {
        //希望为所有路由提供默认的回退，您可以创建一个类型为ZuulFallbackProvider的bean，并且getRoute方法返回*或null
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return getClientHttpResponse(null);
    }

    ClientHttpResponse getClientHttpResponse(Throwable throwable) {
        return new ClientHttpResponse() {
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                //update this code;
                //return json data;
                //error_code = -1;
                //System.out.println(throwable.getMessage());
                FallbackResponse fallbackResponse = new FallbackResponse();
                fallbackResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                ObjectMapper objectMapper = new ObjectMapper();
                String content = objectMapper.writeValueAsString(fallbackResponse);
                return new ByteArrayInputStream(content.getBytes());
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }
        };
    }




}
