import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public abstract class InputTestBase {
    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    protected final InputStream backupInContent = System.in;
    protected final PrintStream originalOut = System.out;
    protected void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }
    protected void restoreOutputStream() {
        System.setOut(originalOut);
    }

    protected String obterUltimaLinhaImpressaNoConsole(){
        String[] lines = outContent.toString().split(System.lineSeparator());
        return lines[lines.length-1];
    }

    protected void setarSystemIn(String input){
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
