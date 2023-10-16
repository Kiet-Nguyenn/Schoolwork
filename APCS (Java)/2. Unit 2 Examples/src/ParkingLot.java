public class ParkingLot {
    public static void main(String[] args){
        boolean[][] parkingLot = new boolean[5][5];

        /* Parking spots are empty when they are false. A true value indicates a spot is taken.
           Chad thinks his car is super nice - he refuses to park next to ANYONE.
           Given [r][c] we need to determine if chad will park it, man.

           Example 1 : chad will park
                F F F
                F C F
                F F F

           Example 2 : chad won't park
                F F T
                F C F
                F F F

           Chad is at [r,c]
           [r-1,c-1] [r-1,c] [r-1,c+1]
           [r,c-1]   [r,c]   [r,c+1]
           [r+1,c-1] [r+1,c] [r+1,c+1]

         */

        parkingLot[1][2] = true;
        for(int r = 0; r < parkingLot.length; r++){
            for(int c = 0; c < parkingLot[r].length; c++){
                if(Math.random() < .15) //This randomly assigns 15% of elements true
                    parkingLot[r][c] = true;
                System.out.print(parkingLot[r][c] ? "[X] " : "[ ] ");
            }
            System.out.println();
        }

        System.out.println("Will chad park at [2][2]: " + willChadPark(parkingLot, 2,2));
        System.out.println("Will chad park at [0][0]: " + willChadPark(parkingLot, 0,0));
        System.out.println("Will chad park at [4][4]: " + willChadPark(parkingLot, 4,4));

    }

    public static boolean willChadPark(boolean[][] lot, int row, int col){
        for(int r = row-1; r <= row+1; r++){
            for(int c = col-1; c<= col+1; c++){
                if(r >= 0 && c >= 0 && r < lot.length && c < lot[0].length)
                if(lot[r][c]) return false;
            }
        }
        return true;
    }
}
