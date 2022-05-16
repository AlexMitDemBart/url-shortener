package azo.developer.urlshortener.integration;

import azo.developer.urlshortener.constants.Messages;
import azo.developer.urlshortener.model.ShortenUrlRequest;
import azo.developer.urlshortener.model.ShortenUrlResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UrlIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shortUrl_should_short_url() throws Exception {
        ShortenUrlRequest request = new ShortenUrlRequest();
        request.setUrl("https://www.youtube.com/watch?v=MrkPc_mFQWU");

        String result = mockMvc.perform(post("/url/shorten")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        var response = objectMapper.readValue(result, ShortenUrlResponse.class);

        assertThat(response.getMessage()).isEqualTo(Messages.SHORTEN_URL_SUCCESSFUL);
        MatcherAssert.assertThat(response.getShortenUrl(), Matchers.matchesPattern("^([A-Za-z0-9]{6})$"));
    }
}
