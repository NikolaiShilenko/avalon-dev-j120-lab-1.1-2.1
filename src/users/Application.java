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
		User billy = null;
		try {
			johnny = new User((int) (Math.random() * 1001), "Johnny", true);
			billy = new User((int) (Math.random() * 1001), "Billy", false);
			p.println("Создан " + johnny.toString());
			p.println("Создан " + billy.toString());
		} catch (UserException e) {
			p.println("Что-то пошло не так: " + e.getMessage());
		} catch (NullPointerException e) {
			p.println("Объект класса User не был создан: " + e.getMessage());
		}
		p.println("Общее количество созданных пользователей: " + UsersStorage.userCounter);
		p.println("Вывод информации находящейся в хранилище: " + Arrays.toString(UsersStorage.users));
		p.println();

		User cloneJohnny = null;
		try {
			cloneJohnny = (User) johnny.clone();
			p.println("Клонирован " + johnny.toString());
			p.println("Данные клона: ");
			p.println(cloneJohnny.toString());
		} catch (CloneNotSupportedException e) {
			p.println("Что-то пошло не так: " + e.getMessage());
		} catch (NullPointerException e) {
			p.println("Клонирование не удалось. Проверьте был ли создан объект-оригинал: " + e.getMessage());
		}
		p.println("Общее количество созданных пользователей: " + UsersStorage.userCounter);
		p.println("Вывод информации находящейся в хранилище: " + Arrays.toString(UsersStorage.users));
		p.println();

		try {
			p.println("Проверка методов equals() и hashCode().");
			boolean a = johnny.equals(cloneJohnny);
			boolean b = johnny.hashCode() == cloneJohnny.hashCode();
			boolean c = johnny.equals(billy);
			boolean d = johnny.hashCode() == billy.hashCode();
			p.println("Проверка методов equals() и hashCode() на объектах с идентичными значениями полей name и isAdmin");
			p.println("Метод equals() возвращает " + a);
			p.println("Метод hashCode() возвращает " + b);
			p.println("Проверка методов equals() и hashCode() на объектах с разными значениями полей name и isAdmin");
			p.println("Метод equals() возвращает " + c);
			p.println("Метод hashCode() возвращает " + d);
		} catch (NullPointerException e) {
			p.println("Проверка не возможна. Проверьте были ли созданы сравниваемые объекты: " + e.getMessage());
		}

		p.println("................................................................................................");
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
		p.println("Метод sort() возвращает: ");
		p.println(Arrays.toString(arr1));
		p.println();

		p.println("Проверка метода sort(). Передаём в метод null-ссылку.");
		String[] arr2 = null;
		try {
			StringService.sort(arr2, true);
		} catch (StringArrayException e) {
			p.println("Что-то пошло не так: " + e.getMessage());
		}
		p.println("Метод sort() возвращает: ");
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
		p.println("Метод sort() возвращает: ");
		p.println(Arrays.toString(arr3));
		p.println();

		try {
			StringService.sort(arr3, false);
		} catch (StringArrayException e) {
			p.println("Что-то пошло не так: " + e.getMessage());
			e.printStackTrace();
		}
		p.println("Сортируем массив по убыванию.");
		p.println("Метод sort() возвращает: ");
		p.println(Arrays.toString(arr3));
		p.println();

		p.println("Проверка метода getCharStat().");
		String str = "Arabica + Robusta = fast coding";
		char[] charStat = StringService.getCharStat(str);
		p.println("Общее количество символов в строке: " + "\"" + str + "\"" + " = " + str.length());
		p.println("Количество уникальных символов символов: " + charStat.length);
		p.println("Уникальные символы в строке: " + Arrays.toString(charStat));
		p.println();
	}

}
