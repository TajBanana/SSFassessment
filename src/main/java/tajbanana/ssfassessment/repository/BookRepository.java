package tajbanana.ssfassessment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import static tajbanana.ssfassessment.Constants.*;

@Repository
public class BookRepository {

    @Autowired
    @Qualifier(BEAN_BOOK_CACHE)

    private RedisTemplate<String, String> template;

}
