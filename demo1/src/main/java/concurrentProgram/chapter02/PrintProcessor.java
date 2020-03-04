package concurrentProgram.chapter02;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author：renpeng
 * @date：2019/2/27
 */
public class PrintProcessor extends Thread implements RequestProcssor{
    LinkedBlockingDeque<Request> blockingDeque = new LinkedBlockingDeque();

    public final RequestProcssor nextProcessor;

    public PrintProcessor(RequestProcssor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    //2、通过线程来异步的去处理请求，充分利用cup的资源，来提高性能
    //定制一条责任链的方式，来划分
    @Override
    public void run() {
        while (true){
            try {
                //先构建了一个print，print的下一个是save
                Request request = blockingDeque.take();
                System.out.println("print data:" + request);
                nextProcessor.processorRequest(request);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    //1、PrintProcessor获取请求之后，不是立即去处理，而是放到一个阻塞队列中
    @Override
    public void processorRequest(Request request) {
        blockingDeque.add(request);
    }
}
