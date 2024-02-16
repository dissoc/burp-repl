/* Copyright © 2024 Justin Bishop <mail@dissoc.me> */

package burp;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.logging.Logging;
import clojure.java.api.Clojure;
import clojure.lang.IFn;
import java.io.PrintWriter;


public class BurpExtender implements BurpExtension
{
    @Override
    public void initialize(MontoyaApi api)
    {   Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("burp-repl.core"));
        IFn register = Clojure.var("burp-repl.core", "init");
        register.invoke(api);
    }
}
