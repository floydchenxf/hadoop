package org.apache.hadoop.hdfs.server.namenode.passwdspi;

import java.util.List;

/**
 * 密码获取者
 */
public interface PasswordFetcher {

    /**
     * 获取用户信息
     *
     * @return
     */
    List<UserInfo> fetchUserInfo();
}
