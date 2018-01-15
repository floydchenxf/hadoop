package org.apache.hadoop.hdfs.web.resources;

import java.text.MessageFormat;
import java.util.regex.Pattern;

import static org.apache.hadoop.hdfs.DFSConfigKeys.DFS_WEBHDFS_USER_PATTERN_DEFAULT;

public class PasswordParam extends StringParam {

    public static final String PASSWORD = "user.passwd";

    private static Domain domain = new Domain(PASSWORD, Pattern.compile(DFS_WEBHDFS_USER_PATTERN_DEFAULT));

    public static final String DEFAULT = "";

    public PasswordParam(String str) {
        super(domain, str == null || str.equals(DEFAULT) ? null : validateLength(str));
    }

    public PasswordParam(Domain domain, String str) {
        super(domain, str);
    }

    private static String validateLength(String str) {
        if (str == null) {
            throw new IllegalArgumentException(
                    MessageFormat.format("Parameter [{0}], cannot be NULL", PASSWORD));
        }
        int len = str.length();
        if (len < 1) {
            throw new IllegalArgumentException(MessageFormat.format(
                    "Parameter [{0}], it's length must be at least 1", PASSWORD));
        }
        return str;
    }

    @Override
    public String getName() {
        return PASSWORD;
    }
}
