package tajbanana.ssfassessment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

import static tajbanana.ssfassessment.Constants.*;

@Service (BEAN_BOOK_SERVICE)
public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class.getName());

    public List<String> search(String searchParam) {
        final String url = UriComponentsBuilder
                .fromUriString(OPEN_LIBRARY_URL)
                .queryParam("title", searchParam.trim().replace(" ", "+"))
                .queryParam("limit", 20)
                .toUriString();

        logger.info("URL: " + url);

        final RequestEntity<Void> req = RequestEntity.get(url).build();
        final RestTemplate template = new RestTemplate();
        final ResponseEntity<String> resp = template.exchange(req, String.class);

        if (resp.getStatusCode() != HttpStatus.OK)
            throw new IllegalArgumentException(
                    "Error: status code %s".formatted(resp.getStatusCode().toString())
            );
        final String body = resp.getBody();

        logger.info("payload: %s".formatted(body));

        return Collections.emptyList();
    }
}
