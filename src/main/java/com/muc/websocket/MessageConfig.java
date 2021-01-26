package com.muc.websocket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration

public class MessageConfig {
    @Value("${message.key.package.number}")
    public static int packageNum=4;
    @Value("${message.key.length}")
    public static int keyLength=16;
}
