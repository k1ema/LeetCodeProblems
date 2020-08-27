package binarySearch.FindRightInterval_436;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {-1}, s.findRightInterval(new int[][] {{1, 2}}));
        assertArrayEquals(new int[] {-1, 0, 1}, s.findRightInterval(new int[][] {{3, 4}, {2, 3}, {1, 2}}));
        assertArrayEquals(new int[] {-1, 2, -1}, s.findRightInterval(new int[][] {{1, 4}, {2, 3}, {3, 4}}));
        assertArrayEquals(new int[] {-1, 0, 0, 0}, s.findRightInterval(new int[][] {{18, 19}, {2, 8}, {1, 17}, {7, 10}}));
        assertArrayEquals(new int[] {8, 51, 76, 62, 35, 78, 51, 86, 32, 19, 51, 77, 105, 56, 102, 19, 44, 47, 59, 32, 24, 91, 32, 81, 85, 59, 126, 106, 45, 65, 128, 58, 45, 101, 45, 69, 116, 87, 118, 61, 108, 114, 136, 80, 130, 91, 75, 139, 143, 107, 52, 105, 61, 98, 123, 146, 81, 154, 89, 63, 83, 128, 112, 88, 66, 119, 144, 76, 97, 103, 169, 153, 108, 87, 140, 90, 140, 114, 104, 149, 96, 176, 112, 85, 102, 181, 92, 92, 140, 188, 179, 115, 98, 176, 147, 162, 113, 135, 137, 144, 102, 199, 174, 132, 142, 164, 184, -1, -1, 114, 120, 143, 158, 189, 150, -1, 159, -1, 187, 132, 181, 179, -1, 132, -1, 194, 140, 158, 135, 192, 173, 197, -1, 186, -1, 157, -1, 150, -1, 141, -1, 173, 181, -1, 161, -1, 187, -1, 184, 156, -1, -1, -1, 173, -1, 179, -1, -1, 164, 186, 184, 168, 176, -1, -1, -1, 187, -1, -1, -1, 197, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 199, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                s.findRightInterval(new int[][] {{-100, -92}, {-99, -49}, {-98, -24}, {-97, -38}, {-96, -65}, {-95, -22}, {-94, -49}, {-93, -14}, {-92, -68}, {-91, -81}, {-90, -49}, {-89, -23}, {-88, 5}, {-87, -44}, {-86, 2}, {-85, -81}, {-84, -56}, {-83, -53}, {-82, -41}, {-81, -68}, {-80, -76}, {-79, -9}, {-78, -68}, {-77, -19}, {-76, -15}, {-75, -41}, {-74, 26}, {-73, 6}, {-72, -55}, {-71, -35}, {-70, 28}, {-69, -42}, {-68, -55}, {-67, 1}, {-66, -55}, {-65, -31}, {-64, 16}, {-63, -13}, {-62, 18}, {-61, -39}, {-60, 8}, {-59, 14}, {-58, 36}, {-57, -20}, {-56, 30}, {-55, -9}, {-54, -25}, {-53, 39}, {-52, 43}, {-51, 7}, {-50, -48}, {-49, 5}, {-48, -39}, {-47, -2}, {-46, 23}, {-45, 46}, {-44, -19}, {-43, 54}, {-42, -11}, {-41, -37}, {-40, -17}, {-39, 28}, {-38, 12}, {-37, -12}, {-36, -34}, {-35, 19}, {-34, 44}, {-33, -24}, {-32, -3}, {-31, 3}, {-30, 69}, {-29, 53}, {-28, 8}, {-27, -13}, {-26, 40}, {-25, -10}, {-24, 40}, {-23, 14}, {-22, 4}, {-21, 49}, {-20, -4}, {-19, 76}, {-18, 12}, {-17, -15}, {-16, 2}, {-15, 81}, {-14, -8}, {-13, -8}, {-12, 40}, {-11, 88}, {-10, 79}, {-9, 15}, {-8, -2}, {-7, 76}, {-6, 47}, {-5, 62}, {-4, 13}, {-3, 35}, {-2, 37}, {-1, 44}, {0, 2}, {1, 99}, {2, 74}, {3, 32}, {4, 42}, {5, 64}, {6, 84}, {7, 105}, {8, 103}, {9, 14}, {10, 20}, {11, 43}, {12, 58}, {13, 89}, {14, 50}, {15, 114}, {16, 59}, {17, 117}, {18, 87}, {19, 32}, {20, 81}, {21, 79}, {22, 117}, {23, 32}, {24, 120}, {25, 94}, {26, 40}, {27, 58}, {28, 35}, {29, 92}, {30, 73}, {31, 97}, {32, 115}, {33, 86}, {34, 102}, {35, 57}, {36, 132}, {37, 50}, {38, 110}, {39, 41}, {40, 131}, {41, 73}, {42, 81}, {43, 101}, {44, 61}, {45, 136}, {46, 87}, {47, 127}, {48, 84}, {49, 56}, {50, 123}, {51, 150}, {52, 148}, {53, 73}, {54, 109}, {55, 79}, {56, 146}, {57, 118}, {58, 64}, {59, 86}, {60, 84}, {61, 68}, {62, 76}, {63, 134}, {64, 103}, {65, 160}, {66, 87}, {67, 112}, {68, 135}, {69, 104}, {70, 97}, {71, 166}, {72, 136}, {73, 112}, {74, 119}, {75, 166}, {76, 127}, {77, 137}, {78, 102}, {79, 127}, {80, 166}, {81, 99}, {82, 155}, {83, 123}, {84, 132}, {85, 171}, {86, 183}, {87, 173}, {88, 112}, {89, 110}, {90, 135}, {91, 160}, {92, 128}, {93, 109}, {94, 120}, {95, 130}, {96, 139}, {97, 109}, {98, 178}, {99, 152}}));
    }
}