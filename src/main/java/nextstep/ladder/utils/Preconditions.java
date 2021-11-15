package nextstep.ladder.utils;

import java.util.Collection;

public class Preconditions {
    private Preconditions() {
        throw new IllegalStateException("Preconditions 직접 생성 금지");
    }

    public static <T> void checkNotNull(T reference, String errorMessage) {
        if (reference == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkEmpty(Collection<?> coll, String errorMessage) {
        if (coll == null || coll.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkString(String reference, String errorMessage) {
        if (reference == null || reference.length() == 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkMinimumSize(int size, int minimumSize, String errorMessage) {
        if (size < minimumSize) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkMaximumSize(int size, int maximumSize, String errorMessage) {
        if (size > maximumSize) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}