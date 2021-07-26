package framework.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZkTest {
    ZooKeeper zooKeeper;
    String connectString = "localhost:2181,localhost:2182,localhost:2183";
    @Before
    public void init() throws IOException {
        zooKeeper = new ZooKeeper(connectString, 3000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("========watchedEvent start========");
                List<String> children = null;
                try {
                    children = zooKeeper.getChildren("/", true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                children.forEach(System.out::println);
                System.out.println("========watchedEvent end========");
            }
        });
    }

    @Test
    public void testCreate() throws InterruptedException, KeeperException {
        String s = zooKeeper.create("/zk", "demo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("========zooKeeper.create========");
        System.out.println(s);
    }
    
    @Test
    public void testGetChildren() throws InterruptedException, KeeperException {
      TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

    @Test
    public void testExists() throws InterruptedException, KeeperException {
        Stat exists = zooKeeper.exists("/java", false);
        System.out.println(exists==null);
    }
    
}
