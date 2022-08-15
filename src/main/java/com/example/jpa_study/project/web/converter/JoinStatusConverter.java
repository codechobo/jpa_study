package com.example.jpa_study.project.web.converter;

import org.hibernate.engine.transaction.spi.JoinStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class JoinStatusConverter implements Converter<String, JoinStatus> {

    @Override
    public JoinStatus convert(String source) {
        return JoinStatus.valueOf(source.toUpperCase());
    }
}
