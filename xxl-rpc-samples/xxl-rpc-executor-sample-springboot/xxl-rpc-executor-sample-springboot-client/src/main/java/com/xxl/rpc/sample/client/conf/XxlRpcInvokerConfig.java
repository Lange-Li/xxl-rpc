package com.xxl.rpc.sample.client.conf;

import com.xxl.rpc.registry.impl.NativeServiceRegistry;
import com.xxl.rpc.remoting.invoker.impl.XxlRpcSpringInvokerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * xxl-rpc invoker config
 *
 * @author xuxueli 2018-10-19
 */
@Configuration
public class XxlRpcInvokerConfig {
    private Logger logger = LoggerFactory.getLogger(XxlRpcInvokerConfig.class);


    @Value("${xxl-rpc.registry.native.adminaddress}")
    private String adminaddress;

    @Value("${xxl-rpc.registry.native.env}")
    private String env;


    @Bean
    public XxlRpcSpringInvokerFactory xxlJobExecutor() {

        XxlRpcSpringInvokerFactory invokerFactory = new XxlRpcSpringInvokerFactory();
        invokerFactory.setServiceRegistryClass(NativeServiceRegistry.class);
        invokerFactory.setServiceRegistryParam(new HashMap<String, String>(){{
            put(NativeServiceRegistry.XXL_RPC_ADMIN, adminaddress);
            put(NativeServiceRegistry.ENV, env);
        }});

        logger.info(">>>>>>>>>>> xxl-rpc invoker config init finish.");
        return invokerFactory;
    }

}