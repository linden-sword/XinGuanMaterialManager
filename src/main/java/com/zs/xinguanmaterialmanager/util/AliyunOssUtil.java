package com.zs.xinguanmaterialmanager.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/7 19:43
 */
@Component("/aliyunOssUtil")
public class AliyunOssUtil {
    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME;

    @Value("/${aliyun.oss.endpoint}")
    public void setEndpoint(String endpoint) {
        AliyunOssUtil.END_POINT = endpoint;
    }

    @Value("/${aliyun.oss.accessKeyId}")
    public void setKeyId(String keyId) {
        AliyunOssUtil.KEY_ID = keyId;
    }

    @Value("/${aliyun.oss.accessKeySecret}")
    public void setKeySecret(String keySecret) {
        AliyunOssUtil.KEY_SECRET = keySecret;
    }

    @Value("/${aliyun.oss.bucketName}")
    public void setBucketName(String bucketName) {
        AliyunOssUtil.BUCKET_NAME = bucketName;
    }
}


