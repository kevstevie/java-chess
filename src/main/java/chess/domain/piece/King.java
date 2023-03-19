package chess.domain.piece;

import chess.domain.board.Position;

import java.util.Set;

public final class King extends Normal {

    public King(final Color color) {
        super(color);
    }

    @Override
    public Set<Position> computePath(final Position source, final Position target) {
        if (source.isNear(target)) {

            return Set.of(target);
        }

        throw new IllegalArgumentException("갈 수 없는 위치입니다.");
    }

    @Override
    public Kind getKind() {
        return Kind.KING;
    }
}
