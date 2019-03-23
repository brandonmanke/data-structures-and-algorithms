// really basic impl tests for debugging
class HeapMain {
    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println("Size:" + map.size());
        map.set("hi", 2);
        System.out.println("Size:" + map.size());
        System.out.println(map);
        System.out.println(map.get("hi"));
        System.out.println(map.has("hi"));
        System.out.println(map.has("hiiii"));
        map.set("hii", 55);
        map.set("foobar", 234);
        map.set("foo", 34);
        map.set("foobar", 523);
        map.set("bye", -3);
        System.out.println("Size:" + map.size());
        System.out.println(map);
        System.out.println(map.has("foo"));
        System.out.println(map.get("foo"));
        System.out.println("Remove foo: " + map.remove("foo"));
        System.out.println("Size:" + map.size());
        System.out.println(map);
        System.out.println("Remove hi: " + map.remove("hi"));
        System.out.println("Size:" + map.size());
        System.out.println(map);

        map.set("as", 1);
        map.set("asd", 2);
        map.set("asdf", 3);
        map.set("asdfg", 4);
        map.set("asdfgh", 5);
        System.out.println("\n\n" +map);
        System.out.println(map.get("asd"));
        map.set("ds", 6);
        map.set("dsd", 7);
        map.set("dsdf", 8);
        map.set("dsdfg", 9);
        map.set("dsdfgh", 10);
        map.set("foo", 69);
        System.out.println("\n\n" +map);

        System.out.println(map.remove("asd"));
        System.out.println(map + "\n\n");

        map.remove("ds");
        map.remove("dsd");
        map.remove("dsdf");
        map.remove("bye");
        map.remove("asdf");
        System.out.println("\n\n" +map);
    }
}