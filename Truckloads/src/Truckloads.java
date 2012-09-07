public class Truckloads {

    public int numTrucks(int numCrates, int loadSize) {
        if (numCrates <= loadSize) return 1;
        int left = (numCrates + 1) / 2;
        int right = numCrates / 2;

        return numTrucks(left, loadSize) + numTrucks(right, loadSize);
    }

}
