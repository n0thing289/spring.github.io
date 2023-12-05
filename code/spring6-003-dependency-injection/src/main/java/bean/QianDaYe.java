package bean;

import java.util.Arrays;

public class QianDaYe {
    private String[] aiHaos;
    private Girl[] girls;

    public void setGirls(Girl[] girls) {
        this.girls = girls;
    }

    public void setAiHaos(String[] aiHaos) {
        this.aiHaos = aiHaos;
    }

    @Override
    public String toString() {
        return "QianDaYe{" +
                "aiHaos=" + Arrays.toString(aiHaos) +
                ", girls=" + Arrays.toString(girls) +
                '}';
    }
}
