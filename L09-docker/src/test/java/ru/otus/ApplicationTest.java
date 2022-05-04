package ru.otus;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends BaseContainerTest {

    @Test
    void test() throws URISyntaxException, IOException, InterruptedException {
        //given
        int appPort = BaseContainerTest.getPort();
        String uriStr = String.format("http://localhost:%d/hi?name=Ivan", appPort);
        String dockerHostName = BaseContainerTest.getHost();
        String expectedBody = String.format("Hi, Ivan. It works, host: %s", dockerHostName);

        //when
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(uriStr))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.body()).isEqualTo(expectedBody);
    }
}
