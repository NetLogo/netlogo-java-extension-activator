import java.util.Arrays;
import java.util.Random;
import org.nlogo.core.LogoList;
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
            return SyntaxJ.reporterSyntax(
                new int[] {Syntax.StringType()}, // The types of arguments this reporter takes
                Syntax.StringType() // The type of thing this reporter returns
            );
        }

        @Override
        public Object report(Argument[] args, Context context) throws ExtensionException {
            // args[0] gives you the first argument, args[1] the second, and so forth
            String name = args[0].getString();
            return "hello, " + name + "y Mc"+name+"face";
        }
    }
    public static class Wiggle implements Command {
        @Override
        public Syntax getSyntax() {
            // The "-T--" limits the command to turtles. The default is "OTPL", which allows
            // the observer, turtles, patches, or links to run the command. Replacing
            // any one of the letters with "-" prevents that kind of agent from running
            // the command.
            return SyntaxJ.commandSyntax(new int[] {Syntax.NumberType()}, "-T--");
        }

        @Override
        public void perform(Argument[] args, Context context) throws ExtensionException {
            Random rng = context.getRNG(); // This lets us get random numbers
            Double angle = args[0].getDoubleValue(); // Gets the turtle that is running the command
            Turtle anAgent = (Turtle) context.getAgent(); // Get the first argument as a number
            anAgent.heading(anAgent.heading() + rng.nextDouble() * angle - rng.nextDouble() * angle);
        }

    }
}
