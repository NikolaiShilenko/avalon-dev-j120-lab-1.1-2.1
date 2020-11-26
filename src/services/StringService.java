package services;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Nikolai Shilenko
 *
 */

public class StringService {

	static Comparator<String> c1 = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	};

	static Comparator<String> c2 = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	};

	/**
	 * Метод сортирует массив строк, заданных параметром as.
	 * @param as  исходный массив строк.
	 * @param dir определяет порядок сортировки строк: если данный параметр равен
	 * true, то строки сортируются в алфавитном порядке, а если данный
	 * параметр равен false, то строки сортируются в обратном порядке.
	 * @return возвращается отсортированный массив строк.
	 * @throws StringArrayException данное исключение выбрасывается в случае, если
	 * ссылка на исходный массив as равна null или в
	 * случае когда массив as пуст.
	 */

	public static String[] sort(String[] as, boolean dir) throws StringArrayException {
		if (as == null) {
			throw new StringArrayException("Array reference is null");
		}
		if (as.length == 0) {
			throw new StringArrayException("Array is empty");
		}
		if (dir) {
			Arrays.sort(as, c1);
		} else {
			Arrays.sort(as, c2);
		}
		return as;
	}

	/**
	 * Метод возвращает набор символов, каждый из которых хотя бы один раз
	 * встречается в исходной строке str.
	 * @param str исходная строка.
	 * @return массив уникальный символов, каждый из которых хотя бы один раз
	 * встречается в исходной строке str. Если ссылка на исходный массив
	 * равна null, то метод также возвращает null. Если исходная строка
	 * пуста, то возвращается пустой массив.
	 */

	public static char[] getCharStat(String str) {
		if(str == null)
			return null;
		if(str.isEmpty())
			return new char[0];
		String modifiedStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (!modifiedStr.contains(str.charAt(i) + ""))
				modifiedStr += str.charAt(i);
		}
		return modifiedStr.toCharArray();
	}

}
