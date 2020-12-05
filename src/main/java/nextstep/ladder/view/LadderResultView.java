package nextstep.ladder.view;

import nextstep.ladder.entity.ladder.*;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResultView extends AbstractView {

    private static final String BACKWARD_LINK_POINT = "-----|";
    private static final String BACKWARD_EMPTY_LINK_POINT = "     |";
    private static final String SPACE = " ";

    public static void display(Ladder ladder, Users users, GameResults gameResults) {
        // 유저 이름 출력
        stringBuilder.append(userNamesView(users.getUserNames()));
        printAndClear();

        // 사다리 출력
        displayLadder(ladder);

        // 게임 결과 출력
        stringBuilder.append(gameResultsView(gameResults.getGameResultValues()));
        printAndClear();
    }

    private static String userNamesView(List<String> userNames) {
        return userNames.stream()
                .map(LadderResultView::userNameView)
                .collect(Collectors.joining(SPACE));
    }

    private static String userNameView(String userName) {
        return String.format("%5s", userName);
    }

    private static void displayLadder(Ladder ladder) {
        floorView(ladder.getFirstFloor());
    }

    private static void floorView(Floor floor) {

        pointChainingView(floor.getStartPoint());

        printAndClear();

        if (floor.hasNext()) {
            floorView(floor.getNextFloor());
        }
    }

    private static void pointChainingView(Point point) {
        String pointWithLinkView = point.hasBackwardLink() ?
                BACKWARD_LINK_POINT
                : BACKWARD_EMPTY_LINK_POINT;
        stringBuilder.append(pointWithLinkView);

        if (point.hasNext()) {
            pointChainingView(point.getNext());
        }
    }

    private static String gameResultsView(List<String> gameResults) {
        return gameResults.stream()
                .map(LadderResultView::gameResultView)
                .collect(Collectors.joining(SPACE));
    }

    private static String gameResultView(String gameResult) {
        return String.format("%5s", gameResult);
    }

}