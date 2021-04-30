package ctpi;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

class Project {
    Character ch;
    int blockedBy;
    List<Project> children;

    @Override
    public String toString() {
        return new StringJoiner(", ", Project.class.getSimpleName() + "[", "]")
            .add("ch=" + ch)
            .add("blockedBy=" + blockedBy)
            .add("children=" + children)
            .toString();
    }
}

public class ProjectBuildOrder {

    public List<Character> getBuildOrder(char[] chars, char[][] dependencies) {
        List<Character> result = new LinkedList<>();
        Map<Character, Project> mapping = new HashMap<>();
        Set<Character> roots = new HashSet<>();
        Set<Character> processed = new HashSet<>();
        for (Character ch : chars) {
            Project pr = new Project();
            pr.ch = ch;
            pr.children = new LinkedList<>();
            mapping.put(ch, pr);
            roots.add(ch);
        }
        for (char[] dependency : dependencies) {
//            System.out.println("1");
            Project blocked = mapping.get(dependency[1]);
            mapping.get(dependency[0]).children.add(blocked);
            blocked.blockedBy++;
            roots.remove(dependency[1]);
        }
//        System.out.println(mapping);
        while (!roots.isEmpty()) {
            Character nextChar = roots.iterator().next();
            processed.add(nextChar);
            final Project project = mapping.get(nextChar);
            roots.remove(project.ch);
            project.children.stream().forEach(p -> {
                p.blockedBy--;
                if (p.blockedBy == 0 && !processed.contains(p.ch)) {
                    roots.add(p.ch);
                }
            });
            result.add(nextChar);
        }
        return result;
    }

    @Test
    public void test123() {
//        System.out.println(getBuildOrder(new char[]{'a', 'b', 'c', 'd', 'e', 'f'}, new char[][]{{'a', 'd'}, {'f', 'b'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}}));
//        System.out.println();
//        System.out.println(getBuildOrder(new char[]{'a', 'b', 'c', 'd', 'e', 'f'}, new char[][]{{'a', 'd'}, {'f', 'b'}, {'f', 'd'}, {'c', 'e'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}}));
//        System.out.println();
        System.out.println(getBuildOrder(new char[]{'a', 'b', 'c', 'd', 'e', 'f'}, new char[][]{{'a', 'd'}, {'f', 'b'}, {'f', 'd'}, {'c', 'e'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}, {'a', 'f'}}));

    }
}
