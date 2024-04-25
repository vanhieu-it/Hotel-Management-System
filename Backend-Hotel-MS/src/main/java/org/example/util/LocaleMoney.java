package org.example.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class LocaleMoney {

  public static String formatCurrency(BigDecimal price) {
    // định dạng tiền tệ của khu vực mặc định của máy ảo JVM
    // khu vực mặc định này là nước Mỹ
    // nên đơn vị của tiền tệ sẽ là $
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    // tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của Việt Nam
    // đơn vị tiền tệ của Việt Nam là đồng
    Locale localeVN = new Locale("vi", "VN");
    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
    return currencyVN.format(price);
  }

  public static String formatCurrency(Long currency) {
    String currencyString = String.valueOf(currency);

    if (currencyString.length() < 4) {
      return currencyString;
    } else {
      int count = 1;
      for (int i = currencyString.length() - 1; i >= 0; i--) {
        if (count == 3 && i != 0) {
          StringBuilder sb = new StringBuilder(currencyString);
          sb.insert(i, ".");
          currencyString = sb.toString();
          count = 1;
          i--;
        }
        count++;
      }
    }
    return currencyString;
  }

//  public static BigDecimal formatCurrencyToBigDecimal(String price) {
//   String[] array=price.substring(0,price.length()-1).split(".");
//    List<String> a= Arrays.asList(array);
//    String b=new String("");
//    a.stream().forEach(s -> b+=s);
//  }

}
