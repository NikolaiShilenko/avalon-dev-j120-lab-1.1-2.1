/**
 * 
 */
package users;

/**
 * @author Nikolai Shilenko
 *
 */
public class UsersStorage {

	private UsersStorage() {}
	
	static User[] users = new User[100];
	static int userCounter = 0;
	
	static boolean hasUserId(int id) {
		for (int i = 0; i < users.length; i++) {
			if(users[i] != null && users[i].getId() == id) {
				return true;
			}
		}
		return false;
	}

}
