import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public abstract class InputTestBase {
    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @After
    public void after(){
        setUpStream();
    }
    protected void setUpStream() {
        System.setOut(new PrintStream(outContent));
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
