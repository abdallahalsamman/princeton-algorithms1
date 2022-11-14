import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int TOP = 0;
    private final int size;
    private final int bottom;
    private final boolean[][] opened;
    private int openedSites;
    private final WeightedQuickUnionUF qf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        size = n;
        qf = new WeightedQuickUnionUF(n*n+2);
        opened = new boolean[size][size];
        bottom = size * size + 1;
        openedSites = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (size * row + col <= 0) {
            throw new IllegalArgumentException("Site indices can't be negative.");
        }

        opened[row-1][col-1] = true;
        openedSites++;

        if (row == 1) {
            qf.union(getQuickFindIndex(row, col), TOP);
        }

        if (row == size) {
            qf.union(getQuickFindIndex(row, col), bottom);
        }

        if (row > 1 && isOpen(row - 1, col)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row - 1, col));
        }

        if (row < size && isOpen(row + 1, col)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row + 1, col));
        }

        if (col > 1 && isOpen(row, col - 1)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col - 1));
        }

        if (col < size && isOpen(row, col + 1)) {
            qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col + 1));
        }
    }

    private int getQuickFindIndex(int row, int col) {
        return (row - 1) * size + col;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (this.size * row + col <= 0) {
            throw new IllegalArgumentException("Site indices can't be negative.");
        }

        return opened[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (this.size * row + col <= 0) {
            throw new IllegalArgumentException("Site indices can't be negative.");
        }
        return qf.find(TOP) == qf.find(getQuickFindIndex(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openedSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return qf.find(TOP) == qf.find(bottom);
    }

    // test client (optional)
    public static void main(String[] args) {
    }
}

