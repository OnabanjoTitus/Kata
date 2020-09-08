package com.creditCardVerification;

public class CreditCardFactory {
  //     static CreditCardFactory card;

   private CreditCardFactory(){}


//   public static CreditCardFactory generateCardFactory(){
//       if (card == null){
//           card = new CreditCardFactory();
//           return card;
//       }
//       else{
//           return card;
//       }

 //  }

    public static CreditCard createCreditCard(String creditCardNumber) {
   //    if (CreditCardValidator.isCreditCardValid(new AmericanExpress(creditCardNumber))){;
        if (creditCardNumber.startsWith("4")){
            return new VisaCard(creditCardNumber);
        }

        if (creditCardNumber.startsWith("5")){
            return new Mastercard(creditCardNumber);
        }

        if (creditCardNumber.startsWith("37")){
            return new AmericanExpress(creditCardNumber);
        }

        if (creditCardNumber.startsWith("6")){
            return new DiscoverCard(creditCardNumber);
        }

       else {
            return new CreditCard(creditCardNumber+"     ") {
                @Override
                public String getCardType() {
                    return "Invalid Card";
                }
                @Override
                public int getSize(){
                    return creditCardNumber.length();
                }
            };
        }
    }
}
