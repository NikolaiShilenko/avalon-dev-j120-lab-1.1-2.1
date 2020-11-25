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
		this.id = id;
		if(idIsNotUnique(0)) 
			/* в пареметры метода idIsNotUnique() подаётся 0 для имитации работы конструктора, 
			но в реальной задаче нужно получать значение id из какого-либо хранилища*/
		{
			throw new UserException("User's id is not unique");
		}
		this.name = name;
		if(nameIsNotValid()) {
			throw new UserException("User's name is not valid");
		}
		this.isAdmin = isAdmin;
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
		try {
			clone = new User(/*(int) (Math.random() * 1001)*/ 0, this.name, this.isAdmin);
			return clone;
		} catch(UserException e) {
			if(clone.nameIsNotValid()) {
				throw new CloneNotSupportedException();
			} else {
				while (clone.idIsNotUnique(0)) {
					clone.setId((int) (Math.random() * 1001));
				}
			}
		}
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
	 
	/** Метод проверяет идентификатор пользователя на не уникальность.
	 *  @param otherId должен принимать значение из хранилища
	 *  всех идентификаторов (массива, списка, таблицы базы данных и пр.), существующих пользователей 
	 *  и сравнивается со значением id текущего объекта.
	 *  @return true если значения равны (то есть id - не уникален).
	 */
	 
	 protected boolean idIsNotUnique(int otherId) {
		 return id == otherId;
	 }

	/** Метод проверяет имя пользователя на невалидность.
	 *  Если имя содержит null или является пустым (не содержит символов или содержит только пробелы),
	 *  то оно считается невалидным.
	 *  @return true, если name содержит null или пустую строку.
	 */
	 
	 protected boolean nameIsNotValid() {
		 return name == null || name.trim().isEmpty();
	 }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", isAdmin=" + isAdmin + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	 
	 
	 
}
