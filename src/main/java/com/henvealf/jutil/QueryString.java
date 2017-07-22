package com.henvealf.jutil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 代表 URL 查询部分，用于构建 URL 查询部分，并在构建过程中对查询键值对进行编码，
 * 编码格式为 <strong>utf-8</strong>
 * <p>
 * 来源 《Java 网络编程》 Elliotte 著。 P152
 * <p>
 * Created by Henvealf on 2017/3/18.
 * <p>
 * http://git.oschina.net/henvealf
 */
public class QueryString {

    private StringBuilder query = new StringBuilder();
    private final static String ENC = "UTF-8";      // 编码格式

    public QueryString() {
    }

    /**
     * 添加查询参数键值对。
     * @param name
     * @param value
     */
    public synchronized void add(String name, String value) {
        query.append('&');
        encode(name, value);
    }

    public synchronized void addNotEncode(String name, String value) {
        query.append('&');
        notEncode(name,value);
    }

    public synchronized void addFirstNotEncode(String name, String value) {
        notEncode(name,value);
    }

    /**
     * 添加查询参数的第一个键值对，不带&。
     * @param name
     * @param value
     */
    public synchronized void addFirst(String name, String value) {
        encode(name, value);
    }

    /**
     * 对键值对进行编码，并拼接成查询串
     * @param name
     * @param value
     */
    private synchronized void encode(String name, String value) {
        try {
            query.append(URLEncoder.encode(name,ENC));
            query.append('=');
            query.append(URLEncoder.encode(value,ENC));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("当前 VM 不支持 " + ENC + "编码");
        }
    }

    private synchronized void notEncode(String name, String value){
        query.append(name);
        query.append('=');
        query.append(value);
    }

    /**
     * 得到构建的查询串
     * @return
     */
    public synchronized String getQuery(){
        return query.toString();
    }

    @Override
    public String toString() {
        return getQuery();
    }
}