package gui;

import java.util.Comparator;
import java.util.Objects;

public class Location implements Comparable<Location> {
    public int col;
    public int row;

    public Location(int row, int col) {
        this.col = col;
        this.row = row;
    }

    // your turn: make them comparable!

    @Override
    public String toString() {
        return String.format("(%03d,%03d)", row, col);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return col == location.col && row == location.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(col, row);
    }

    @Override
    public int compareTo(Location o) {
        return (this.row == o.row && this.col == o.col) ? 0 : 1;
    }
}
