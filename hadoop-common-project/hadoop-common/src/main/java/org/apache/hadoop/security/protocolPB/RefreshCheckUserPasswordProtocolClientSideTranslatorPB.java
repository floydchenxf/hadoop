package org.apache.hadoop.security.protocolPB;

import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import org.apache.hadoop.ipc.ProtobufHelper;
import org.apache.hadoop.ipc.ProtocolMetaInterface;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RpcClientUtil;
import org.apache.hadoop.security.RefreshCheckUserPasswordProtocol;
import org.apache.hadoop.security.proto.RefreshCheckUserPasswordProtocolProtos;

import java.io.Closeable;
import java.io.IOException;

public class RefreshCheckUserPasswordProtocolClientSideTranslatorPB implements
        ProtocolMetaInterface, RefreshCheckUserPasswordProtocol, Closeable {

    private final static RpcController NULL_CONTROLLER = null;
    private final static RefreshCheckUserPasswordProtocolProtos.RefreshCheckUserPasswordRequestProto
            VOID_REFRESH_CHECK_USER_PASSWORD_REQUEST =
            RefreshCheckUserPasswordProtocolProtos.RefreshCheckUserPasswordRequestProto.newBuilder().build();
    private final RefreshCheckUserPasswordProtocolPB rpcProxy;

    public RefreshCheckUserPasswordProtocolClientSideTranslatorPB(
            RefreshCheckUserPasswordProtocolPB rpcProxy) {
        this.rpcProxy = rpcProxy;
    }

    @Override
    public void close() throws IOException {
        RPC.stopProxy(rpcProxy);
    }

    @Override
    public boolean isMethodSupported(String methodName) throws IOException {
        return RpcClientUtil.isMethodSupported(rpcProxy,
                RefreshCheckUserPasswordProtocolPB.class,
                RPC.RpcKind.RPC_PROTOCOL_BUFFER,
                RPC.getProtocolVersion(RefreshCheckUserPasswordProtocolPB.class),
                methodName);
    }

    @Override
    public void refreshCheckUserPassword() throws IOException {
        try {
            rpcProxy.refreshCheckUserPassword(NULL_CONTROLLER,
                    VOID_REFRESH_CHECK_USER_PASSWORD_REQUEST);
        } catch (ServiceException se) {
            throw ProtobufHelper.getRemoteException(se);
        }
    }
}
