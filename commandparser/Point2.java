import java.io.File;
import java.io.FileNotFoundException;

/**
 * This is the main executable file for project 2.

/**
 * The class containing the main method, the entry point of the application.
 *
 * @author {pacog94
 *          silverg}
 * @version {2/18/2016}
 */
public class Point2
{

    /**
     * The entry point of the application.
     *
     * @param args
     *            The name of the command file passed in as a command line
     *            argument.
     * @throws FileNotFoundException
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) throws FileNotFoundException
    {

        File file = new File(args[0].trim());
        CommandProcessor cp = new CommandProcessor(file);
    }
}

