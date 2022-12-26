import java.util.Set;
import java.util.HashSet;

class SetsStuff {

    private static Set<Integer> union(Set<Integer> a, Set<Integer> b) {
        Set<Integer> unionSet = new HashSet<>();
        for (int n : a) {
            unionSet.add(n);
        }
        for (int n : b) {
            unionSet.add(n);
        }
        return unionSet;
    }

    private static Set<Integer> intersection(Set<Integer> a, Set<Integer> b) {
        Set<Integer> intersectionSet = new HashSet<>();
        for (int n : a) {
            if (b.contains(n)) {
                intersectionSet.add(n);
            }
        }
        return intersectionSet;
    }

    private static int cardinality(Set<Integer> s) {
        return s.size();
    }

    public static double intersectionUnionRatio(Set<Integer> a, Set<Integer> b) {
        return (cardinality(intersection(a, b)) / (double) cardinality(union(a, b)));
    }

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        Set<Integer> b = new HashSet<>();
        b.add(2);
        b.add(3);
        b.add(5);
        b.add(9);
        b.add(22);
        System.out.println(intersectionUnionRatio(a, b));
    }
}