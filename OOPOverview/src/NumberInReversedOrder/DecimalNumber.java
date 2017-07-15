package NumberInReversedOrder;

public class DecimalNumber {

        private String number;

        public DecimalNumber(String number) {
            this.number = number;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getReversedNumber (String number){

            String reversedNumber = null;

            StringBuilder num = new StringBuilder(number.length());

            for (int i = number.length()-1; i >=0; i--) {
                num.append(number.charAt(i));
            }

            reversedNumber = num.toString();

            return reversedNumber;
        }

}
