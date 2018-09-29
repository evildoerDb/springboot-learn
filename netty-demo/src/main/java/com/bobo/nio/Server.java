package com.bobo.nio;


import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by evildoerdb_ on 2018/9/20
 */
public class Server {

    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap();

        ExecutorService boos = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();


        //设置niosocket工厂
        bootstrap.setFactory(new NioServerSocketChannelFactory(boos,worker));

        //设置管道工厂
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {

                ChannelPipeline channelPipeline = Channels.pipeline();
                channelPipeline.addLast("decoder",new StringDecoder());
                channelPipeline.addLast("encoder",new StringDecoder());
                channelPipeline.addLast("hello-handler",new HelloHandler());
                return channelPipeline;
            }
        });

        bootstrap.bind(new InetSocketAddress(10101));
        System.out.println("start");


    }
}
