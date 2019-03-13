package my.problems;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class Controller2 {

    @Get("/doesnt-throw")
    public ImmutablePojo doesntThrow(){
        return ImmutablePojo.of("Should Throw");
    }

}
