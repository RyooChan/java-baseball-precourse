package model;

import java.util.Objects;

public class HintDto {
    private final int strikeCount;
    private final int ballCount;

    public HintDto(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HintDto hintDto = (HintDto) o;
        return strikeCount == hintDto.strikeCount && ballCount == hintDto.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}
