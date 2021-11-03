package yh.advanced.trace.threadloca.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {
    private String nameStore;

    // 쓰고 (쓰기 작업 후) 1초 뒤 해당 데이터를 읽는다.
    public String logic(String name){
        this.nameStore = name;
        sleep(1000);
        log.info("write name :{} ===store===> {}", name, nameStore);
        return nameStore;
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
