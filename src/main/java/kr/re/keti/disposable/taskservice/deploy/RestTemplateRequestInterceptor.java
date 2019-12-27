package kr.re.keti.disposable.taskservice.deploy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RestTemplateRequestInterceptor implements ClientHttpRequestInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        final ClientHttpResponse response = execution.execute(request,body);

        logRequest(request, body);
        logResponse(response);

        return execution.execute(request,body);
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        final String body = getbody(response);

        logger.debug("Headers: {" + response.getHeaders() + "}"
                + "Request Method: {" + response.getRawStatusCode() + "}"
                + "Request Body: {" + body + "}");
    }

    private void logRequest(HttpRequest request, byte[] body) {
        logger.debug("Headers: {" + request.getHeaders() + "}"
                + "Request Method: {" + request.getMethod() + "}"
                + "Request URI: {" + request.getURI() + "}" );
    }

    private String getbody(ClientHttpResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getBody()));
        return br.readLine();
    }
}
