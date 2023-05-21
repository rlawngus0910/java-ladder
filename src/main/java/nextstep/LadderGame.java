package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.Participants;
import nextstep.domain.Record;
import nextstep.view.InputView;
import nextstep.view.PrintView;

import java.util.Random;

public class LadderGame {

    public static void main(String[] args) {
        String[] splitedParticipants = InputView.allParticipants();
        String[] gameResult = InputView.gameResult();
        int height = InputView.height();

        Participants participants = Participants.participate(splitedParticipants);
        Ladder ladder = Ladder.makeLadder(height, participants.count(), new Random()::nextBoolean);
        Record record = participants.go(ladder, gameResult);

        PrintView.printResult(participants, ladder, gameResult);
        showRecord(record);
    }

    private static void showRecord(Record record) {
        String participant = InputView.participant();
        PrintView.printFinalResult(participant, record);

        if (!participant.equals("all")) {
            showRecord(record);
        }
    }
}