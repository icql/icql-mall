package work.icql.icm.product.b.server.designpattern.behavioral.iterator;

public class IteratorClient {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("xzg");
        names.add("wang");
        names.add("zheng");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}