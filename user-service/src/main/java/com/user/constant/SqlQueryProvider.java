package com.user.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SqlQueryProvider {

    @Value("${insert.login}")
    public String insertLogin;

    @Value("${insert.passenger}")
    public String insertPassenger;

    @Value("${select.login}")
    public String selectLogin;
}
