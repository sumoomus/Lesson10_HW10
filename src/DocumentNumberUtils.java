
    public class DocumentNumberUtils {

        public static void processDocumentNumber(String documentNumber) {

            if (!isValidDocumentNumber(documentNumber)) {
                System.out.println("Некорректный формат .");
                return;
            }


            String[] blocks = documentNumber.split("-");
            System.out.println(blocks[0] + "-" + blocks[1]);


            String letters = documentNumber.replaceAll("[^A-Za-z]", "");
            String formattedLetters = String.format("%s/%s/%s/%s", letters.substring(0, 3), letters.substring(3, 6),
                    letters.charAt(6), letters.charAt(7));
            System.out.println(formattedLetters.toLowerCase());


            StringBuilder sb = new StringBuilder("Letters:");
            sb.append(letters.substring(0, 3)).append("/").append(letters.substring(3, 6)).append("/")
                    .append(letters.charAt(6)).append("/");
            for (int i = 7; i < letters.length(); i++) {
                sb.append("*");
            }
            System.out.println(sb.toString().toUpperCase());

            String upperCaseDocNumber = documentNumber.toUpperCase();
            if (upperCaseDocNumber.contains("ABC") || upperCaseDocNumber.contains("АБС")) {
                System.out.println("абс.");
            } else {
                System.out.println("не абс.");
            }

            // 6. Проверяем начинается ли номер документа с последовательности 555
            if (documentNumber.startsWith("555")) {
                System.out.println(" 555.");
            } else {
                System.out.println("не 555.");
            }

            // 7. Проверяем заканчивается ли последовательность 1a26
            if (documentNumber.endsWith("1a26")) {
                System.out.println("заканчивается 1a26.");
            } else {
                System.out.println(" не заканчивается 1a26.");
            }
        }

        private static boolean isValidDocumentNumber(String documentNumber) {
            return documentNumber.matches("\\d{4}-[A-Za-z]{3}-\\d{4}-[A-Za-z]{3}-[A-Za-z]\\d[A-Za-z]\\d");
        }
    }


