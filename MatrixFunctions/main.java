import java.util.*;

interface Matrix {
    public double getElem(int i, int j);

    public void setElem(int i, int j, double value);

    public Matrix add(Matrix other);

    public Matrix multiply(Matrix other);
}

class Matrix2DArray implements Matrix {
    private double[][] data;
    public int h;
    public int w;

    public Matrix2DArray(int height, int width) {
        this.h = height;
        this.w = width;
        data = new double[height][width];
    }

    public void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matrix has " + h + " height and " + w + " width");

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print("Enter [" + i + "][" + j + "] value: ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    // Getters and Setters
    public double getElem(int i, int j) {
        return data[i][j];
    }

    public void setElem(int i, int j, double value) {
        data[i][j] = value;
    }

    // Add Matrix
    public Matrix add(Matrix other) {
        Matrix ans = new Matrix2DArray(this.h, this.w);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                double sum = this.getElem(i, j) + other.getElem(i, j);
                ans.setElem(i, j, sum);
            }
        }
        return ans;
    }

    // Multiply Matrix
    public Matrix multiply(Matrix other) {
        Matrix ans = new Matrix2DArray(this.h, this.w);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < h; k++) {

                    // result[i][j] += X[i][k] * Y[k][j]
                    double x = ans.getElem(i, j);
                    x += this.getElem(i, k) * other.getElem(k, j);
                    ans.setElem(i, j, x);
                }
            }
        }
        return ans;
    }

    // Kind of a tostring
    public void printMatrix() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(this.getElem(i, j) + "  ");
            }
            System.out.println(" ");
        }
    }

    @Override
    public String toString() {
        printMatrix();
        return "Matrix is above ^";
    }
}

abstract class MatrixLin implements Matrix {
    protected double data[];
    protected int height;
    protected int width;

    abstract public Matrix2DArray deLinearized();

    protected int min(int a, int b){
        if (a<b){
            return a;
        }
        else {
            return b;
        }
    }

}

class MatrixRowWise extends MatrixLin {
    public MatrixRowWise(int w) {
        this.height = 0;
        this.width = w;
        data = new double[width];
    }

    // insert elements in array
    public void insertt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*Matrix has " + 0 + " height and " + this.width + " width*");

        for (int i = 0; i < width; i++) {
            System.out.print("Enter [0][" + i + "] value: ");
            data[i] = sc.nextInt();
        }
    }

    // Getters and Setters
    public double getElem(int i, int j) {
        return data[j];
    }

    public void setElem(int i, int j, double value) {
        data[j] = value;
    }

    public void printArray() {
        for (int x = 0; x < width; x++) {
            System.out.print(this.getElem(0, x) + "  ");
        }
    }

    public String toString() {
        printArray();
        return "\nInserted Array";
    }

    public Matrix2DArray deLinearized() {

        double x = Math.sqrt(width);
        int y = (int) x;

        Matrix2DArray res = new Matrix2DArray(y, y);
        int r = 0;
        for (int p = 0; p < y; p++) {
            for (int q = 0; q < y; q++) {
                res.setElem(p, q, data[r]);
                r++;
            }
        }

        return res;
    }

    public Matrix add(Matrix other) {
        Matrix ans = new MatrixRowWise(width);
        for (int x=0; x<width; x++){
            double sum;
            sum = data[x] + other.getElem(0, x);
            ans.setElem(0, x, sum);
        }
        return ans;
    }

    public Matrix multiply(Matrix other) {
        System.out.println("Two Row matrix cant be multiplied");
        return other;
    }

}

class MatrixColWise extends MatrixLin {
    public MatrixColWise(int height) {
        super.height = height;
        super.width = 0;
        data = new double[height];
    }

    public double getElem(int i, int j) {
        return data[i];
    }

    public void setElem(int i, int j, double value) {
        data[i] = value;
    }

    // insert elements in array
    public void insertt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matrix has " + height + " height and " + 0 + " width");

        for (int i = 0; i < height; i++) {
            System.out.print("Enter [" + i + "][0] value: ");
            data[i] = sc.nextInt();
        }
    }
    public void printArray() {
        for (int x = 0; x < height; x++) {
            System.out.print(this.getElem(x, 0) + "  ");
        }
    }

    public String toString() {
        printArray();
        return "\nInserted Array";
    }
    
    public Matrix2DArray deLinearized() {

        double x = Math.sqrt(height);
        int y = (int) x;

        Matrix2DArray res = new Matrix2DArray(y, y);
        int r = 0;
        for (int p = 0; p < y; p++) {
            for (int q = 0; q < y; q++) {
                res.setElem(q, p, data[r]);
                r++;
            }
        }
        return res;
    }

    public Matrix add(Matrix other) {
        Matrix ans = new MatrixColWise(height);
        for (int x=0; x<height; x++){
            double sum;
            sum = data[x] + other.getElem(x, 0);
            ans.setElem(x, 0, sum);
        }
        return ans;
    }

    public Matrix multiply(Matrix other) {
        System.out.println("Two Column matrix cant be multiplied");
        return other;
    }
}
// ---------------------------------------------------

