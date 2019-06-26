package com.etix.demo;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationPath("api")
public class DemoApp extends Application {
    private final static Set<Class<?>> classes = Stream.of(DemoResource.class).collect(Collectors.toSet());

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
