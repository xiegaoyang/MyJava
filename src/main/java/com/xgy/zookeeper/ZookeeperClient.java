package com.xgy.zookeeper;


import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * Created by hadoop on 2017/5/20.
 */
public class ZookeeperClient {

    private static final int TIME_OUT = 3000;
    private static final String HOST = "xiegy:2181";

    public static void main(String[] args) throws Exception {

        ZooKeeper zookeeper = new ZooKeeper(HOST, TIME_OUT, null);
        System.out.println("=========创建节点===========");

        if (zookeeper.exists("/test", false) == null) {
            zookeeper.create("/test", "znode1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        System.out.println("=============查看节点是否安装成功===============");
        System.out.println(new String(zookeeper.getData("/test", false, null)));

        System.out.println("=========修改节点的数据==========");
        String data = "zNode2";
        zookeeper.setData("/test", data.getBytes(), -1);

        System.out.println("========查看修改的节点是否成功=========");
        System.out.println(new String(zookeeper.getData("/test", false, null)));

//        System.out.println("=======删除节点==========");
//        zookeeper.delete("/test", -1);

        System.out.println("==========查看节点是否被删除============");
        System.out.println("节点状态：" + zookeeper.exists("/test", false));

        zookeeper.close();
    }


//    public static void main(String[] args) {
//        // 创建一个与服务器的连接
//        ZooKeeper zk = new ZooKeeper("localhost:" + CLIENT_PORT,
//                ClientBase.CONNECTION_TIMEOUT, new Watcher() {
//            // 监控所有被触发的事件
//            public void process(WatchedEvent event) {
//                System.out.println("已经触发了" + event.getType() + "事件！");
//            }
//        });
//        // 创建一个目录节点
//        zk.create("/testRootPath", "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE,
//                CreateMode.PERSISTENT);
//        // 创建一个子目录节点
//        zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
//                Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
//        System.out.println(new String(zk.getData("/testRootPath",false,null)));
//        // 取出子目录节点列表
//        System.out.println(zk.getChildren("/testRootPath",true));
//        // 修改子目录节点数据
//        zk.setData("/testRootPath/testChildPathOne","modifyChildDataOne".getBytes(),-1);
//        System.out.println("目录节点状态：["+zk.exists("/testRootPath",true)+"]");
//        // 创建另外一个子目录节点
//        zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(),
//                Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
//        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo",true,null)));
//        // 删除子目录节点
//        zk.delete("/testRootPath/testChildPathTwo",-1);
//        zk.delete("/testRootPath/testChildPathOne",-1);
//        // 删除父目录节点
//        zk.delete("/testRootPath",-1);
//        // 关闭连接
//        zk.close();
//    }

}
