package concurrentProgram.chapter02;

/**
 * @author：renpeng
 * @date：2019/2/27
 */
public interface RequestProcssor {
    //通过RequestProcessor去定制一条责任链，在每条责任链里面使用线程去处理
    //责任链希望按照职责去走，有顺序的要求，比如下一步执行的结果依赖上一步执行的结果
      void processorRequest(Request request);
}
