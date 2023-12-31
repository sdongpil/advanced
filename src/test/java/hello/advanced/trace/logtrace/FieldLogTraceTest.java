package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FieldLogTraceTest {


    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_trace() {
        TraceStatus status = trace.begin("hello1");

        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);

        trace.end(status);



    }
}