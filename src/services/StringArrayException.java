package services;

/**
 * @author Nikolai Shilenko
 *
 */
public class StringArrayException extends Exception {

	private static final long serialVersionUID = 1561863646158269907L;
	private static final String DEFAUTL_DESCRIPTION = "Common error";
	
	 /**
	 * Конструктор по умолчанию.
	 */
	 public StringArrayException() {
		 super(DEFAUTL_DESCRIPTION);
	 }
	 
	 /**
	 * Конструктор с описанием причины возникновения исключения.
	 *
	 * @param string описание причины возникновения исключения.
	 */
	 public StringArrayException(String string) {
		 super(string);
	 }
	 
}
