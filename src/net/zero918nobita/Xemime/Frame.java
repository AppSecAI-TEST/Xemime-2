package net.zero918nobita.Xemime;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;
import java.util.TreeMap;

/**
 * フレーム
 * @author Kodai Matsumoto
 */

class Frame {
    private Stack<HashMap<X_Symbol, Reference>> locals = new Stack<>();

    int size() {
        return locals.size();
    }

    void pushLocals(HashMap<X_Symbol, Reference> table) {
        locals.push(table);
    }

    void popLocals() {
        locals.pop();
    }

    boolean hasSymbol(X_Symbol sym) {
        if (locals.size() != 0) {
            HashMap table = locals.peek();
            if (table.containsKey(sym.getName())) return true;
        }
        return false;
    }

    Reference getReferenceOfSymbol(X_Symbol sym) {
        if (locals.size() != 0) {
            HashMap<X_Symbol, Reference> table = locals.peek();
            if (table.containsKey(sym)) return table.get(sym);
        }
        return null;
    }

    X_Object getValueOfSymbol(X_Symbol sym, TreeMap<X_Address, X_Object> entities) {
        if (locals.size() != 0) {
            HashMap<X_Symbol, Reference> table = locals.peek();
            if (table.containsKey(sym)) return table.get(sym).fetch(entities);
        }
        return null;
    }

    void setReference(X_Symbol sym, Reference ref) {
        if (locals.size() != 0) {
            HashMap<X_Symbol, Reference> table = locals.peek();
            if (table.containsKey(sym)) table.put(sym, ref);
        }
    }

    void setValue(X_Symbol sym, X_Object obj) {
        if (locals.size() != 0) {
            HashMap<X_Symbol, Reference> table = locals.peek();
            if (table.containsKey(sym)) {
                Reference ref = Main.register(obj);
                table.put(sym, ref);
            }
        }
    }

    void defReference(X_Symbol sym, Reference ref) {
        HashMap<X_Symbol, Reference> table = locals.peek();
        table.put(sym, ref);
    }

    void defValue(X_Symbol sym, X_Object obj) {
        HashMap<X_Symbol, Reference> table = locals.peek();
        Reference ref = Main.register(obj);
        table.put(sym, ref);
    }
}