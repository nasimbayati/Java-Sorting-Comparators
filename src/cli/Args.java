package src.cli;

import java.util.*;

public class Args {
    public static Integer tryParseInt(String s) { try { return Integer.valueOf(s); } catch (Exception e){ return null; } }

    /** Split "Name:Age:City" triples into Person-like tuples. */
    public static List<String[]> parseTriples(List<String> inputs) {
        ArrayList<String[]> out = new ArrayList<>();
        for (String t : inputs) {
            String[] parts = t.split(":", 3);
            if (parts.length == 3) out.add(parts);
            else System.out.println("Skipping invalid triple (expected Name:Age:City): " + t);
        }
        return out;
    }

    /** Small helper: join list with commas for display. */
    public static <T> String join(List<T> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i=0;i<list.size();i++){ if(i>0) sb.append(", "); sb.append(list.get(i)); }
        return sb.append("]").toString();
    }
}
