/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

package com.baidu.brpc.protocol;

import java.util.Map;

import com.baidu.brpc.RpcMethodInfo;
import com.baidu.brpc.client.RpcFuture;
import com.baidu.brpc.protocol.nshead.NSHead;
import com.baidu.brpc.protocol.push.SPHead;

import io.netty.buffer.ByteBuf;

public interface Response {
    Object getResult();

    void setResult(Object result);

    /**
     * used to find RpcFuture, application can not set it.
     * @return rpc future id
     */
    long getCorrelationId();

    void setCorrelationId(long correlationId);

    /**
     * used to identify request for application, application can set it.
     * @return application request id
     */
    long getLogId();

    void setLogId(long logId);

    Throwable getException();

    NSHead getNsHead();

    SPHead getSpHead();

    void setNsHead(NSHead nsHead);

    void setException(Throwable exception);

    RpcMethodInfo getRpcMethodInfo();

    void setRpcMethodInfo(RpcMethodInfo rpcMethodInfo);

    RpcFuture getRpcFuture();

    void setRpcFuture(RpcFuture rpcFuture);

    Map<String, Object> getKvAttachment();

    void setKvAttachment(Map<String, Object> kvAttachment);

    ByteBuf getBinaryAttachment();

    void setBinaryAttachment(ByteBuf binaryAttachment);

    int getCompressType();

    void setCompressType(int compressType);

    boolean isHeartbeat();

    void setHeartbeat(boolean heartbeat);

    void reset();
}
