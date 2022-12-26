import java.util.List;
import java.util.ArrayList;

//import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class SetsSumToN {

    public static List<Set<Integer>> _sumToN(int[] arr, int target) {
        List<List<Set<Integer>>> map = new ArrayList<>(target + 1);
        //Arrays.sort(arr);
        for (int i = 0; i < target + 1; i++) {
            map.add(null);
        }
        List<Set<Integer>> zeroSets = new ArrayList<>();
        zeroSets.add(new HashSet<>());
        map.add(0, zeroSets);

        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > i) continue;
                if (map.get(i - arr[j]) != null) {
                    List<Set<Integer>> sets = map.get(i - arr[j]);
                    List<Set<Integer>> newSets = new ArrayList<>();
                    for (Set<Integer> s : sets) {
                        if (!s.contains(arr[j])) {
                            Set<Integer> newSet = new HashSet<>(s);
                            newSet.add(arr[j]);
                            newSets.add(newSet);
                        }
                    }
                    map.add(i, newSets);
                }
            }
        }
        return map.get(target);
    }

    public static int sumToN(int[] arr, int target) {
        int[] map = new int[target + 1];
        map[0] = 0;
        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > i) continue;

                map[i] = map[i - arr[j]] + 1;
            }
        }
        return map[target];
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{ 1, 2, 3, 5, 7, 9, 10, 6, 11, 8 };
        int[] arr = new int[]{ 2, 4, 6, 10 };
        System.out.println("# subsets: " + sumToN(arr, 16));
        List<Set<Integer>> res = _sumToN(arr, 16);
        for (Set<Integer> s : res) {
            System.out.print("{ ");
            for (int n : s) {
                System.out.print(n + ",");
            }
            System.out.println(" }");
        }
    }
}