class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter:\n\t1. Square Matrix\t2. Row Matrix\t3. Column Matrix");
        int i = sc.nextInt();

        if (i == 1){
            System.out.println("Enter Number of rows and columns: ");
            int j = sc.nextInt();
            System.out.println("**FIRST Matrix**");
            Matrix2DArray a = new Matrix2DArray(j, j);
            a.insert();
            System.out.println("**SECOND Matrix**");
            Matrix2DArray b = new Matrix2DArray(j, j);
            b.insert();

            int k = -1;
            while (k != 0)
            {
                System.out.println("\nNow Enter\n\t1. Print First Matrix\t2. Print Second Matrix\t3. Add Two\t4. Multiply Two Matrix\t 0. Exit");
                k = sc.nextInt();
                if (k == 1) {
                    System.out.println(a.toString());
                }
                if (k == 2) {
                    System.out.println(b.toString());
                }
                if (k == 3){
                    System.out.println((a.add(b)).toString());
                    
                }
                if (k == 4){
                    System.out.println((a.multiply(b)).toString());
                }
            }
        }

        if (i == 2)
        {
            System.out.println("Enter Number of Rows in row Matrix: ");
            int x = sc.nextInt();
            System.out.println("**FIRST Matrix**");
            MatrixRowWise c = new MatrixRowWise(x);
            c.insertt();;
            System.out.println("**SECOND Matrix**");
            MatrixRowWise d = new MatrixRowWise(x);
            d.insertt();

            int m = -1;
            while (m != 0)
            {
                System.out.println("\nNow Enter\n\t1. Print First Matrix\t2. Print Second Matrix\t3. Delinearize First Matrix\t4. Add Two\t5. Multiply Two Matrices\t 0. Exit");
                m = sc.nextInt();
                if (m == 1) {
                    System.out.println(c.toString());
                }
                if (m == 2) {
                    System.out.println(d.toString());
                }
                if (m == 3){
                    System.out.println("Delinearized First Matrix");
                    System.out.println((c.deLinearized()).toString());
                }
                if (m == 4){
                    System.out.println((c.add(d)).toString());
                }
                if (m == 5){
                    c.multiply(d);
                }
            }
        }

        if (i == 3)
        {
            System.out.println("Enter Number of Column in column Matrix: ");
            int x = sc.nextInt();

            System.out.println("**FIRST Matrix**");
            MatrixColWise e = new MatrixColWise(x);
            e.insertt();

            System.out.println("**SECOND Matrix**");
            MatrixColWise f = new MatrixColWise(x);
            f.insertt();

            int m = -1;
            while (m != 0)
            {
                System.out.println("\nNow Enter\n\t1. Print First Matrix\t2. Print Second Matrix\t3. Delinearize First Matrix\t4. Add Two\t5. Multiply Two Matrices\t 0. Exit");
                m = sc.nextInt();
                if (m == 1) {
                    System.out.println(e.toString());
                }
                if (m == 2) {
                    System.out.println(f.toString());
                }
                if (m == 3){
                    System.out.println("Delinearized First Matrix");
                    System.out.println((e.deLinearized()).toString());
                }
                if (m == 4){
                    System.out.println((e.add(f)).toString());
                }
                if (m == 5){
                    e.multiply(f);
                }
            }
        }        
    }
}



        // System.out.println(a.toString());
        
        // Matrix2DArray b = new Matrix2DArray(2, 2);
        // b.insert();
        // System.out.println(b.toString());

        // System.out.println("----------------Adding two Matrix--------------------");
        // Matrix c = new Matrix2DArray(2, 2);
        // c = a.add(b);
        // c.toString();

        // System.out.println("----------------Multiplying two
        // Matrix--------------------");
        // Matrix d = new Matrix2DArray(2, 2);
        // d = a.multiply(b);
        // d.toString();

        // System.out.println("----------------Creating Rowwise--------------------");
        // MatrixRowWise e = new MatrixRowWise(4);
        // e.insertt();
        // System.out.println(e.toString());

        // System.out.println("----------------Delinearizing Rowwise--------------------");
        // System.out.println((e.deLinearized()).toString());


        // System.out.println("----------------Creating ColumnWise--------------------");
        // MatrixColWise f = new MatrixColWise(4);
        // f.insertt();
        // System.out.println(f.toString());
        
        // System.out.println("----------------Adding ColumnWise--------------------");
        // MatrixColWise g = new MatrixColWise(4);
        // g.insertt();
        // Matrix sum = new MatrixColWise(4);
        // sum = f.add(g);
        // System.out.println(sum.toString());


        // System.out.println("----------------Delinearizing ColumnWise array--------------------");
        // System.out.println((f.deLinearized()).toString());
