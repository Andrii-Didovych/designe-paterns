package decorator_pattern;

public class DecoratorLesson {
    public static void main(String[] args) {
        FileStream stream = new FileBufferedReader(new FileStreamReader());
        stream.read();
    }
}

interface FileStream {
    void read();
}
class FileStreamReader implements FileStream{
    @Override
    public void read() {
        System.out.println("read");
    }
}


class FileBufferedReader implements FileStream {

    FileStreamReader streamReader;

    public FileBufferedReader(FileStreamReader streamReader) {
        this.streamReader = streamReader;
    }

    @Override
    public void read() {
        streamReader.read();
        System.out.println("decorator");
    }
}
