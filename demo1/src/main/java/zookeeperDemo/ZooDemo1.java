package zookeeperDemo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author：renpeng
 * @date：2019/7/18
 */
public class ZooDemo1 {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            // 如果是集群，用“，”隔开
            ZooKeeper zooKeeper = new ZooKeeper("192.168.117.138:2181",
                    4000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (Event.KeeperState.SyncConnected == watchedEvent.getState()){
                        countDownLatch.countDown();
                    }
                }
            });

            // 阻塞主线程（CountDownLatch 是能使一组线程等另一组线程都跑完了再继续跑 ,CountDownLatch.await() 方法在倒计数为0之前会阻塞当前线程。）
            countDownLatch.await();

            // 查看连接状态，客户端连接服务端会建立一个会话
            System.out.println(zooKeeper.getState());//CONNECTED

            // 创建节点（增）
            // "0".getBytes()——节点的value
            // ZooDefs.Ids.OPEN_ACL_UNSAFE——设置节点的权限
            // CreateMode.PERSISTENT——设置节点的特性（持久化/临时）
            zooKeeper.create("/localtest", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);


            // 获取节点（查）
            // stat.getVersion()——节点的版本号
            Stat stat = new Stat();
            byte[] bytes = zooKeeper.getData("/localtest", null, stat);
            System.out.println(new String(bytes));

            // 修改节点（改）,首先根据url获取节点的信息
            zooKeeper.setData("/localtest","1".getBytes(), stat.getVersion());

            // 删除节点（删）
            zooKeeper.delete("/localtest", stat.getVersion());

            zooKeeper.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }


    }
}
