package FastIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public byte nextByte() {
        return Byte.parseByte(next());
    }

    public short nextShort() {
        return Short.parseShort(next());
    }

    public double nextDouble(){
        return Double.parseDouble(next());
    }

    public float nextFloat(){
        return Float.parseFloat(next());
    }

    public BigInteger nextBigInteger(){
        return new BigInteger(next());
    }

    public BigDecimal nextBigDecimal(){
        return new BigDecimal(next());
    }

    public String skip(){
        return next();
    }

    public long nextLong(){
        return Long.parseLong(next());
    }

    public String nextLine() {
        try {
            return reader.readLine();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public boolean hasNext(){
        try {
            if (!reader.ready()) {
                if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                if (tokenizer != null && tokenizer.hasMoreTokens())
                    return true;
                return false;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
