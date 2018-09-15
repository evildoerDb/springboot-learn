package com.bobo.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by evildoerdb_ on 2018/9/14
 */
public class KafkaProducerDemo {
    public static void main(String[] args) {
        //创建配置文件
        Properties properties = new Properties();

        //设置kafka服务器的地址
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "阿里云公网ip:9092");
        //设置key的序列化方式
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        //设置vaklue的序列化方式
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        //
        properties.put(ProducerConfig.RETRIES_CONFIG,"1");

        //创建生产者对象
        KafkaProducer<String,String> producer = new KafkaProducer<>(properties);
        //创建消息实体  指定topic、key、value
        ProducerRecord<String,String> record = new ProducerRecord<>("Hello-world","haha","from java client");

        //发送消息
        producer.send(record);

        System.out.println("消息发送成功");
        producer.close();


    }
}
