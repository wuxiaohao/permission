import annotation.PermissionValue;
import model.Account;
import model.Context;
import Dao.DaoFactory;
import Dao.IAccountDao;


public class Main {
	
	public static void main(String[] args) {
		//����ǰ�߳����ö��͸ĵ�Ȩ��
		Context.INSTATNCE.setCurrentPermission(PermissionValue.READ 
				+ PermissionValue.UPDATE);
		IAccountDao dao = DaoFactory.getDao( IAccountDao.class );
		Account account = dao.load("wxh"); //�������޶�ȡȨ��
		dao.update(account); //���������޸�Ȩ��
		dao.delete("wxh");
	}

}
