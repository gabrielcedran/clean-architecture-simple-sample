package br.com.cedran.application.configuration;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(Application.class)
public @interface EnableApplicationLayer {
}
