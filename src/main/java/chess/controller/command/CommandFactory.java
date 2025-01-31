package chess.controller.command;

import chess.dao.ChessGameDaoImpl;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public final class CommandFactory {

    private static final Map<CommandType, Function<List<String>, Command>> commands = new EnumMap<>(CommandType.class);

    private CommandFactory() {
    }

    static {
        commands.put(CommandType.START, ignored -> new StartCommand(new ChessGameDaoImpl()));
        commands.put(CommandType.LOAD, parameters -> new LoadCommand(new ChessGameDaoImpl(), parameters));
        commands.put(CommandType.MOVE, parameters -> new MoveCommand(new ChessGameDaoImpl(), parameters));
        commands.put(CommandType.STATUS, ignored -> new StatusCommand());
        commands.put(CommandType.END, ignored -> new EndCommand());
    }

    public static Command from(List<String> command) {
        Request request = Request.from(command);
        CommandType commandType = CommandType.from(request.getCommand());
        return commands.get(commandType).apply(request.getParameters());
    }

    private enum CommandType {
        START,
        END,
        MOVE,
        LOAD,
        STATUS;

        public static CommandType from(final String input) {
            return Arrays.stream(CommandType.values())
                    .filter(commandType -> commandType.name().equals(input))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 명령어입니다."));
        }
    }
}
