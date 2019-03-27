package com.example.mydagger2.di.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by beijixiong on 2019/3/23.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ForBoy {
}
