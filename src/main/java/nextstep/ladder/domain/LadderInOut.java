package nextstep.ladder.domain;

import java.util.List;

public class LadderInOut {
    private final List<String> results;

    private final Users users;

    public LadderInOut(List<String> results, Users users) {
        validateLength(results, users.getCountOfUser());
        this.results = results;
        this.users = users;
    }

    private void validateLength(List<String> results, int countOfUser) {
        if(results.size() != countOfUser) {
            throw new IllegalArgumentException("결과와 사용자 수는 동일해야 합니다.");
        }
    }

    public int indexOfUser(String name) {
        return users.indexOfUser(name);
    }

    public String getResult(int idx) {
        return results.get(idx);
    }

    public String getUserName(int idx) {
        return users.getUserName(idx);
    }

    public int getCountOfUser() {
        return users.getCountOfUser();
    }
}