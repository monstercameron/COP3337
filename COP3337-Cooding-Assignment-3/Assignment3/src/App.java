public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Recursive stuff!");
        int[] sequenceGroup1 = new int[] { 1, 1, 2, -3, 50, -460, 4519, -44001, 428941,
                -4180844, 40751117, -397204218, -423386306,
                918100829, -1545525547, 1110963229, 1243701550,
                -239385059, -1594015946, -337862588 };
        int bruteForceAttempts = 0;
        boolean found = false;
        int[] sequence;

        for (int x = -10; x <= 10; x++) {
            for (int y = -10; y <= 10; y++) {
                for (int z = -10; z <= 10; z++) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(
                            "Brute force attemtps #" + ++bruteForceAttempts + " | X,Y,Z == " + x + ", " + y + ", " + z);
                    sequence = generateSequence(20, x, y, z);
                    found = sequenceMatch(sequenceGroup1, sequence);
                    if (found) {
                        System.out.println("Combination found! X,Y,Z == " + x + ", " + y + ", " + z);
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (found) {
                break;
            }
        }
    }

    /*
     * Group 1 Sequence
     * ---------------------------------------------
     * 1, 1, 2, -3, 50, -460, 4519, -44001, 428941,
     * -4180844, 40751117, -397204218, -423386306,
     * 918100829, -1545525547, 1110963229, 1243701550,
     * -239385059, -1594015946, -337862588
     * 
     * You must code this using brute force. Hence you must loop through all
     * possible values of x,y,z to find the correct x, y and z values that generate
     * your sequence.
     * 
     * Linear Algebra.
     * If you do not know Linear Algebra you must crack the sequence my brute
     * force....
     * 
     * Hint: Use the idea of Fibonacci recursive code in the notes with one more lag
     * call.
     * 
     * Multiplier: x, y, z
     * --------------------------------------
     * X -> is the multiplier of the recursive call of the (n-1) term
     * Y -> is the multiplier of the recursive call of the (n-2) term
     * Z -> is the multiplier of the recursive call of the (n-3) term
     * 
     * In addition, you will output the recursive call multipliers x, y, z values
     * under your sequence output.
     * Note x,y,z are integers that can range in values from : -10 to 10
     */
    public static int recursive(int n, int x, int y, int z) {
        if (n < 3) {
            return 1;
        } else if (n == 3) {
            return recursive(n - 1, x, y, z) + 1;
        } else {
            return x * recursive(n - 1, x, y, z) + y * recursive(n - 2, x, y, z) + z * recursive(n - 3, x, y, z);
        }
    }

    public static int[] generateSequence(int length, int x, int y, int z) {
        System.out.println("Generating Sequneces...");
        int[] sequence = new int[length];
        for (int i = 0; i < length; i++) {
            int result = recursive(i + 1, x, y, z);
            sequence[i] = result;
            if (sequenceGroup1[i] != result)
                break;
        }
        return sequence;
    }

    public static boolean sequenceMatch(int[] a, int[] b) {
        boolean result = true;
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%-20s%s%n", "A --> " + a[i], "\t\tB --> " + b[i]);
            if (a[i] != b[i]) {
                System.out.println("Sequences don't match, match count: " + i);
                result = false;
                break;
            }
        }
        return result;
    }
}
