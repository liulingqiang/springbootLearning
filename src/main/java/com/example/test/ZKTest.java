package com.example.test;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZKTest {
    private ZooKeeper zookeeper;

    /**
     * 链接zookeeper
     * @return
     * @throws IOException
     */
    public ZooKeeper zkConnect( ) throws IOException {
        //zookeeper的ip:端口
        String path = "10.201.60.108:2181";
        //第二个参数是超时时间，第三个参数是设置观察者,现在可以先不管
        zookeeper = new ZooKeeper(path, 20 * 1000, null);
        return zookeeper;
    }

    /**
     * 创建znode节点
     * @param path　znode的路径
     * @param value　znode的值
     * @param watcher
     * @param node //创建node的模式
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void createZnode(String path, byte[] value, Watcher watcher, CreateMode node ) throws KeeperException, InterruptedException {
        zookeeper.create(path, value, ZooDefs.Ids.OPEN_ACL_UNSAFE, node);
    }

    /**
     * 通过path获得znode的值
     * @param path
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public String getZnodeValue(String path ) throws KeeperException, InterruptedException {
        //第二个值是代表是否开启监听，这里还是先不管.第三个参数就是结构体
        byte[] data = zookeeper.getData(path, false, new Stat());
        return new String(data);
    }

    public void close() {
        try {
            if (zookeeper != null) {
                zookeeper.close();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        //===============================创建会话======================================
            ZKTest zookeeperDemo = new ZKTest();
            //获取连接
            ZooKeeper zooKeeper = zookeeperDemo.zkConnect();

            //创建znode
            //zookeeperDemo.createZnode("/amber", "hahaha".getBytes(), null, CreateMode.PERSISTENT);
            //获取znode的值
           // String znodeValue = zookeeperDemo.getZnodeValue("/amber");
            //System.out.println(znodeValue);

            zookeeperDemo.close();

    }
}
