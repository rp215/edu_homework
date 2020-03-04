package concurrentProgram.chapter02;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author：renpeng
 * @date：2019/2/27
 */
public class SaveProcessor extends Thread implements RequestProcssor{
    LinkedBlockingDeque<Request> blockingDeque = new LinkedBlockingDeque();

    @Override
    public void run() {
        while (true){
            try {
                Request request = blockingDeque.take();
                System.out.println("save data:" + request);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void processorRequest(Request request) {
        blockingDeque.add(request);
    }
}
