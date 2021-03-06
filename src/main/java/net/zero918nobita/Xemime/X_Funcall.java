package net.zero918nobita.Xemime;

import java.util.ArrayList;

class X_Funcall extends X_Code {
    private X_Symbol symbol;
    private ArrayList<X_Code> list;

    X_Funcall(X_Symbol sym, ArrayList<X_Code> l) {
        symbol = sym;
        list = l;
    }

    @Override
    X_Code run() throws Exception {
        X_Code c = Main.getValueOfSymbol(symbol);
        if (c == null) throw new Exception("関数 `" + symbol.getName() + "` は存在しません");
        if (!(c instanceof X_Function)) throw new Exception("変数 `" + symbol.getName() + "` には関数オブジェクトが代入されていません");
        X_Function func = (X_Function)c;
        ArrayList<X_Code> params = new ArrayList<>();
        for (X_Code o : list) params.add(o.run());
        params.add(0, func);
        return func.call(params);
    }
}
