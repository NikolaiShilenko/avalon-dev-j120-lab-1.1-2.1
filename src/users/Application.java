package users;

import java.io.PrintStream;
import java.util.Arrays;

import services.StringArrayException;
import services.StringService;

/**
 * @author Nikolai Shilenko
 *
 */
public class Application {

	public static void main(String[] args) {
		
		PrintStream p = System.out;

		p.println("Задача № 1");
		p.println();

		User johnny = null;
		try {
			johnny = new User((int) (Math.random() * 1001), "Johnny", true);
		} catch (UserException e) {
			p.println("Что-то пошло не так: " + e.getMessage());
		}

		User billy = null;
		try {
			billy = new User((int) (Math.random() * 1001), "Billy", false);
		} catch (UserException e) {
			p.println("Что-то пошло не так: " + e.getMessage());
		}

		p.println("Создан " + johnny.toString());
		p.println("Создан " + billy.toString());
		p.println("Создано пользователей: " + UsersStorage.userCounter);
		p.println("В хранилище: " + Arrays.toString(UsersStorage.users));

		User cloneJohnny = null;
		try {
			cloneJohnny = (User) johnny.clone();
		} catch (CloneNotSupportedException e) {
			p.println("Что-то пошло не так: " + e.getMessage());
		}

		p.println("Клонирован " + johnny.toString());
		p.println("Данные клона: " + cloneJohnny.toString());
		p.println("Создано пользователей: " + UsersStorage.userCounter);
		p.println("В хранилище: " + Arrays.toString(UsersStorage.users));
		p.println();

		p.println("Проверка методов equals() и hashCode() на объектах с идентичными значениями полей name и isAdmin");
		p.println("equals() " + johnny.equals(cloneJohnny));
		p.println("hashCode() " + (johnny.hashCode() == cloneJohnny.hashCode()));
		p.println("Проверка методов equals() и hashCode() на объектах с разными значениями полей name и isAdmin");
		p.println("equals() " + johnny.equals(billy));
		p.println("hashCode() " + (johnny.hashCode() == billy.hashCode()));
		p.println();

		p.println(
				"................................................................................................");
		p.println();
		p.println("Задача № 2.");
		p.println();
		p.println("Проверка метода sort(). Передаём в метод пустой массив.");

		String[] arr1 = new String[0];
		try {
			StringService.sort(arr1, true);
		} catch (StringArrayException e) {
			p.println("Что-то пошло не так: " + e.getMessage());
		}
		p.println("Метод вернул: ");
		p.println(Arrays.toString(arr1));
		p.println();

		p.println("Проверка метода sort(). Передаём в метод null.");
		String[] arr2 = null;
		try {
			StringService.sort(arr2, true);
		} catch (StringArrayException e) {
			p.println("Что-то пошло не так: " + e.getMessage());
		}
		p.println("Метод вернул: ");
		p.println(Arrays.toString(arr2));
		p.println();

		p.println("Проверка метода sort(). Передаём в метод массив: ");
		String[] arr3 = { "Alex", "Joshua", "Floyd", "Henry", "Nicholas", "Bruce", };
		p.println(Arrays.toString(arr3));
		p.println();

		try {
			StringService.sort(arr3, true);
		} catch (StringArrayException e) {
			p.println("Что-то пошло не так: " + e.getMessage());
		}
		p.println("Сортируем массив по возрастанию.");
		p.println("Метод вернул: ");
		p.println(Arrays.toString(arr3));
		p.println();

		try {
			StringService.sort(arr3, false);
		} catch (StringArrayException e) {
			p.println("Что-то пошло не так: " + e.getMessage());
			e.printStackTrace();
		}
		p.println("Сортируем массив по убыванию.");
		p.println("Метод вернул: ");
		p.println(Arrays.toString(arr3));
		p.println();

		p.println("Проверка метода getCharStat().");
		String str = "Arabica + Robusta";
		p.println("Строка: " + str + " после обработки в методе: " + Arrays.toString(StringService.getCharStat(str)));
		p.println();
	}

}
