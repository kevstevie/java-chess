package chess.domain.position;

import java.util.Arrays;

public enum Rank {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8);

    private final int value;

    Rank(final int value) {
        this.value = value;
    }

    public static Rank from(final int value) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.value == value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 위치입니다"));
    }

    public Rank moveTo(final int distance) {
        return Rank.from(this.value - distance);
    }

    public int sub(final Rank rank) {
        return this.value - rank.value;
    }

    public boolean NotEquals(final int rankExpected) {
        return value != rankExpected;
    }

    public int getValue() {
        return value;
    }
}
