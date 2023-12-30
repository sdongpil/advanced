package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class HelloServiceV1Test {



    @Test
    void begin_end() {
        HelloServiceV1 trace = new HelloServiceV1();

        TraceStatus status = trace.begin("start");

        trace.end(status);
    }

    @Test
    void begin_exception() {
        HelloServiceV1 helloServiceV1 = new HelloServiceV1();

        TraceStatus status = helloServiceV1.begin("start");

        helloServiceV1.exception(status, new Exception());
    }
}