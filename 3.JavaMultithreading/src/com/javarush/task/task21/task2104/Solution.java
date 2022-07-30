package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        if (o == null || getClass() != o.getClass()) return false;

        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        return last != null ? last.equals(solution.last) : solution.last == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Solution solution = (Solution) o;
//        return Objects.equals(first, solution.first) && Objects.equals(last, solution.last);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(first, last);
//    }
    //    @Override
//    public boolean equals(Object o) {
//        if (o == null) return false;
//        if (!(o instanceof Solution)) return false;
//        if (o.getClass() != this.getClass()) return false;
//        if (o == this) return true;
//        Solution n = (Solution) o;
////        if (n.first == null || n.last == null) return false;
////        return this.first.equals(n.first) && this.last.equals(n.last);
//
//        if (this.first != null ? !this.first.equals(n.first) : n.first != null) return false;
//        return this.last != null ? this.last.equals(n.last) : n.last == null;
//    }
//    @Override
//    public int hashCode() {
//        if (this.first == null || this.last == null) return 0;
//        return 31 * (this.first.hashCode() + this.last.hashCode());
//    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));

        Solution s1 = new Solution("Donald", "Duck");

        Solution s2 = new Solution("Donald", "Duck");
        Solution s3 = new Solution("Donald", "Dick");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));


    }
}
