package Dao;

import model.Account;

public class AccountDao implements IAccountDao {
	@Override
	public void create(Account account) {
		System.out.println("����Account");
	}
	@Override
	public void delete(String name) {
		System.out.println("ɾ��Account");
	}
	@Override
	public void update(Account account) {
		System.out.println("�޸�Account");
	}
	@Override
	public Account load(String name) {
		System.out.println("��ȡAccount");
		Account account = new Account();
		account.setName(name);
		return account ;
	}
	@Override
	public void createAndUpdate(Account... accounts) {
		System.out.println("����������");
	}

}
