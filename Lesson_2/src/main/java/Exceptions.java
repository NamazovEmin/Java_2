public class Exceptions {


    public static void main(String[] args) {

        String[][] massiv = {{"a", "0", "1", "12"},{"7", "0", "1", "12"}, {"8", "1", "2", "3"}, {"8", "1", "2", "3"}};

        try {

            correctMassiv(massiv);
            int result = listMassiv(massiv);
            System.out.println(result);
        } catch (MyArraySizeException e) {
            System.out.println(new MyArraySizeException().getSendMessage());
        } catch (MyArrayDataException e) {
            System.out.println(new MyArrayDataException().getSendMessage());
        }

    }

    private static void correctMassiv(String[][] array)throws MyArraySizeException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }
    }

    public static int listMassiv(String[][] array) throws MyArrayDataException, MyArraySizeException {
        try {
            int a = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    a = a + Integer.parseInt(array[i][j]);

                }
            }
            return a;
        } catch (NumberFormatException e) {
            throw new MyArrayDataException();
        }catch (IndexOutOfBoundsException e){
            throw new MyArraySizeException();
        }

    }
}



