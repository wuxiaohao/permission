package Dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import proxy.PermissionHandler;
import annotation.Dao;

public class DaoFactory {
	/**
	 * ��ȡdao
	 * @param infClz Dao�ӿ�
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getDao( Class<T> infClz ) {
		
		//ͨ�������ȡ�����������class��Daoע��
		Dao anno = infClz.getAnnotation( Dao.class );
		if ( anno == null ) { //���û��Daoע��
			throw new IllegalArgumentException(infClz.getName() 
											+ "����һ����Ч��Dao�ӿڣ�");
		}
		Class<?> targetClz = anno.value(); //��ȡDaoע��������������
		Object target;
		try {
			target = targetClz.newInstance(); //ͨ������ʵ���������ͣ�Daoʵ���ࣩ
		} catch (Exception e) {
			throw new IllegalArgumentException("�޷�ʵ����Dao��ʵ����");
		}
		
		//ע�⣺�ڶ��������ǷŽӿڽ�ȥ���ڶ��������Ƿ�ʵ�����ȥ
		return (T) Proxy.newProxyInstance( DaoFactory.class.getClassLoader(), 
				new Class<?>[]{ infClz } ,new PermissionHandler( target ) );
	}
	
}
