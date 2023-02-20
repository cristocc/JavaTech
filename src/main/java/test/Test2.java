package test;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * Created by crist on 2022/11/11
 *
 * @author cc
 */
public class Test2 {

    public static void main(String[] args) {
        System.out.println(VM.current().details());
        Object obj = new Object();
        System.out.println(obj + " 十六进制哈希：" + Integer.toHexString(obj.hashCode()));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
