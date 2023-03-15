package chess.domain.board;

import chess.domain.piece.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Board {

    private final List<Squares> board = new ArrayList<>();

    public Board() {
        board.add(Squares.initPieces(Color.WHITE));
        board.add(Squares.initPawns(Color.WHITE));
        board.add(Squares.initEmpty());
        board.add(Squares.initEmpty());
        board.add(Squares.initEmpty());
        board.add(Squares.initEmpty());
        board.add(Squares.initPawns(Color.BLACK));
        board.add(Squares.initPieces(Color.BLACK));
    }

    public void move(Position source, Position target) {
        Square sourceSquare = getSquare(source);
        Square targetSquare = getSquare(target);
        Set<Position> movablePath = sourceSquare.computePath(source, target);

        Map<Position, Boolean> isEmptySquare = movablePath.stream()
                .collect(Collectors.toMap(
                        position -> position,
                        position -> getSquare(position).isEmpty()));

        if (sourceSquare.canMovePiece(isEmptySquare, source, target)) {
            targetSquare.changePiece(sourceSquare);
            sourceSquare.makeEmpty();
        }
    }

    private Square getSquare(final Position source) {
        int rank = source.getRank();
        int file = source.getFile();
        Squares squares = board.get(rank);
        return squares.get(file);
    }
}
