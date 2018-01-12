package org.apache.hadoop.security.protocolPB;

import com.google.protobuf.RpcController;
import com.google.protobuf.ServiceException;
import org.apache.hadoop.security.RefreshCheckUserPasswordProtocol;
import org.apache.hadoop.security.proto.RefreshCheckUserPasswordProtocolProtos;

import java.io.IOException;

public class RefreshCheckUserPasswordProtocolServerSideTranslatorPB implements RefreshCheckUserPasswordProtocolPB {

    private final RefreshCheckUserPasswordProtocol impl;

    private final static RefreshCheckUserPasswordProtocolProtos.RefreshCheckUserPasswordResponseProto
            VOID_REFRESH_CHECK_USERPASSWORD_RESPONSE = RefreshCheckUserPasswordProtocolProtos.RefreshCheckUserPasswordResponseProto
            .newBuilder().build();

    public RefreshCheckUserPasswordProtocolServerSideTranslatorPB(
            RefreshCheckUserPasswordProtocol impl) {
        this.impl = impl;
    }

    @Override
    public RefreshCheckUserPasswordProtocolProtos.RefreshCheckUserPasswordResponseProto refreshCheckUserPassword(RpcController controller, RefreshCheckUserPasswordProtocolProtos.RefreshCheckUserPasswordRequestProto request) throws ServiceException {
        try {
            impl.refreshCheckUserPassword();
        } catch (IOException e) {
            throw new ServiceException(e);
        }
        return VOID_REFRESH_CHECK_USERPASSWORD_RESPONSE;
    }
}
