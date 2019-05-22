package StateCacherEvents;

import java.math.MathContext;

public class RaidenBigDecimal{
    public static java.math.BigDecimal valueOf(String value){ return new java.math.BigDecimal(value);}
    public static String divide(java.math.BigDecimal a, java.math.BigDecimal b){ return a.divide(b, MathContext.DECIMAL64).toPlainString();}
}
