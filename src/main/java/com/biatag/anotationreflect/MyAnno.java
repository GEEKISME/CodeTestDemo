package com.biatag.anotationreflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
//source是保留级别最低的，只在我们写的代码中存在，
// 源码文件一编译为class，注释就去掉了。若为class类型的话则可以保留到class文件中。runtime保留级别最高
//可以在代码运行时通过反射拿到这些注解
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String name() default "aa";
}
