package concurrentProgram.chapter02;

/**
 * @author：renpeng
 * @date：2019/2/27
 */
public class Demo {
    private PrintProcessor printProcessor;

    public Demo() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    public void doTest(Request request){
        printProcessor.processorRequest(request);
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName("demo请求");
        new Demo().doTest(request);
    }
}
