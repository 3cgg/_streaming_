package test.me.libme.storm;

import me.libme.module.zookeeper.ZKExecutor;
import me.libme.module.zookeeper.ZooKeeperConnector;

/**
 * Created by J on 2018/9/29.
 */
public class TestZK {


    public static void main(String[] args) throws Exception {

        ZooKeeperConnector.ZookeeperExecutor executor= ZKExecutor.defaultExecutor();


        // do crud

        String path="/b";

        executor.createPath(path,"data:a");

        byte[] data=executor.getPath(path);

        System.out.println(new String(data,"utf-8"));

        executor.setPath(path,"data:another-a");

        byte[] adata=executor.getPath(path);

        System.out.println(new String(adata,"utf-8"));

        String child=path+"/child_path";

        String r=executor.createPath(child);

        boolean exitsChild=executor.exists(child);

        System.out.println("exists : " +exitsChild);

        executor.deletePath(path);

        System.out.println("==========================OK=====================================");




    }



}
