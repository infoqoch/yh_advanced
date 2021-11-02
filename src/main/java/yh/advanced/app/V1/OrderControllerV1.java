package yh.advanced.app.V1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yh.advanced.trace.TraceStatus;
import yh.advanced.trace.hellotrace.HelloTraceV1;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 helloTraceV1;

    @GetMapping("v1/request")
    public String request(String itemId){
        System.out.println("hihihiFGFWEFEWF");
        TraceStatus begin = null;
        try{
            begin = helloTraceV1.begin("OrderControllerV1.request");
            orderService.orderItem(itemId);
            helloTraceV1.end(begin);
            return "ok";
        }catch (Exception e){
            helloTraceV1.exception(begin, e);
            throw e;
        }

    }
}
