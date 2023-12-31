package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloServiceV2Test {



    @Test
    void begin_end() {
        HelloServiceV2 trace = new HelloServiceV2();
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.beginSYnc(status1.getTraceId(), "hello2");

        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception() {
        HelloServiceV2 helloServiceV2 = new HelloServiceV2();

        TraceStatus status = helloServiceV2.begin("start");

        helloServiceV2.exception(status, new Exception());
    }
}