package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要注入到DAO接口中
 * 该注解是为了让代理对象知道某个接口是交给某个实现类去处理的
 * @author wxh
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dao {

	//Dao实现类的class
	Class<?> value(); 
	
}
