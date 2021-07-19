package framework.zk;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ZkTest {
    ZooKeeper zooKeeper;
    String connectString = "localhost:2181,localhost:2182,localhost:2183";
    @Before
    public void init() throws IOException {
        zooKeeper = new ZooKeeper(connectString, 3000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("========watchedEvent.getPath()========");
                System.out.println(watchedEvent);
            }
        });
    }

    @Test
    public void testCreate() throws InterruptedException, KeeperException {
        String s = zooKeeper.create("/zk", "demo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("========zooKeeper.create========");
        System.out.println(s);

    }
}
