//package work.icql.icm.product.b.server.doc.code.designpattern.structural.composite;
//
//import work.icql.java.designpattern.structural.composite.filesystem.Directory;
//import work.icql.java.designpattern.structural.composite.filesystem.File;
//
//public class CompositeFileSystemClient {
//
//    public static void main(String[] args) {
//        Directory rootDir = new Directory("/");
//        Directory dir1 = new Directory("/dir1");
//        rootDir.addSubNode(dir1);
//        dir1.addSubNode(new File("/dir1/234.txt"));
//        rootDir.addSubNode(new File("/123.txt"));
//
//        System.out.println(rootDir.countNumOfFiles());
//
//    }
//}
