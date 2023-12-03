import java.io.*;

class LowercaseDecorator extends FilterReader {

    protected LowercaseDecorator(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        if (c != -1) {
            // Convert uppercase to lowercase
            return Character.toLowerCase((char) c);
        }
        return -1;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int result = super.read(cbuf, off, len);
        if (result != -1) {
            for (int i = off; i < off + result; i++) {
                // Convert uppercase to lowercase
                cbuf[i] = Character.toLowerCase(cbuf[i]);
            }
        }
        return result;
    }
}

public class IODecoratorExample {

    public static void main(String[] args) {
        try {
            // Creating a FileReader for input
            FileReader fileReader = new FileReader("input.txt");

            // Creating a LowercaseDecorator to convert uppercase to lowercase
            LowercaseDecorator lowercaseDecorator = new LowercaseDecorator(fileReader);

            // Creating a BufferedReader for reading from the decorated stream
            BufferedReader bufferedReader = new BufferedReader(lowercaseDecorator);

            // Reading and printing the content
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Closing resources
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
