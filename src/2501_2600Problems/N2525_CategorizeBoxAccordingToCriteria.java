public class N2525_CategorizeBoxAccordingToCriteria {

    class Solution {
        public String categorizeBox(int length, int width, int height, int mass) {
            boolean isBulky = isBulky(length, width, height);
            boolean isHeavy = isHeavy(mass);
            if(isBulky && isHeavy) return "Both";
            if(isBulky) return "Bulky";
            if(isHeavy) return "Heavy";
            return "Neither";
        }
        private boolean isBulky(int len, int wid, int hei){
            int any = 10000;
            if(len >= any || wid >= any || hei >= any) return true;

            long a = (long) len * wid * hei;
            return a >= 1000000000L;
        }

        private boolean isHeavy(int mass){
            return mass >= 100;
        }
    }
}
