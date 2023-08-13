package Question2;
//b
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class WhitelistedRandomPort {
    private int k;
    private Set<Integer> blacklist;
    private int whitelistedPorts;
    private Random random;

    public WhitelistedRandomPort(int k, int[] blacklisted_ports) {
        this.k = k;
        this.blacklist = new HashSet<>();
        for (int port : blacklisted_ports) {
            blacklist.add(port);
        }
        this.whitelistedPorts = k - blacklist.size();
        this.random = new Random();
    }

    public int get() {
        int rand = random.nextInt(whitelistedPorts);
        while (blacklist.contains(rand)) {
            rand = (rand + 1) % k;
        }
        return rand;
    }

    public static void main(String[] args) {
        int[] blacklisted_ports = { 2, 3, 5 };
        WhitelistedRandomPort portPicker = new WhitelistedRandomPort(7, blacklisted_ports);
        System.out.println(portPicker.get()); // Output: 0
        System.out.println(portPicker.get()); // Output: 4
        System.out.println(portPicker.get()); // Output: 6
        System.out.println(portPicker.get()); // Output: 1
        System.out.println(portPicker.get()); // Output: 4
    }
}
