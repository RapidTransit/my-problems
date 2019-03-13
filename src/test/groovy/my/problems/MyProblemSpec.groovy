package my.problems

import io.micronaut.http.HttpMethod
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.client.exceptions.ReadTimeoutException
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject


@MicronautTest
class MyProblemSpec extends Specification {

    @Inject
    @Client("/")
    HttpClient client


    def "Should it throw some type of Jackson/Reflection Exception?"(){
        when:
        HttpResponse<ImmutablePojo> res = client.toBlocking()
                .retrieve(HttpRequest.create(HttpMethod.GET, "/doesnt-throw"), ImmutablePojo)
        res.body()
        then:
        thrown(HttpClientResponseException)

    }

    def "Infinite Loop Read Timeout, With Error Handler"(){
        when:
        HttpResponse<ImmutablePojo> res = client.toBlocking()
                .retrieve(HttpRequest.POST("/runtime-timeout", new Something() ), ImmutablePojo)
        then:
        thrown(ReadTimeoutException)
    }

}