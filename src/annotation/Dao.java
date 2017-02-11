package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ��Ҫע�뵽DAO�ӿ���
 * ��ע����Ϊ���ô������֪��ĳ���ӿ��ǽ���ĳ��ʵ����ȥ�����
 * @author wxh
 *
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dao {

	//Daoʵ�����class
	Class<?> value(); 
	
}
