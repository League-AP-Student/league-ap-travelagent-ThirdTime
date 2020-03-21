import java.util.List;

public class Trip {
	private List<Flight> flights;

	public int getDuration() {
		if (flights.get(0) == null) {
			return 0;
		} else {
			return flights.get(0).getDeparturetime().minutesUntil(flights.get(flights.size() - 1).getArrivalTime());
		}
	}

	public int getShortestLayover() {
		if (flights.get(1) == null) {
			return -1;
		} else {
			int shortestLayover = 999999999;
			int currentInterval = 0;
			for(int i = 0; i < flights.size();i++) {
				if(i < flights.size()-1)
					currentInterval = flights.get(i).getArrivalTime().minutesUntil(flights.get(i+1).getDeparturetime());
					if(currentInterval < shortestLayover) {
						shortestLayover = currentInterval;
					}
			}
			return shortestLayover;
		}
	}
}
