public class Classifier {
    public static void main(String args[]) {
        if (args.length < 3) {
            System.out.println("The program needs 3 arguments to run.");
            return;
        }
        if (args.length > 3) {
            System.out.println("The program needs 3 arguments to run.");
            return;
        }

        int beak_mm = Integer.parseInt(args[0]);
        int claw_mm = Integer.parseInt(args[1]);
        String color = args[2];
        Classifier clf = new Classifier();

        boolean ta = clf.isTypeA(beak_mm, claw_mm, color);
        boolean tb = clf.isTypeB(beak_mm, claw_mm, color);
        boolean tc = clf.isTypeC(beak_mm, claw_mm, color);

        String a = "";
        String b = "";
        String c = "";

        if(ta == false && tb ==  false && tc == false){
            System.out.println("This bird is not part of the study");
        }
        else {
            if (ta == true) {
                a = "A";
            }
            if (tb == true) {
                b = "B";
            }
            if (tc == true) {
                c = "C";
            }
        }


        System.out.println("The type of bird is "+ a +""+ b +""+ c);

    }


    public boolean isTypeA(int beak_mm, int claw_mm, String color) {
        boolean typeA;

        if (beak_mm == 1 && claw_mm == 0 && color.equals("Grey")) {
            typeA = true;

        } else if (beak_mm == 2 && claw_mm == 1 && color.equals("Grey")) {
            typeA = true;

        } else if (beak_mm == 3 && claw_mm == 2 && color.equals("Grey")) {
            typeA = true;

        } else if (beak_mm == 4 && claw_mm == 3 && color.equals("Grey")) {
            typeA = true;

        } else if (beak_mm == 4 || beak_mm == 5 && claw_mm == 4 && color.equals("Grey")) {
            typeA = true;

        } else {
            typeA = false;
        }

        return typeA;
    }

    public boolean isTypeB(int beak_mm, int claw_mm, String color) {
        boolean typeB;

        if (beak_mm == 4 && claw_mm == 4 || claw_mm == 5 && color.equals("Grey")) {
            typeB = true;

        } else if (beak_mm == 5 && claw_mm == 6 || claw_mm == 7 && color.equals("Grey") || color.equals("Blue")) {
            typeB = true;

        } else if (beak_mm == 6 && claw_mm == 8 || claw_mm == 9 && color.equals("Blue")) {
            typeB = true;

        } else if (beak_mm == 7 && claw_mm == 10 && color.equals("Blue")) {
            typeB = true;

        } else if (beak_mm == 8 && claw_mm == 11 && color.equals("Blue")) {
            typeB = true;

        } else {
            typeB = false;

        }

        return typeB;
    }

    public boolean isTypeC(int beak_mm, int claw_mm, String color) {
        boolean typeC;

        if (beak_mm == 5 && claw_mm == 6 || claw_mm == 7 && color.equals("Blue") || color.equals("Green")) {
            typeC = true;

        } else if (beak_mm == 6 && claw_mm == 8 || claw_mm == 9 && color.equals("Green")) {
            typeC = true;

        } else if (beak_mm == 7 && claw_mm == 10 && color.equals("Green")) {
            typeC = true;

        } else if (beak_mm == 8 && claw_mm == 11 && color.equals("Green")) {
            typeC = true;

        } else if (beak_mm == 9 && claw_mm == 12 && color.equals("Green")) {
            typeC = true;

        } else {
            typeC = false;

        }

        return typeC;
    }
}