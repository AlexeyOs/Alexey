package ru.osetsky.tracker.start;

/**
 * Created by koldy on 21.06.2017.
 */
public class ValidateInput extends  ConsoleInput {
	/**
	 * Method ask is public.
	 * @param question is String
	 * @param range is array type integer.
	 * @return value.
	 */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
		/**
		 * Operator try for find mistake.
		 */
		do {
			try {
				value = super.ask(question, range);
				invalid = false;
			} catch (MenuOutException moe) {
				System.out.println("Please select key from menu. ");
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter validate data again. ");
			}
		} while (invalid);
		return value;
    }
}
