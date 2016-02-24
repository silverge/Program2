//coordinate class

public class Point {
    

        private int x;
        private int y;

        /**
         * The constructor for the coord class
         * @param xcord the x cord
         * @param ycord the ycord
         */
        public Point(int xcord, int ycord)
        {
            x = xcord;
            y = ycord;
        }

        /**
         * get the x coord
         * @return the xcord
         */
        public int x()
        {
            return x;
        }
        /**
         * get the y coord
         * @return the ycord
         */
        public int y()
        {
            return y;
        }
        /**
         * returns a string of characters
         * @return the string
         */
        public String toString()
        {
            return x + ", " + y;
        }
}
