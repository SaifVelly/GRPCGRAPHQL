package com.rest.server.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class TestQueryResolver {

    @Autowired
    private MessageSource messageSource;

    @QueryMapping
    public String greeting(@Argument String locale) {
        Locale loc = Locale.forLanguageTag(locale);
        return messageSource.getMessage("greeting", null, loc);
    }

    @QueryMapping
    public String currentDate(@Argument String locale) {
        Locale loc = Locale.forLanguageTag(locale);
        String dateFormat = messageSource.getMessage("date.format", null, loc);
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(new Date());
    }

    @QueryMapping
    public String triggerServerError() {
        throw new RuntimeException("Something is wrong with server, try again later");
    }
}
