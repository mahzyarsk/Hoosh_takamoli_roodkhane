public class Gen {
private  int[] GEN = new int[16];
private int FITNESS;

    public Gen(int[] GEN, int FITNESS) {
        this.GEN = GEN;
        this.FITNESS = FITNESS;
    }

    public int getFITNESS() {
        return FITNESS;
    }

    public void setFITNESS(int FITNESS) {
        this.FITNESS = FITNESS;
    }

    public int[] getGEN() {
        return GEN;
    }

    public void setGEN(int[] GEN) {
        this.GEN = GEN;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gen: [");

        // تبدیل آرایه GEN به رشته
        for (int i = 0; i < GEN.length; i++) {
            sb.append(GEN[i]);
            if (i < GEN.length - 1) {
                sb.append(", "); // جداکننده بین عناصر
            }
        }

        sb.append("], Fitness: ").append(FITNESS).append("\n");

        return sb.toString();
    }
}
