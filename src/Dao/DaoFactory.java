package Dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import proxy.PermissionHandler;
import annotation.Dao;

public class DaoFactory {
	/**
	 * 获取dao
	 * @param infClz Dao接口
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getDao( Class<T> infClz ) {
		
		//通过反射获取到传入进来的class的Dao注解
		Dao anno = infClz.getAnnotation( Dao.class );
		if ( anno == null ) { //如果没有Dao注解
			throw new IllegalArgumentException(infClz.getName() 
											+ "不是一个有效的Dao接口！");
		}
		Class<?> targetClz = anno.value(); //获取Dao注解上声明的类型
		Object target;
		try {
			target = targetClz.newInstance(); //通过反射实例化该类型（Dao实现类）
		} catch (Exception e) {
			throw new IllegalArgumentException("无法实例化Dao的实现类");
		}
		
		//注意：第二个参数是放接口进去，第二个参数是放实现类进去
		return (T) Proxy.newProxyInstance( DaoFactory.class.getClassLoader(), 
				new Class<?>[]{ infClz } ,new PermissionHandler( target ) );
	}
	
}
