package main;

import org.nlogo.api.*;
import org.nlogo.core.Syntax;
import org.nlogo.core.SyntaxJ;

public class HelloJavaExtension extends DefaultClassManager {
    public void load(PrimitiveManager manager) {
        manager.addPrimitive("hello", new HelloString());
        manager.addPrimitive("wiggle", new Wiggle());
    }

    public static class HelloString implements Reporter {
        @Override
        public Syntax getSyntax() {
            return SyntaxJ.reporterSyntax(new int[] {Syntax.StringType()}, Syntax.StringType());
        }

        @Override
        public Object report(Argument[] args, Context context) throws ExtensionException {
            String name = args[0].getString();
            return "hello, " + name + "y Mc"+name+"face";
        }
    }
    public static class Wiggle implements Command {
        @Override
        public Syntax getSyntax() {
            return SyntaxJ.commandSyntax(new int[] {});
        }

        @Override
        public void perform(Argument[] args, Context context) throws ExtensionException {
            Turtle anAgent;
            anAgent = (Turtle)context.getAgent();
            anAgent.heading(anAgent.heading() + Math.random() * 25 - Math.random() * 25);
        }

    }
}
