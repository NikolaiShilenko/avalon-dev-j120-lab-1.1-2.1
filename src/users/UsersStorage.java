package users;

/**
 * @author Nikolai Shilenko
 *
 */
public class UsersStorage {
	
	static User[] users = new User[100];
	static int userCounter = 0;
	
	private UsersStorage() {}

	/** Метод проверяет наличие идентификатора пользователя в хранилище (уникальность).
	 *  @param id последовательно сравнивается со значениями id каждого пользователя в массиве.
	 *  @return true если значения равны (то есть id - не уникален).
	 */
	
	static boolean hasUserId(int id) {
		for (int i = 0; i < userCounter; i++) {
			if(users[i] != null && users[i].getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	/** Метод проверяет имя пользователя на невалидность.
	 *  Если имя содержит null или является пустым (не содержит символов или содержит только пробелы),
	 *  то оно считается невалидным.
	 *  @return true, если name содержит null или пустую строку.
	 */
	 
	 static boolean nameIsNotValid(String name) {
		 return name == null || name.trim().isEmpty();
	 }

}
