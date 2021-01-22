package com.muc.websocket;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.*;

public class PackageUtil<T> {
    /**
     * 将秘钥隐藏于加密消息之中
     * @param message
     * @param key
     * @return
     */
    public static String messagePackage(String message, String key) {
        /*key的length为16*/

        byte[] bytes = message.getBytes();
        ArrayList<String> keyStr = split(key, 4);
        ArrayList<String> messageStr = split(message, message.length() / 4);
        ArrayList<String> newKey = new ArrayList<>();
        for (String i : keyStr) {
            newKey.add(getFlower(i));
        }
        StringBuilder contentBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            contentBuilder.append(messageStr.get(i)).append(newKey.get(i));
        }
        return contentBuilder.toString();
    }

    /**
     * 将字符串分割成指定长度的字符串
     * @param message
     * @param length
     * @return
     */
    public static ArrayList<String> split(String message, int length) {
        ArrayList<String> messageList = new ArrayList<String>();
        int size = message.length() / length;
        if (message.length() % length != 0) {
            size += 1;
        }

        for (int index = 0; index < size; index++) {
            String childStr = null;
            if (index == 0) {
                childStr = substring(message, index * length, (index + 1) * length);
            } else {
                childStr = substring(message, index * length, (index + 1) * length);
            }
            messageList.add(childStr);
        }
        return messageList;
    }

    public static String substring(String str, int f, int t) {
        //f:开始位置	t:结束位置
        if (f > str.length()) {
            return null;
        }
        if (t > str.length()) {
            return str.substring(f, str.length());
        } else {
            return str.substring(f, t);
        }
    }

    static class Package {
        public String message;
        public String key;
    }

    /**
     * 将密码解包
     * @param content
     * @return
     */
    public static Package getPackage(String content) {
        char[] chars = content.toCharArray();
        Stack stack = new Stack<Character>();
        ArrayList<String> keyChilds = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char i : chars) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (stack.peek().equals(i) && stringBuilder.toString().length() < 4) {
                stringBuilder.append(stack.pop());
            } else if (stringBuilder.toString().length() > 0) {

                String keyChild = stringBuilder.reverse().toString();
                if (keyChild.length() == 4) {
                    keyChilds.add(keyChild);
                    stringBuilder = new StringBuilder();
                } else {
                    errorBack(stack, keyChild);
                    stringBuilder = new StringBuilder();
                }
                stack.push(i);
            } else {
                stack.push(i);
            }
        }
        String keyChild = stringBuilder.reverse().toString();
        if (keyChild.length() == 4) {
            keyChilds.add(keyChild);
            stringBuilder = new StringBuilder();
        } else {
            errorBack(stack, keyChild);
        }
        StringBuilder keyBuilder = new StringBuilder();
        for (String i : keyChilds) {
            if (i.length() == 4) {
                keyBuilder.append(i);
            }
        }

        Package pa = new Package();
        pa.key = keyBuilder.toString();
        Iterator iterator = stack.iterator();
        StringBuilder contentBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            contentBuilder.append(iterator.next());
        }
        pa.message = contentBuilder.toString();

        return pa;
    }

    /**
     * 将非秘钥部分出栈的字符串重新入栈。
     *
     * @param stack
     * @param str
     */
    public static void errorBack(Stack stack, String str) {
        for (char j : str.concat(getFlower(str)).toCharArray()) {
            stack.push(j);
        }
    }

    /**
     * 获取水仙花类型的字符串
     *
     * @param str
     * @return
     */
    public static String getFlower(String str) {
        StringBuilder backBuilder = new StringBuilder();
        char[] arr = str.toCharArray();
        for (char j : arr) {
            backBuilder.insert(0, j);
        }
        return str.concat(backBuilder.toString());
    }

    public static void main(String[] args) {
        String key = "1a2b3c4d5e6f7g8h";
        ArrayList<String> keyChlids = PackageUtil.split(key, 4);
        String content = "U2FsdGVkX1/cQqk8ASUI/XqmLRr23z3DXXTGGaBWLwE=";
        String Package = PackageUtil.messagePackage(content, key);
        Package pa = PackageUtil.getPackage(Package);


    }
}
