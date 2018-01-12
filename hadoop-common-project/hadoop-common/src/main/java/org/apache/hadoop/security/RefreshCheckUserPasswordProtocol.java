package org.apache.hadoop.security;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.fs.CommonConfigurationKeys;
import org.apache.hadoop.io.retry.Idempotent;

import java.io.IOException;

@KerberosInfo(
        serverPrincipal = CommonConfigurationKeys.HADOOP_SECURITY_SERVICE_USER_NAME_KEY)
@InterfaceAudience.LimitedPrivate({"HDFS", "MapReduce"})
@InterfaceStability.Evolving
public interface RefreshCheckUserPasswordProtocol {

    public static final long versionID = 1L;

    /**
     * refresh and check password
     *
     * @throws IOException
     */
    @Idempotent
    void refreshCheckUserPassword() throws IOException;
}
