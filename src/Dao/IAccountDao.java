package Dao;

import annotation.Permission;
import annotation.Dao;
import annotation.PermissionValue;
import model.Account;

@Dao(AccountDao.class)
public interface IAccountDao {

	//����˺�
	@Permission(PermissionValue.CREATE) //��Ӧ������ 0001
	void create(Account account);
	
	//ɾ���˺�
	@Permission(PermissionValue.DELETE) //��Ӧ������ 0010
	void delete(String name);
	
	//�޸��˺�
	@Permission(PermissionValue.UPDATE) //��Ӧ������ 0100
	void update(Account account);
	
	//��ѯ�˺�
	@Permission(PermissionValue.READ) //��Ӧ������ 1000
	Account load(String name);
	
	@Permission(PermissionValue.CREATE + PermissionValue.UPDATE)
	void createAndUpdate(Account...accounts);
}
