package com.automan.siberia;

public class StringTest {
    /**
     * string测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String a = "hello2"; //常量池
        final String b = "hello"; //常量池，
        String d = "hello"; //常量池
        String c = b + 2; //还在常量池。。。b被final修饰，则无法改变
        String e = d + 2; //堆
        System.out.println((b == d));//true
        System.out.println((a == c));//true
        System.out.println((a == e));//false
        System.out.println(((b + 2) == (d + 2)));//false
        int hashCode1 = System.identityHashCode(a);
        int hashCode2 = System.identityHashCode(b);
        int hashCode3 = System.identityHashCode(c);
        int hashCode4 = System.identityHashCode(d);
        int hashCode5 = System.identityHashCode(e);
        System.out.println("a:" + hashCode1);
        System.out.println("b:" + hashCode2);
        System.out.println("c:" + hashCode3);
        System.out.println("d:" + hashCode4);
        System.out.println("e:" + hashCode5);


        String str1 = "str";
        String str2 = "ing";

        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string"; //常量池中的对象
        String str6 = str1 + "ing";
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false
        System.out.println(str6==str5); //false

        String s="a"+"b"+"c";
        String s1="ab"+"c";
        System.out.println(s==s1);

    }
}
