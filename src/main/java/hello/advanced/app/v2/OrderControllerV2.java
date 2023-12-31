package hello.advanced.app.v2;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloServiceV1;
import hello.advanced.trace.hellotrace.HelloServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;

    private final HelloServiceV2 trace;

    @GetMapping("v2/request")
    public String request(@RequestParam String itemId) {

        TraceStatus status = null;

        try {
            status = trace.begin("orderController.request()");
            orderService.orderItemId(status.getTraceId(), itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
