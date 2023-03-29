package chess.domain.piece.normal;

import chess.domain.piece.property.Color;
import chess.domain.position.File;
import chess.domain.position.Position;
import chess.domain.position.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static chess.domain.piece.normal.QueenTest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class KnightTest {

    public static final Position B4 = new Position(File.B, Rank.FOUR);
    public static final Position E4 = new Position(File.E, Rank.FOUR);

    @DisplayName("나이트는 유효한 위치를 받으면 경로를 반환한다.")
    @Test
    void computePath_legal() {
        final var knight = new Knight(Color.BLACK);
        final var source = B4;
        final var target = D3;

        Set<Position> positions = knight.computePath(source, target);

        assertThat(positions).containsExactlyInAnyOrder(D3);
    }

    @DisplayName("나이트는 유효한 위치를 받으면 경로를 반환한다.")
    @Test
    void computePath_legal2() {
        final var knight = new Knight(Color.BLACK);
        final var source = C4;
        final var target = E3;

        Set<Position> positions = knight.computePath(source, target);

        assertThat(positions).containsExactlyInAnyOrder(E3);
    }

    @Test
    @DisplayName("잘못된 타겟이면 예외가 발생한다")
    void computePath_illegal_exception() {
        final var kngiht = new Knight(Color.BLACK);
        final var source = B4;
        final var target = E4;

        assertThatThrownBy(() -> kngiht.computePath(source, target))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
