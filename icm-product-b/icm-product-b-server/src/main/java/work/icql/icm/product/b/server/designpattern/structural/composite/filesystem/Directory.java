package work.icql.icm.product.b.server.designpattern.structural.composite.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemNode {

    private final List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode node : subNodes) {
            numOfFiles += node.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFiles() {
        long sizeOfFiles = 0;
        for (FileSystemNode node : subNodes) {
            sizeOfFiles += node.countSizeOfFiles();
        }
        return sizeOfFiles;
    }

    public void addSubNode(FileSystemNode node) {
        subNodes.add(node);
    }

    public void removeSubNode(FileSystemNode node) {
        subNodes.remove(node);
    }
}
