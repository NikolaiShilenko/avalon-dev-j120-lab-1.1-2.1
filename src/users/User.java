package users;

import java.util.Objects;

/**
 * @author Nikolai Shilenko
 *
 */

/**
 * Для заданного класса User переопределите конструкторы и методы
 * clone(), equls() и hashCode() в соответствии с указаниями, заданными в
 * комментариях к этим методам:
 * Класс представляет пользователя системы.
 */

public class User {
	
	/** Уникальный идентификатор пользователя. */
	
	 private int id;
	 
	 /** Имя пользователя. */
	 
	 private String name;
	 
	 /** Определяет является ли данный пользователь администратором системы.*/
	 
	 private boolean isAdmin;
	 
	 /** Конструктор по умолчанию. */
	 
	 public User() {
	 }
	 
	 /** 
	  * Конструктор, определяющий все поля класса.
	  * @param id уникальный идентификатор пользователя.
	  * @param name имя пользователя.
	  * @param isAdmin задаёт значение true, если пользователь
	  * является администратором системы.
	  * @throws UserException выбрасывается в случаях, когда:
	  * - идентификатор пользователя не уникален;
	  * - имя пользователя равно null или является пустым.
	  * (Класс данного исключения определите самостоятельно).
	  */
	 
	public User(int id, String name, boolean isAdmin) throws UserException {
		if(UsersStorage.hasUserId(id)) {
			throw new UserException("User's id is not unique");
		}
		if(UsersStorage.nameIsNotValid(name)) {
			throw new UserException("User's name is null or empty");
		}
		this.id = id;
		this.name = name;
		this.isAdmin = isAdmin;
		UsersStorage.users[UsersStorage.userCounter] = this;
		UsersStorage.userCounter++;
	}
	
	/**
	* Метод клонирует объект данного класса по следующим
	* правилам:
	* - имя пользователя name и поле isAdmin дублируются;
	* - для идентификатора id выбирается новое уникальное
	* значение (в данной задаче можно генерировать случайное
	* значение, например, с помощью метода Math.random()).
	* @return ссылка на клон данного объекта.
	* @throws CloneNotSupportedException выбрасывается в
	* случае, когда имя пользователя равно null или является
	* пустой строкой.
	*/
	
	@Override 
	protected Object clone() throws CloneNotSupportedException {
		User clone = new User();
		if (UsersStorage.nameIsNotValid(this.name)) {
			throw new CloneNotSupportedException("User's name is null or empty");
		}
		clone.setName(this.name);
		int cloneId;
		do {
			cloneId = (int) (Math.random() * 1001);
		} while(!UsersStorage.hasUserId(id));
		clone.setId(cloneId);
		clone.setAdmin(this.isAdmin);
		UsersStorage.users[UsersStorage.userCounter] = clone;
		UsersStorage.userCounter++;
		return clone;
	}
	
	/**
	* Метод сравнивает по содержанию текущий объект с объектом
	* obj.
	* @param obj ссылка на объект, с которым сравнивается
	* текущий объект.
	* @return возвращает значение true, если имя пользователя
	* name и значение поля isAdmin у обоих объектов совпадают.
	*/
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return isAdmin == other.isAdmin && Objects.equals(name, other.name);
	}

	/**
	 * Метод возвращает хэш-код данного объекта. Алгоритм
	 * вычисления кода должен учитывать имя пользователя и
	 * значение поля isAdmin.
	 * @return хэш-код объекта.
	 */
	
	@Override
	public int hashCode() {
		return Objects.hash(isAdmin, name);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", isAdmin=" + isAdmin + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	 
}
