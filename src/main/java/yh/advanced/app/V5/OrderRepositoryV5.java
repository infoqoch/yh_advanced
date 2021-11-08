package yh.advanced.app.V5;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import yh.advanced.trace.LogTrace;
import yh.advanced.trace.callback.TraceCallback;
import yh.advanced.trace.callback.TraceTemplate;
import yh.advanced.trace.template.AbstractTemplate;

@Repository
public class OrderRepositoryV5 {
    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace logTrace) {
        this.template = new TraceTemplate(logTrace);
    }

    public void save(String itemId){
        template.execute("OrderRepository.save", new TraceCallback<Void>(){
            @Override
            public Void call() {
                if(itemId.equals("ex")){
                    throw new IllegalStateException("예외 발생!!");
                }
                sleep(1000);
                return null;
            }
        });

    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
