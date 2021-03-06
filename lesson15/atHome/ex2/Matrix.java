package lesson15.atHome.ex2;

public class Matrix<T extends Number> {
    private T[][] twoDimMatrix;
    private int numOfRows;
    private int numOfColumns;

    public Matrix(T[][] aTwoDimMatrix) {
        twoDimMatrix = aTwoDimMatrix.clone();
        numOfRows = twoDimMatrix.length;
        numOfColumns = twoDimMatrix[0].length;
    }

    public static void main(String[] args) {
        Matrix<Float> m = new Matrix<>(new Float[][]{{1f, 1f}, {1f, 1f}});
        m.printMatrix();
        m.matrixMultiplication(new Matrix<>(new Integer[][]{{1, 1}, {1, 1}}));
        m.printMatrix();
        m.multiplyByTheNumber((float) 5);
        m.printMatrix();
        m.addOfMatrix(m);
        m.printMatrix();
    }

    public T getElement(int x, int y) {
        return twoDimMatrix[x][y];
    }

    public int getRows() {
        return numOfRows;
    }

    public int getColumns() {
        return numOfColumns;
    }

    public void setElement(int x, int y, T element) {
        twoDimMatrix[x][y] = element;
    }

    public void addOfMatrix(Matrix anotherMatrix) {
        if (numOfRows == anotherMatrix.getRows() && numOfColumns == anotherMatrix.getColumns()) {
            for (int i = 0; i < numOfRows; i++) {
                for (int j = 0; j < twoDimMatrix[0].length; j++) {
                    Number n = twoDimMatrix[i][j].doubleValue() + anotherMatrix.getElement(i, j).doubleValue();
                    twoDimMatrix[i][j] = (T) n;
                }
            }
        } else {
            System.out.println("Dimensions of matrices are not equal");
        }

    }

    public void multiplyByTheNumber(Number number) {
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                Number n = twoDimMatrix[i][j].doubleValue() * number.doubleValue();
                twoDimMatrix[i][j] = (T) n;
            }
        }
    }

    public void matrixMultiplication(Matrix anotherMatrix) {
        if (numOfRows == anotherMatrix.getColumns()) {
            for (int i = 0; i < twoDimMatrix.length; i++) {
                for (int j = 0; j < twoDimMatrix[0].length; j++) {
                    Number temp = 0;
                    for (int k = 0; k < anotherMatrix.numOfRows; k++) {
                        temp = temp.doubleValue() + twoDimMatrix[i][j].doubleValue() * anotherMatrix.getElement(k, i).doubleValue();
                    }

                    twoDimMatrix[i][j] = (T) temp;
                }
            }
        } else {
            System.out.println("Dimensions of matrices are not equal");
        }
    }

    public void printMatrix() {
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                System.out.print(twoDimMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
