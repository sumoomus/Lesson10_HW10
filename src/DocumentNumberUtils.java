
    public class DocumentNumberUtils {

        public static void processDocumentNumber(String documentNumber) {
            // 1. Проверяем формат номера документа
            if (!isValidDocumentNumber(documentNumber)) {
                System.out.println("Некорректный формат номера документа.");
                return;
            }

            // 2. Выводим первые два блока по 4 цифры
            String[] blocks = documentNumber.split("-");
            System.out.println(blocks[0] + "-" + blocks[1]);

            // 3. Выводим буквы в формате ууу/ууу/у/у
            String letters = documentNumber.replaceAll("[^A-Za-z]", "");
            String formattedLetters = String.format("%s/%s/%s/%s", letters.substring(0, 3), letters.substring(3, 6),
                    letters.charAt(6), letters.charAt(7));
            System.out.println(formattedLetters.toLowerCase());

            // 4. Выводим буквы в формате "Letters:yyy/yyy/y/y*
            StringBuilder sb = new StringBuilder("Letters:");
            sb.append(letters.substring(0, 3)).append("/").append(letters.substring(3, 6)).append("/")
                    .append(letters.charAt(6)).append("/");
            for (int i = 7; i < letters.length(); i++) {
                sb.append("*");
            }
            System.out.println(sb.toString().toUpperCase());

            // 5. Проверяем содержит ли номер документа последовательность абс и выводим сообщение
            String upperCaseDocNumber = documentNumber.toUpperCase();
            if (upperCaseDocNumber.contains("ABC") || upperCaseDocNumber.contains("АБС")) {
                System.out.println("Номер документа содержит последовательность абс.");
            } else {
                System.out.println("Номер документа не содержит последовательность абс.");
            }

            // 6. Проверяем начинается ли номер документа с последовательности 555
            if (documentNumber.startsWith("555")) {
                System.out.println("Номер документа начинается с последовательности 555.");
            } else {
                System.out.println("Номер документа не начинается с последовательности 555.");
            }

            // 7. Проверяем заканчивается ли последовательность 1a26
            if (documentNumber.endsWith("1a26")) {
                System.out.println("Номер документа заканчивается последовательностью 1a26.");
            } else {
                System.out.println("Номер документа не заканчивается последовательностью 1a26.");
            }
        }

        private static boolean isValidDocumentNumber(String documentNumber) {
            return documentNumber.matches("\\d{4}-[A-Za-z]{3}-\\d{4}-[A-Za-z]{3}-[A-Za-z]\\d[A-Za-z]\\d");
        }
    }

}
