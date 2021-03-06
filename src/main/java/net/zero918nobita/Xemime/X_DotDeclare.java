package net.zero918nobita.Xemime;

/**
 * オブジェクトのメンバの宣言
 * @author Kodai Matsumoto
 */

class X_DotDeclare extends X_Code {
    private X_Code code1;
    private X_Symbol symbol;
    private X_Code code2;

    X_DotDeclare(X_Code c, X_Symbol sym, X_Code c2) {
        code1 = c;
        symbol = sym;
        code2 = c2;
    }

    @Override
    X_Code run() throws Exception {
        X_Code c1 = code1.run();
        X_Code c2 = code2.run();
        if (c1 instanceof X_Handler) {
            ((X_Handler) c1).setMember(symbol, c2);
        } else {
            throw new Exception("メンバを設定することができません");
        }
        return c2;
    }
}
