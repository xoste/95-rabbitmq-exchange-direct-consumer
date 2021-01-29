package com.xoste.rabbitmqexchangedirectconsumer.receiver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * info日志消息接收者
 * @author Leon
 *
 *  * @RabbitListener bindings: 绑定队列
 *  * @QueueBinding
 *  *     value: 绑定队列的名称
 *  *     exchange: 交换器的配置
 *  *     key: 路由键的配置
 *  * @Exchange
 *  *     value: 配置交换器的名称
 *  *     type: 指定具体的交换器类型
 *  * @Queue
 *  *     value: 配置队列名称
 *  *     autoDelete: 是否是一个可删除的临时队列
 *  *
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.DIRECT),
        key = "${rabbitmq.config.queue.info.routing.key}",
        value = @Queue(value = "${rabbitmq.config.queue.info}", autoDelete = "true")

))
public class InfoReceiver {

    /**
     * 接收消息的方法。采用消息队列监听机制
     * */
    @RabbitHandler
    public void infoReceive(String msg) {
        System.out.println("info......Receive:" + msg);
    }
}
