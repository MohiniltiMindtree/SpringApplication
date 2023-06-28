import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @PostMapping("/dominosFallback")
    public Mono<String> dominosfallback()
    {
        return Mono.just("dominos service is down pls try later");
    }

    @PostMapping("/zomatoFallback")
    public Mono<String> zomatofallback()
    {
        return Mono.just("zomato service is down pls try later");
    }
}
