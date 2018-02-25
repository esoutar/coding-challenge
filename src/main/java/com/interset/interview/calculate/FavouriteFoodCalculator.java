package com.interset.interview.calculate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.interset.interview.model.DataRow;

public class FavouriteFoodCalculator implements StatCalculator {

	static final String MESSAGE = "Three favourite foods: %s, %s, %s";

	/* (non-Javadoc)
	 * @see com.interset.interview.calculate.StatCalculator#calculateStat(java.util.List)
	 */
	@Override
	public String calculateStat(List<DataRow> rows) {
		Map<String, List<DataRow>> groupedFoods = rows.stream().collect(Collectors.groupingBy(DataRow::getFavouriteFood));
		List<FoodPopularity> foodPopularity = new ArrayList<FoodPopularity>();
		
		for(Entry<String, List<DataRow>> e : groupedFoods.entrySet()) {
			foodPopularity.add(new FoodPopularity(e.getKey(), e.getValue().size()));
		}
		
		Collections.sort(foodPopularity, new Comparator<FoodPopularity>() {

			@Override
			public int compare(FoodPopularity a, FoodPopularity b) {
				return b.popularity - a.popularity;
			}
			
		});
		
		return String.format(MESSAGE, formatMessage(foodPopularity.get(0)), 
										formatMessage(foodPopularity.get(1)), 
										formatMessage(foodPopularity.get(2)));
	}
	
	private String formatMessage(FoodPopularity foodPopularity) {
		return foodPopularity.food + " (" + foodPopularity.popularity + ")";
	}

	private class FoodPopularity {
		public final String food;
		public final int popularity;
		
		public FoodPopularity(String food, int popularity) {
			super();
			this.food = food;
			this.popularity = popularity;
		}
	}
}
