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
}
