public class HanoiSolver {
    public static void main(String[] args) {
        System.out.println("It took " + solve(7, 1, 2, 3) + " moves");
    }

    public static int solve(int num, int source, int spare, int target) {
        if (num == 0)
            return 0;
        else {
            solve(num - 1, source, target, spare);
            System.out.println("Move disk from " + source + " to " + target);
            return 2 * solve(num - 1, spare, source, target) + 1;
        }

    }
}
