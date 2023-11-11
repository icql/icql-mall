package work.icql.icm.product.b.server.doc.code.designpattern.structural.composite.filesystem;

public abstract class FileSystemNode {

    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public abstract int countNumOfFiles();

    public abstract long countSizeOfFiles();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FileSystemNode)) {
            return false;
        }
        FileSystemNode that = (FileSystemNode) o;
        return path.equals(that.path);
    }

    @Override
    public int hashCode() {
        return path.hashCode();
    }
}
