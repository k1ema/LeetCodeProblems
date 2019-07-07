package graph.ReconstructItinerary_332;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        List<String> itinerary = s.findItinerary(Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO")));
        assertEquals(Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC"), itinerary);

        itinerary = s.findItinerary(Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"), Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "SFO")));
        assertEquals(Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"), itinerary);

        itinerary = s.findItinerary(Arrays.asList(Arrays.asList("JFK", "KUL"), Arrays.asList("JFK", "NRT"),
                Arrays.asList("NRT", "JFK")));
        assertEquals(Arrays.asList("JFK", "NRT", "JFK", "KUL"), itinerary);

        itinerary = s.findItinerary(Arrays.asList(Arrays.asList("JFK", "KUL"), Arrays.asList("JFK", "NRT"),
                Arrays.asList("KUL", "JFK")));
        assertEquals(Arrays.asList("JFK", "KUL", "JFK", "NRT"), itinerary);
    }
}
