// Naming the buildings
// An architect has N buildings on sale. Her wife asks the architect to name the buildings but with a few conditions.
// 1. If H and W are names of architect and wife resp and B1, B2,...,Bn be the names of N buildings, then
// a. B = Concat(B1, B2, B3,,..., Bn)
// b. B must be a substring of any permutation of Concat(H, W)
// c. i.e., B must be suvbstring of any permutation after concatenation of husband and wife's names together.
// Given H, W, N and all buildings names. Find whether the husband has named the buildings correctly.
// Output "YES" or "NO".
// Note: All names will be single words only and lowercase.
// Example 1.
// Input:
// alice bob
// 2
// lic bob
// Output:
// YES
// Explanation: 
// B = licbob
// Concat(H,W) = alicebob
// One of the permutation after concatenation of husband wife names is alicebobe
// Hence B is substring of above permutation. So ans is YES.
// Example 2.
// Input:
// amile emile
// 1
// mike
// Output:
// NO
// Explanation: 
// B = mike
// Concat(H,W) = amileemile
// None of the permutation will be able to have "mike" as substring. 

import java.util.*;

class BuildingNaming {

    public static void architect(String H, String W, int n, String[] arr) {
        String str = "";
        for (String s : arr) {
            str += s;
        }
        String target = H + W;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            String s = target.charAt(i) + "";
            int count = map.getOrDefault(s, 0);

            if (count > 0) {
                map.put(s, count + 1);
            } else {
                map.put(s, 1);
            }
        }

        // for(String key : map.keySet()){
        //     System.out.println(key + ":" + map.get(key));
        // }

        for (int i = 0; i < str.length(); i++) {
            String s = str.charAt(i) + "";
            int count = map.getOrDefault(s, 0);

            if (count > 0) {
                map.put(s, count - 1);
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String H = sc.next();
        String W = sc.next();
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        // System.out.println(Arrays.toString(arr));
        architect(H, W, n, arr);
        sc.close();
    }
}
