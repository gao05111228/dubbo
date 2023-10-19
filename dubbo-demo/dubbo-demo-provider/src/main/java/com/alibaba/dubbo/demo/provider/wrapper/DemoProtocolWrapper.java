package com.alibaba.dubbo.demo.provider.wrapper;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.RpcException;

public class DemoProtocolWrapper implements Protocol {

    private final Protocol protocol;

    public DemoProtocolWrapper(Protocol protocol) {
        System.out.println("protocolWrapper--------->start!");
        this.protocol = protocol;
        System.out.println("protocolWrapper--------->end!");
    }

    @Override
    public int getDefaultPort() {
        return protocol.getDefaultPort();
    }

    @Override
    public <T> Exporter<T> export(Invoker<T> invoker) throws RpcException {
        return protocol.export(invoker);
    }

    @Override
    public <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException {
        return protocol.refer(type,url);
    }

    @Override
    public void destroy() {
        protocol.destroy();
    }
}
