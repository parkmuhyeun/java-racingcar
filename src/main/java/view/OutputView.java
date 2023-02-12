package view;

import dto.CarDto;
import dto.WinnerCarDto;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String ERROR_FORMAT = "[Error] ";
    private static final String POSITION_STATE = "-";
    private static final String ROUND_FORMAT = "%s : %s";
    private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.";
    private static final String LINE_FEED = "";
    private static final String RACE_START_MESSAGE = "실행 결과";
    private static final String DELIMITER = ", ";

    public static void printRoundStartMessage() {
        print(LINE_FEED);
        print(RACE_START_MESSAGE);
    }

    public static void printRound(List<CarDto> carsDto) {
        carsDto.forEach(dto -> print(String.format(ROUND_FORMAT, dto.getName(),
                getCarPositionState(dto.getPosition()))));
        print(LINE_FEED);
    }

    private static String getCarPositionState(int position) {
        return POSITION_STATE.repeat(Math.max(0, position));
    }

    public static void printWinner(List<WinnerCarDto> winnersDto) {
        String winners = winnersDto.stream()
                .map(WinnerCarDto::getName)
                .collect(Collectors.joining(DELIMITER));

        print(String.format(WINNER_FORMAT, winners));
    }

    private static void print(String message) {
        System.out.println(message);
    }

    public static void printExceptionMessage(String message) {
        print(ERROR_FORMAT + message);
    }
}
