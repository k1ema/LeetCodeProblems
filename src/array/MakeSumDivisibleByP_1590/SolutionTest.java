package array.MakeSumDivisibleByP_1590;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.minSubarray(new int[] {3, 1, 4, 2}, 6));
        assertEquals(2, s.minSubarray(new int[] {6, 3, 5, 2}, 9));
        assertEquals(0, s.minSubarray(new int[] {1, 2, 3}, 3));
        assertEquals(-1, s.minSubarray(new int[] {1, 2, 3}, 7));
        assertEquals(0, s.minSubarray(new int[] {1000000000, 1000000000, 1000000000}, 3));
        assertEquals(-1, s.minSubarray(new int[] {4, 4, 2}, 7));
        assertEquals(1, s.minSubarray(new int[] {4, 5, 8, 5, 4}, 7));
        assertEquals(-1, s.minSubarray(new int[] {3, 6, 8, 1}, 8));
        assertEquals(1, s.minSubarray(new int[] {2, 8, 7, 3, 6, 3, 19, 19, 4, 10}, 74));
        assertEquals(55, s.minSubarray(new int[] {2695, 2079, 4904, 145, 5966, 7055, 2317, 1868, 2783, 6397, 251, 6364, 5212, 7187, 5757, 7350, 5942, 2712, 3681, 2783, 51, 1153, 3485, 1393, 4500, 6278, 3376, 7192, 1481, 7276, 5086, 7696, 51, 5719, 4597, 7799, 4911, 6990, 6300, 4348, 616, 6123, 140, 4600, 2512, 7254, 6438, 1934, 2645, 5813, 6152, 7262, 6285, 7287, 3679, 5222, 774, 5057, 7619, 396, 1268, 2511, 7817, 6876, 7327, 7537, 7350, 7327, 1435, 5614, 130, 2274, 819, 4588, 5942, 5680, 3304, 2337, 2264, 5581, 7618, 1295, 295, 3660, 5892, 7653, 6748, 7720, 6033, 6833, 3361, 3711, 7837, 4842, 2239, 6862, 542, 7832, 785, 6524, 2299, 1924, 4791, 3615, 2074, 2374, 3528, 4440, 1135, 6077, 157, 7633, 7775, 1208, 7548, 1006, 6587, 1649, 2515, 5036, 3478, 6255, 3682, 302, 975, 4707, 4762, 5382, 59, 3612, 7491, 4575, 6008, 1024, 188, 4783, 7848, 3288, 1977, 6063, 6247, 6120, 69, 531, 4279, 1982, 6989, 5525, 604, 66, 7633, 3602, 3754, 1834, 4218, 1062, 3318, 5460, 7259, 5870, 5787, 5808, 2513, 5068, 7203, 4173, 988, 934, 6719, 7244, 1986, 6394, 661, 2710, 2562, 2678, 4167, 6424, 1303, 4492, 4770, 5184, 7544, 5220, 5868, 6670, 4266, 6348, 7207, 1919, 4124, 5273, 815, 3571, 3958, 4017, 6246, 4256, 6128, 4536, 2562, 1586, 3871, 6918, 5336, 1452, 6464, 3716, 1702, 2045, 7280, 1203, 7458, 6849, 979, 1311, 1986, 77, 4494, 1335, 1332, 5852, 2326, 7077, 7393, 1223, 7386, 7500, 91, 3844, 278, 1190, 973, 1305, 4160, 6257, 6006, 4227, 1604, 6246, 870, 2303, 975, 2489, 4280, 4353, 597, 4006, 5386, 3049, 6358, 4650, 2057, 6627, 626, 4524, 6884, 3294, 2909, 7310, 2426, 6974, 4116, 2121, 2145, 943, 1219, 238, 2679, 5733, 10, 6979, 1104, 2043, 2886, 1416, 4033, 6462, 3917, 3754, 4289, 4110, 280, 6036, 3743, 2956, 2793, 1286, 2579, 4722, 5683, 6787, 3058, 5200, 2024, 6735, 6852, 7795, 3535, 6999, 5906, 1451, 2945, 367, 6067, 3072, 1186, 2225, 3498, 3621, 4342, 4762, 867, 7743, 2810, 221, 4803, 3535, 2189, 524, 1520, 5834, 1355, 1417, 6680, 7587, 2644, 5001, 4036, 3473, 7750, 507, 5703, 1162, 4121, 1221, 2529, 1139, 1957, 5937, 4081, 1695, 3038, 2562, 4816, 1425, 2155, 607, 6052, 5333, 3036, 641, 332, 2813, 5717, 3854, 5679, 5107, 7383, 7628, 5116, 5645, 1547, 7379, 5579, 3145, 2031, 4528, 3271, 3945, 7441, 4338, 5540, 3340, 2009, 5012, 1226, 6493, 2793, 6533, 4002, 856, 7745, 6352, 2606, 5378, 819, 5658, 4403, 3796, 1977, 4840, 5653, 1063, 3995, 4525, 4171, 7383, 2619, 3118, 6481, 2965, 2033, 5894, 579, 6252, 5999, 4632, 6264, 2330, 7274, 6963, 4367, 5372, 1428, 6350, 7529, 7203, 1019, 2580, 455, 180, 5955, 2789, 4282, 3308, 645, 7301, 7617, 5976, 731, 5661, 4444, 3657, 7698, 115, 1139, 2408, 4668, 1900, 4615, 4532, 3361, 1469, 3546, 113, 5099, 2078, 4296, 3770, 7297, 2028, 3523, 572, 604, 3094, 5853, 905, 5657, 4785, 7622, 4935, 5136, 6564, 16, 7758, 1850, 6659, 5351, 5119, 3516, 790, 709, 1674, 1007, 3560, 7116, 6129, 93, 3575, 6451, 3373, 6901, 5467, 4499, 893, 880, 555, 5313, 61, 6622, 4980, 1456, 6629, 236, 5823, 1394, 5565, 3255, 2952, 2585, 643, 3274, 2837, 6285, 1858, 2634, 469, 4310, 3167, 3195, 518, 5690, 7654, 5086, 6259, 5676, 1649, 3118, 1305, 2863, 1385, 1994, 7647, 6782, 1671, 5115, 3597, 3862, 6558, 4437, 2978, 5486, 5730, 1340, 162, 1280, 1771, 1436, 225, 1338, 4485, 6702, 6572, 3384, 684, 2626, 1296, 2264, 226, 112, 4257, 4290, 3155, 6825, 4144, 1211, 6460, 6503, 149, 2524, 727, 1448, 746, 4425, 2759, 4490, 4769, 5049, 6615, 6725, 1842, 4459, 6251, 1455, 310, 6880, 5875, 7183, 2689, 258, 5201, 2242, 4911, 1442, 7618, 729, 1578, 1617, 4597, 4792, 4091, 4228, 6904, 3091, 5593, 5307, 5161, 5612, 2126, 4377, 2350, 7744, 3546, 7334, 2438, 7662, 2953, 714, 3857, 1758, 7126, 1184, 265, 6278, 7237, 6026, 7082, 2617, 1326, 4651, 6082, 3182, 2499, 952, 3440, 7651, 1905, 5561, 1003, 5452, 3377, 1705, 6003, 6573, 3271, 1405, 2689, 3679, 4518, 7533, 6346, 6925, 2467, 500, 5475, 292, 1631, 3765, 7307, 3395, 2660, 6321, 2813, 7744, 1993, 581, 2329, 7307, 3163, 2694, 348, 3036, 6127, 2457, 1861, 3794, 7785, 1210, 1, 6223, 1597, 2688, 709, 110, 6944, 7329, 3348, 6646, 5076, 1774, 6713, 5730, 126, 674, 4556, 406, 5906, 2659, 5193, 5182, 4971, 4545, 6010, 6117, 7352, 3928, 7155, 3235, 4682, 6603, 5994, 6757, 4564, 2672, 97, 3454, 6766, 7483, 3248, 5094, 4489, 4158, 4191, 1190, 6803, 4900, 5203, 5300, 7435, 2719, 2431, 597, 3086, 1558, 139, 3713, 4325, 5470, 7374, 3855, 1742, 1678, 5556, 1423, 7186, 6386, 6448, 1678, 2016, 1599, 6622, 950, 6025, 4566, 5487, 4786, 5794, 6385, 3700, 3825, 5232, 510, 3158, 4778, 7332, 2472, 6512, 2497, 5791, 6972, 1157, 6037, 3649, 4360, 3666, 5651, 889, 4658, 425, 6084, 6964, 1113, 7473, 4095, 7030, 255, 5175, 298, 5455, 2873, 544, 1850, 2718, 2294}, 577041));
    }
}