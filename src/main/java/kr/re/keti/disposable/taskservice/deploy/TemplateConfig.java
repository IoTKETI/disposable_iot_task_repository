package kr.re.keti.disposable.taskservice.deploy;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class TemplateConfig {

    private final int RETRY_NUMBER = 3;
    private final long BACKOFF_TIME = 2000l;
    private final int CONNECTION_TIMEOUT = 3;
    private final int READ_TIMEOUT = 3;

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();
        //재시도 횟수
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy(RETRY_NUMBER);

        //재시도 간격
        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(BACKOFF_TIME);

        retryTemplate.setRetryPolicy(simpleRetryPolicy);
        retryTemplate.setBackOffPolicy(backOffPolicy);

        return retryTemplate;
    }

    @Bean
    RestTemplate restTemplate() {

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(CONNECTION_TIMEOUT))
                                  .setReadTimeout(Duration.ofSeconds(READ_TIMEOUT))
                                  .build();
    }

}

