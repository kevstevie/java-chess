package chess.domain.piece.normal;

import chess.domain.piece.property.Color;
import chess.domain.position.File;
import chess.domain.position.Position;
import chess.domain.position.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class KingTest {

    public static final Position B5 = new Position(File.B, Rank.FIVE);
    public static final Position B6 = new Position(File.B, Rank.SIX);
    public static final Position B7 = new Position(File.B, Rank.SEVEN);
    public static final Position C6 = new Position(File.C, Rank.SIX);

    @DisplayName("Rank와 File이 1씩 차이날 때 경로에 타겟이 포함된다")
    @Test
    void computePath_rightUp() {
        var king = new King(Color.BLACK);

        var source = B5;
        var target = C6;

        assertThat(king.computePath(source, target)).containsExactlyInAnyOrder(C6);
    }

    @DisplayName("Rank가 같을 때 경로에 타겟이 포함된다")
    @Test
    void computePath_up() {
        var king = new King(Color.BLACK);

        var source = B5;
        var target = B6;

        assertThat(king.computePath(source, target)).containsExactlyInAnyOrder(B6);
    }

    @DisplayName("인접한 위치가 아니면 예외가 발생한다.")
    @Test
    void computePath_illegalTaget_exception() {
        var king = new King(Color.BLACK);

        var source = B5;
        var target = B7;

        assertThatThrownBy(() -> king.computePath(source, target))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
