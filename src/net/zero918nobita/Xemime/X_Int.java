package net.zero918nobita.Xemime;

/**
 * 整数オブジェクト
 * @author Kodai Matsumoto
 */

class X_Int extends X_Numeric {
    private int value;

    X_Int(int num) {
        super();
        value = num;
    }

    public String toString() {
        return String.valueOf(value);
    }

    @Override
    Integer getValue() {
        return value;
    }

    @Override
    X_Numeric add(X_Object obj) throws Exception {
        X_Numeric result;
        if (obj.getClass() == X_Int.class) {
            X_Int i = (X_Int)obj;
            result = new X_Int(value + i.getValue());
            return result;
        } else if (obj.getClass() == X_Double.class) {
            X_Double dbl = (X_Double)obj;
            result = new X_Double(value + dbl.getValue());
            return result;
        } else {
            throw new Exception("数値以外のものを足そうとしました");
        }
    }

    @Override
    X_Numeric sub(X_Object obj) throws Exception {
        X_Numeric result;
        if (obj.getClass() == X_Int.class) {
            X_Int i = (X_Int)obj;
            result = new X_Int(value - i.getValue());
            return result;
        } else if (obj.getClass() == X_Double.class) {
            X_Double dbl = (X_Double)obj;
            result = new X_Double(value - dbl.getValue());
            return result;
        } else {
            throw new Exception("数値以外のものを引こうとしました");
        }
    }

    @Override
    X_Numeric multiply(X_Object obj) throws Exception {
        X_Numeric result;
        if (obj.getClass() == X_Int.class) {
            X_Int i = (X_Int)obj;
            result = new X_Int(value * i.getValue());
            return result;
        } else if (obj.getClass() == X_Double.class) {
            X_Double dbl = (X_Double)obj;
            result = new X_Double(value * dbl.getValue());
            return result;
        } else {
            throw new Exception("数値以外のものを掛けようとしました");
        }
    }

    @Override
    X_Numeric divide(X_Object obj) throws Exception {
        X_Numeric result;
        if (obj.getClass() == X_Int.class) {
            X_Int i = (X_Int)obj;
            result = new X_Int(value / i.getValue());
            return result;
        } else if (obj.getClass() == X_Double.class) {
            X_Double dbl = (X_Double)obj;
            result = new X_Double(value / dbl.getValue());
            return result;
        } else {
            throw new Exception("数値以外のものを割ろうとしました");
        }
    }
}
