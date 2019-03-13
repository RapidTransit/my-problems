package my.problems;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Inject;

@Controller
public class Controller1 {

    private final ThrowsAnErrorService service;

    @Inject
    public Controller1(ThrowsAnErrorService service) {
        this.service = service;
    }

    @Post("/runtime-timeout")
    public Mono<ImmutablePojo> post(@Body Flux<Something> sflux){
        return sflux.singleOrEmpty()
                .map(x-> ImmutablePojo.of("res"));
    }

    /**
     * Causes an infinite loop, was hard to track
     * @param request
     * @param throwable
     * @return
     */
    @Error
    public HttpResponse catching(HttpRequest request, Throwable throwable){
        return HttpResponse.serverError();
    }
}
